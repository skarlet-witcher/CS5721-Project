package service.impl;

import Const.UserOperateStatusType;
import Const.UserOperateType;
import Const.UserTransactionTimeFilter;
import dao.IUserAccountDao;
import dao.IUserDao;
import dao.IUserHistoryDao;
import dao.IUserPayeeDao;
import dao.impl.UserAccountDao;
import dao.impl.UserDao;
import dao.impl.UserHistoryDao;
import dao.impl.UserPayeeDao;
import entity.UserAccountEntity;
import entity.UserEntity;
import entity.UserHistoryEntity;
import entity.UserPayeeEntity;
import org.iban4j.*;
import rpc.*;
import service.IUserCustomerHistoryService;
import service.IUserCustomerService;
import util.FaultFactory;
import util.IBANValidator;
import util.TimestampConvertHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserCustomerService implements IUserCustomerService {
    private static UserCustomerService instance = null;
    private IUserAccountDao userAccountDao = UserAccountDao.getInstance();
    private IUserDao userdao = UserDao.getInstance();
    private IUserPayeeDao userPayeeDao = UserPayeeDao.getInstance();
    private IUserHistoryDao userHistoryDao = UserHistoryDao.getInstance();
    private IUserCustomerHistoryService userCustomerHistoryService = UserCustomerHistoryService.getInstance();
    private static final Logger logger = Logger.getLogger(UserCustomerGrpc.class.getName());

    public static UserCustomerService getInstance() {
        if (instance == null) {
            return new UserCustomerService();
        }
        return instance;
    }

    @Override
    public List<UserAccountsReply> getAccounts(Long user_pk) throws Exception {
        try {
            List<UserAccountsReply> userAccountsReplies = new ArrayList<>();
            logger.info("UserCustomerService: Ready to get user account list");
            List<UserAccountEntity> userAccountList = userAccountDao.getUserAccountByUserId(user_pk);
            logger.info("UserCustomerService: How many result: " + userAccountList.size());

            logger.info("UserCustomerService: ready to set up user accounts reply");
            for (UserAccountEntity userAccount : userAccountList) {


                UserAccountsReply userAccountsReply = UserAccountsReply.newBuilder()
                        .setAccountPk(userAccount.getId())
                        .setAccountNumber(userAccount.getAccountNumber())
                        .setAccountType(userAccount.getAccountType().intValue())
                        .setCurrencyType(userAccount.getCurrencyType())
                        .setBalance(userAccount.getBalance().intValue())
                        .setStatus(userAccount.getStatus()).build();

                userAccountsReplies.add(userAccountsReply);
            }
            logger.info("UserCustomerService: How many result: " + userAccountsReplies.size());
            return userAccountsReplies;
        } catch (Exception E) {
            throw FaultFactory.throwFaultException(E.getMessage());
        }
    }

    @Override
    public UserProfileReply getUserProfile(Long user_pk) throws Exception {
        try {
            UserEntity userEntity = userdao.selectUserById(user_pk);
            UserProfileReply userProfileReply = UserProfileReply.newBuilder()
                    .setUserPk(userEntity.getId())
                    .setUserId(userEntity.getUserId())
                    .setFirstName(userEntity.getFirstName())
                    .setLastName(userEntity.getLastName())
                    .setGender(userEntity.getGender())
                    .setBirthDate(TimestampConvertHelper.mysqlToRpc(userEntity.getBirthDate()))
                    .setAddress(userEntity.getAddress())
                    .setEmail(userEntity.getEmail())
                    .setPhone(userEntity.getPhone()).build();
            return userProfileReply;

        } catch (Exception E) {
            throw FaultFactory.throwFaultException(E.getMessage());
        }


    }

    @Override
    public void editUserProfile(Long user_pk, String address, String email, String contactNum) throws Exception {
        try {
            int updateRows = userdao.updateUserProfileById(user_pk, address, email, contactNum);
            if(updateRows <= 0) {
                throw FaultFactory.throwFaultException("fail to update user profile");
            }
        } catch (Exception E) {
            throw FaultFactory.throwFaultException(E.getMessage());
        }
    }

    @Override
    public List<UserPayeesReply> getPayeeList(Long user_pk) throws Exception {
        try {
            List<UserPayeesReply> userPayeesReplies = new ArrayList<>();
            List<UserPayeeEntity> userPayeeEntityList = userPayeeDao.getPayeeListById(user_pk);

            for(UserPayeeEntity userPayeeEntity: userPayeeEntityList) {
                UserPayeesReply userPayeesReply = UserPayeesReply.newBuilder()
                        .setPayeePk(userPayeeEntity.getId())
                        .setName(userPayeeEntity.getName())
                        .setIban(userPayeeEntity.getIban()).build();
                userPayeesReplies.add(userPayeesReply);
            }
            return userPayeesReplies;

        } catch (Exception E) {
            throw FaultFactory.throwFaultException(E.getMessage());
        }
    }

    @Override
    public void addPayee(Long user_pk, String payeeName, String iban, String pin) throws Exception {
        UserPayeeEntity userPayeeEntity = new UserPayeeEntity();
        userPayeeEntity.setIban(iban);
        userPayeeEntity.setUserId(user_pk);
        userPayeeEntity.setName(payeeName);

        // validate pin
        UserEntity pinResult;
        logger.info("ready to valdiate pin");
        try {
            pinResult = userdao.selectUserByIdAndPin(user_pk, pin);
        } catch (Exception E) {
            throw FaultFactory.throwFaultException("fail to validate pin");
        }
        if(pinResult == null) {
            throw FaultFactory.throwFaultException("pin is not correct.");
        }

        // validate iban
        try {
            logger.info("ready to validate iban");
            IBANValidator.getInstance().validateIban(iban);
            // valid
        } catch (IbanFormatException |
                InvalidCheckDigitException |
                UnsupportedCountryException e) {
            throw FaultFactory.throwFaultException("Iban is not valid!");
            // invalid
        }

        // validate duplicate payee in db
        UserPayeeEntity result;
        logger.info("ready to validate duplicate payee");
        try {
             result = userPayeeDao.checkDuplicatePayee(userPayeeEntity);
        } catch(Exception E) {
            throw FaultFactory.throwFaultException("fail to check duplicate payee");
        }
        if(result != null) {
            throw FaultFactory.throwFaultException("duplicate payee detected! ");
        }

        // add payee to db
        try {
            logger.info("ready to add payee to db");
            userPayeeDao.addPayee(userPayeeEntity);

        } catch (Exception E) {
            FaultFactory.throwFaultException("Fail to add payee to db");
        }

    }

    @Override
    public void removePayee(Long payee_pk, Long userId) {
        try {
            logger.info("Ready to remove payee");
            userPayeeDao.removePayee(payee_pk, userId);
        } catch (Exception E) {
            FaultFactory.throwFaultException("Fail to remove payee! ");
        }


    }

    @Override
    public void transfer(Long payee_pk, Long user_pk, Long account_pk, Double amount, String pin, String postScript, int currencyType) throws Exception {
        UserEntity result_pin = new UserEntity();
        try {
            // validate pin
            result_pin = userdao.selectUserByIdAndPin(user_pk, pin);
        } catch (Exception E) {
            throw FaultFactory.throwFaultException("Fail to check pin before transfer");
        }
        if(result_pin == null) {
            throw FaultFactory.throwFaultException("Pin is not correct before transfer");
        }
        UserAccountEntity userAccountEntity;
        int updateRows = 0;
        try {
            userAccountEntity = userAccountDao.getUserAccountByPK(user_pk);
            Double currentBalance = userAccountEntity.getBalance() - amount;
            updateRows = userAccountDao.updateUserAccountByBalanceAndPk(currentBalance, account_pk);
        } catch (Exception E) {
            throw FaultFactory.throwFaultException("fail to update balance in your account");
        }
        if(updateRows <= 0) {
            throw FaultFactory.throwFaultException("fail to update balance in your account");
        }

        UserPayeeEntity result_payee;
        try {
            // validate type of iban (created from out bank or other bank)
            result_payee = userPayeeDao.getPayeeByPK(payee_pk);
        } catch (Exception E) {
            throw FaultFactory.throwFaultException("fail to check type of iban before transfer");
        }

        if(result_payee != null) {
            // local iban
            try {
                userAccountDao.updateUserAccountByBalanceAndIban(amount, result_payee.getIban());
            } catch (Exception E) {
                throw FaultFactory.throwFaultException("Fail to update balance of local account");
            }


        }
        // update in user history
        Double balance = userAccountEntity.getBalance();
        userCustomerHistoryService.addNewTransferHistory(user_pk, account_pk, payee_pk, postScript,
                balance, amount * -1, currencyType, UserOperateType.TRANSFER , UserOperateStatusType.SUCCESS);
    }

    @Override
    public List<UserTransactionsReply> getTransaction(Long user_pk, Long account_pk, int date) {
        List<UserTransactionsReply> userTransactionsReplies = new ArrayList<>();
        List<UserHistoryEntity> userHistoryEntities = new ArrayList<>();
        try {
            if(date == UserTransactionTimeFilter.RECENT_7_DAYS) {
                logger.info("ready to go to db with transaction of recent 7 days");
                userHistoryEntities = userHistoryDao.getTransactionHistory7Days(user_pk, account_pk);
            } else if(date == UserTransactionTimeFilter.RECENT_1_MONTH) {
                logger.info("ready to go to db with transaction of recent 1 month");
                userHistoryEntities = userHistoryDao.getTransactionHistory1Month(user_pk, account_pk);
            } else if(date == UserTransactionTimeFilter.RECENT_6_MONTHS) {
                logger.info("ready to go to db with transaction of recent 6 month");
                userHistoryEntities = userHistoryDao.getTransactionHistory6Month(user_pk, account_pk);
            } else if(date == UserTransactionTimeFilter.RECENT_1_YEAR) {
                logger.info("ready to go to db with transaction of recent 1 year");
                userHistoryEntities = userHistoryDao.getTransactionHistory1Year(user_pk, account_pk);
            }
            for(UserHistoryEntity userHistoryEntity: userHistoryEntities) {
                UserTransactionsReply userTransactionsReply = UserTransactionsReply.newBuilder()
                        .setUserPk(userHistoryEntity.getUserId())
                        .setDate(TimestampConvertHelper.mysqlToRpc(userHistoryEntity.getOperateTime()))
                        .setDescription(userHistoryEntity.getDescription())
                        .setAmount(userHistoryEntity.getAmount())
                        .setBalance(userHistoryEntity.getBalance())
                        .setTransactionNo(userHistoryEntity.getOperateNo())
                        .setOperateType(userHistoryEntity.getOperateType()).build();

                userTransactionsReplies.add(userTransactionsReply);
            }

        } catch (Exception E) {
            FaultFactory.throwFaultException("fail to get transaction");
        }
        logger.info(" success to get transaction.");
        return userTransactionsReplies;
    }

}
