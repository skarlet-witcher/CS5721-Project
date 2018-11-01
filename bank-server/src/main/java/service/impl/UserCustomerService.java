package service.impl;

import dao.IUserAccountDao;
import dao.IUserDao;
import dao.IUserPayeeDao;
import dao.impl.UserAccountDao;
import dao.impl.UserDao;
import dao.impl.UserPayeeDao;
import entity.UserAccountEntity;
import entity.UserEntity;
import entity.UserPayeeEntity;
import org.iban4j.*;
import rpc.UserAccountsReply;
import rpc.UserCustomerGrpc;
import rpc.UserPayeesReply;
import rpc.UserProfileReply;
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
            UserProfileReply userProfileReply =UserProfileReply.newBuilder()
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
            pinResult  = userdao.selectUserByIdAndPin(user_pk, pin);
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
}
