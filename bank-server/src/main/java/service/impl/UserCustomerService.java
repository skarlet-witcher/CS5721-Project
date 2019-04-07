package service.impl;

import Const.UserOperateStatusType;
import Const.UserOperateType;
import Const.UserTransactionTimeFilter;
import dao.*;
import dao.impl.*;
import entity.UserAccountEntity;
import entity.UserEntity;
import entity.UserHistoryEntity;
import entity.UserPayeeEntity;
import org.iban4j.IbanFormatException;
import org.iban4j.InvalidCheckDigitException;
import org.iban4j.UnsupportedCountryException;
import rpc.UserAccountsReply;
import rpc.UserPayeesReply;
import rpc.UserProfileReply;
import rpc.UserTransactionsReply;
import service.IUserCustomerHistoryService;
import service.IUserCustomerService;
import service.impl.replace_switch_with_command.*;
import util.FaultFactory;
import util.IBANValidator;
import util.TimestampConvertHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserCustomerService implements IUserCustomerService {  // invoker

    private Map handlers;  // a Command Map (dictionary)
    private static UserCustomerService instance = null;
    private IUserAccountDao userAccountDao = UserAccountDao.getInstance();
    private IUserDao userDao = UserDao.getInstance();
    private IUserPayeeDao userPayeeDao = UserPayeeDao.getInstance();
    private IUserCustomerHistoryService userCustomerHistoryService = UserCustomerHistoryService.getInstance();
    private IUserAccountTypeDao userAccountTypeDao = UserAccountTypeDao.getInstance();
    // private static final Logger logger = Logger.getLogger(UserCustomerGrpc.class.getName());

    public static UserCustomerService getInstance() {
        if (instance == null) {
            return new UserCustomerService();
        }
        return instance;
    }

    private UserCustomerService() {
        createHandlers();
    }

    // for extensibility. add new hanlder(filter)
    private void createHandlers() {
        handlers = new HashMap();
        handlers.put(UserTransactionTimeFilter.RECENT_7_DAYS, new Recent7DaysUserHistoryListHandler(this));
        handlers.put(UserTransactionTimeFilter.RECENT_6_MONTHS, new Recent6MonthsUserHistoryListHandler(this));
        handlers.put(UserTransactionTimeFilter.RECENT_1_MONTH, new Recent1MonthUserHistoryListHandler(this));
        handlers.put(UserTransactionTimeFilter.RECENT_1_YEAR, new Recent1YearUserHistoryListHandler(this));
    }

    private Handler lookupHandlerBy(int filterName) {
        return (Handler)handlers.get(filterName);
    }


    @Override
    public List<UserAccountsReply> getAccounts(Long user_pk) throws Exception {
        try {
            List<UserAccountsReply> userAccountsReplies = new ArrayList<>();
            for (UserAccountEntity userAccount : userAccountDao.getUserAccountByUserId(user_pk)) {
                UserAccountsReply userAccountsReply = UserAccountsReply.newBuilder()
                        .setAccountPk(userAccount.getId())
                        .setAccountNumber(userAccount.getAccountNumber())
                        .setAccountType(userAccount.getAccountType().intValue())
                        .setCurrencyType(userAccount.getCurrencyType())
                        .setBalance(userAccount.getBalance().intValue())
                        .setStatus(userAccount.getStatus()).build();
                userAccountsReplies.add(userAccountsReply);
            }
            return userAccountsReplies;
        } catch (Exception E) {
            throw FaultFactory.throwFaultException(E.getMessage());
        }
    }

    @Override
    public UserProfileReply getUserProfile(Long user_pk) throws Exception {
        try {
            UserEntity user = userDao.selectUserById(user_pk);
            UserProfileReply userProfile = UserProfileReply.newBuilder()
                    .setUserPk(user.getId())
                    .setUserId(user.getUserId())
                    .setFirstName(user.getFirstName())
                    .setLastName(user.getLastName())
                    .setGender(user.getGender())
                    .setBirthDate(TimestampConvertHelper.mysqlToRpc(user.getBirthDate()))
                    .setAddress(user.getAddress())
                    .setEmail(user.getEmail())
                    .setPhone(user.getPhone()).build();
            return userProfile;
        } catch (Exception E) {
            throw FaultFactory.throwFaultException(E.getMessage());
        }
    }

    @Override
    public void editUserProfile(Long user_pk, String address, String email, String contactNum) throws Exception {
        try {
            int updateRows = userDao.updateUserProfileById(user_pk, address, email, contactNum);
            if(updateRows <= 0) {
                throw FaultFactory.throwFaultException("fail to updateBalanceByUserAccountEntity user profile");
            }
        } catch (Exception E) {
            throw FaultFactory.throwFaultException(E.getMessage());
        }
    }

    @Override
    public List<UserPayeesReply> getPayeeList(Long user_pk) throws Exception {
        try {
            List<UserPayeesReply> userPayeesReplies = new ArrayList<>();
            for(UserPayeeEntity userPayeeEntity: userPayeeDao.getPayeeListById(user_pk)) {
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

        validatePin(user_pk, pin);
        validateIBAN(iban);
        validateDuplicatePayee(userPayeeEntity);

        try {
            userPayeeDao.addPayee(userPayeeEntity);
        } catch (Exception E) {
            FaultFactory.throwFaultException("Fail to add payee to db");
        }
    }

    @Override
    public void removePayee(Long payee_pk, Long userId) {
        try {
            userPayeeDao.removePayee(payee_pk, userId);
        } catch (Exception E) {
            FaultFactory.throwFaultException("Fail to remove payee! ");
        }
    }

    @Override
    public void transfer(Long payee_pk, Long user_pk, Long account_pk,
                         Double amount, String pin, String postScript, int currencyType) throws Exception {
        Double updatedBalance;
        validatePin(user_pk, pin);
        chargeFees(userAccountDao.getUserAccountByPK(account_pk), amount);
        updatedBalance = updateBalanceFromUserAccount(account_pk, amount);
        transferToLocalPayee(payee_pk, amount);
        addTransferHistory(user_pk,
                account_pk,
                payee_pk,
                postScript,
                amount,
                currencyType,
                updatedBalance,
                UserOperateStatusType.SUCCESS);

    }

    @Override
    public List<UserTransactionsReply> getTransaction(Long user_pk, Long account_pk, int date) throws Exception {
        List<UserTransactionsReply> userTransactionsReplies = new ArrayList<>();
        try {
            for(UserHistoryEntity userHistoryEntity: getUserHistoryListByFilter(user_pk, account_pk, date)) {
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
            throw FaultFactory.throwFaultException("fail to get transaction");
        }
        return userTransactionsReplies;
    }

    private void validatePin(Long user_pk, String pin) throws Exception {
        UserEntity result;
        try {
            result = userDao.selectUserByIdAndPin(user_pk, pin);
        } catch (Exception E) {
            throw FaultFactory.throwFaultException("fail to validate pin");
        }
        if(result == null) {
            throw FaultFactory.throwFaultException("pin is not correct.");
        }
    }

    private void validateIBAN(String iban) throws Exception {
        try {
            IBANValidator.getInstance().validateIban(iban);
        } catch (IbanFormatException |
                InvalidCheckDigitException |
                UnsupportedCountryException e) {
            throw FaultFactory.throwFaultException("IBAN is not valid!");
        }
    }

    private void validateDuplicatePayee(UserPayeeEntity userPayeeEntity) throws Exception {
        UserPayeeEntity result;
        try {
            result = userPayeeDao.checkDuplicatePayee(userPayeeEntity);
        } catch(Exception E) {
            throw FaultFactory.throwFaultException("fail to check duplicate payee");
        }
        if(result != null) {
            throw FaultFactory.throwFaultException("duplicate payee detected!");
        }
    }

    private void transferToLocalPayee(Long payee_pk, Double amount) throws Exception {
        UserAccountEntity result_payee;
        try {
            // validate type of iban (created from out bank or other bank)
            result_payee = userAccountDao.getUserAccountByIBAN(userPayeeDao.getPayeeByPK(payee_pk).getIban());
        } catch (Exception E) {
            throw FaultFactory.throwFaultException("fail to check type of iban before transfer");
        }

        if(result_payee != null) {
            // local iban
            try {
                userAccountDao.updateUserAccountByBalanceAndIban(amount, result_payee.getIban());
            } catch (Exception E) {
                throw FaultFactory.throwFaultException("Fail to updateBalanceByUserAccountEntity balance of local account");
            }
            addTransferHistoryForTransferredAccount(result_payee, amount);
        }

    }

    private void addTransferHistoryForTransferredAccount(UserAccountEntity transferredAccount, Double amount) throws Exception {
        try {
            addTransferHistoryForTransferredAccount(transferredAccount.getUserId(),
                    transferredAccount.getId(),
                    null,
                    "receive transfer",
                    amount,
                    transferredAccount.getCurrencyType(),
                    transferredAccount.getBalance(),
                    UserOperateStatusType.SUCCESS);
        } catch (Exception e) {
            throw FaultFactory.throwFaultException("Fail to add transfer history to transferred account.");
        }

    }

    private void addTransferHistory(Long user_pk, Long account_pk, Long payee_pk, String postScript, Double amount, int currencyType, Double updatedBalance, int operateStatus) {
        userCustomerHistoryService.addNewTransferHistory(user_pk, account_pk, payee_pk, postScript,
                updatedBalance, amount * -1, currencyType, UserOperateType.TRANSFER, operateStatus);
    }

    private void addTransferHistoryForTransferredAccount(Long user_pk, Long account_pk, Long payee_pk, String postScript, Double amount, int currencyType, Double updatedBalance, int operateStatus) {
        userCustomerHistoryService.addNewTransferHistory(user_pk, account_pk, payee_pk, postScript,
                updatedBalance, amount, currencyType, UserOperateType.TRANSFER, operateStatus);
    }

    private List<UserHistoryEntity> getUserHistoryListByFilter(Long user_pk, Long account_pk, int filter) throws Exception {
        List<UserHistoryEntity> userHistoryEntityList;
        try {
            Handler handler = lookupHandlerBy(filter);
            userHistoryEntityList = handler.execute(user_pk, account_pk);

            /*
            switch(filter) {
                case UserTransactionTimeFilter.RECENT_7_DAYS:
                    userHistoryEntityList = new Recent7DaysUserHistoryListHandler(this).execute(user_pk, account_pk); break;
                case UserTransactionTimeFilter.RECENT_1_MONTH:
                    userHistoryEntityList = new Recent1MonthUserHistoryListHandler(this).execute(user_pk, account_pk); break;
                case UserTransactionTimeFilter.RECENT_6_MONTHS:
                    userHistoryEntityList = new Recent6MonthsUserHistoryListHandler(this).execute(user_pk, account_pk); break;
                case UserTransactionTimeFilter.RECENT_1_YEAR:
                    userHistoryEntityList = new Recent1YearUserHistoryListHandler(this).execute(user_pk, account_pk); break;
            }
            */
        } catch (Exception E) {
            throw FaultFactory.throwFaultException("Fail to get user history list by filter");
        }
        return userHistoryEntityList;
    }



    private Double updateBalanceFromUserAccount(Long account_pk, Double amount) throws Exception {
        int updatedRows;
        Double latestBalance;
        try {
            latestBalance = getLatestBalance(userAccountDao.getUserAccountByPK(account_pk), amount);
            updatedRows = userAccountDao.updateUserAccountByBalanceAndPk(latestBalance, account_pk);
        } catch (Exception E) {
            throw FaultFactory.throwFaultException("fail to updateBalanceByUserAccountEntity balance in your account");
        }
        if(updatedRows <= 0) {
            throw FaultFactory.throwFaultException("fail to updateBalanceByUserAccountEntity balance in your account");
        }
        return latestBalance;
    }

    private Double getLatestBalance(UserAccountEntity userAccountEntity, Double amount) {
        return userAccountEntity.getBalance() - amount;
    }

    private Double chargeFees(UserAccountEntity userAccountEntity, Double amount) throws Exception {
        Double fees;
        Double updatedBalance;
        try {
            fees = getFees(userAccountEntity);
            updatedBalance = updateBalanceFromUserAccount(userAccountEntity.getId(), amount * fees);
            addChargeHistory(userAccountEntity, amount * fees , updatedBalance);
        } catch (Exception E) {
           throw FaultFactory.throwFaultException("Fail to charge fees");
        }
        return updatedBalance;
    }

    private Double getFees(UserAccountEntity userAccountEntity) throws Exception {
        try {
            return userAccountTypeDao.getUserAccountType(userAccountEntity.getAccountType()).getChargeSelfserviceTrans();
        } catch (Exception E) {
            throw FaultFactory.throwFaultException("fail to get fees");
        }
    }

    private void addChargeHistory(UserAccountEntity userAccountEntity, Double chargedAmount, Double balance) throws Exception {
        try {
            userCustomerHistoryService.addNewChargeHistory(userAccountEntity.getUserId(), userAccountEntity.getId(), chargedAmount * -1, balance, userAccountEntity.getCurrencyType(), UserOperateType.CHARGE, UserOperateStatusType.SUCCESS);
        } catch (Exception E) {
            throw FaultFactory.throwFaultException("fail to add charge history");
        }
    }
}
