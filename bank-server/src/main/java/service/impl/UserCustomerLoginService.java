package service.impl;

import Const.*;
import dao.IUserDao;
import dao.IUserHistoryDao;
import dao.impl.UserDao;
import dao.impl.UserHistoryDao;
import entity.UserEntity;
import entity.UserHistoryEntity;
import rpc.UserLoginReply;
import rpc.UserLoginReqReply;
import service.IUserCustomerHistoryService;
import service.IUserCustomerLoginService;
import util.FaultFactory;
import util.PINGenerator;
import util.RandomUtil;
import util.TimestampConvertHelper;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class UserCustomerLoginService implements IUserCustomerLoginService {
    // private static final Logger logger = Logger.getLogger(UserCustomerLoginGrpc.class.getName());
    private static UserCustomerLoginService instance = null;
    private IUserDao userDao = UserDao.getInstance();
    private IUserHistoryDao operationHistoryDao = UserHistoryDao.getInstance();
    private IUserCustomerHistoryService operationHistoryService = UserCustomerHistoryService.getInstance();

    public static UserCustomerLoginService getInstance() {
        if (instance == null) {
            return new UserCustomerLoginService();
        }
        return instance;
    }

    /**
     * LoginReq validate details, generate/save 3 digits then return them.
     * notice
     * add validation for if accounts blocking
     * add operation record.
     */
    public UserLoginReqReply LoginReq(Long userId, Integer phoneLast4, Integer birthDay, Integer birthMon, Integer birthYear) throws Exception {
        UserEntity user;
        user = validateUserExistence(userId);
        validateUserStatus(user);

        if (identifyLoginOptions(user, birthDay, birthMon, birthYear, phoneLast4)) {
            archiveSuccessfulHistory(user);
            return initLoginPinDigits(user);
        } else {
            archiveFailedHistory(user);
            throw FaultFactory.throwFaultException("LoginReq request Operation Fails.");
        }
    }

    public UserLoginReply login(Long userId, Map<Integer, Integer> pin) throws Exception {
        UserEntity result;
        result = loginUsingPIN(userId, pin);

        if (result != null) {
            return buildLoginReply(result);
        } else {
            throw FaultFactory.throwFaultException("UserId is not matched with pin, please check again.");
        }

    }

    private UserEntity loginUsingPIN(Long userId, Map<Integer, Integer> pin) throws Exception {
        try {
            return userDao.LoginByUserIdAndPin(userId, pin);
        } catch (Exception E) {
            throw FaultFactory.throwFaultException("Fail to login using PIN. please contact Admin");
        }
    }

    private UserHistoryEntity archiveSuccessfulLoginHistory(UserEntity result) throws Exception {
        UserHistoryEntity record;
        record = operationHistoryDao.getLastLoginRecordByUserId(result.getId());
        if (record != null || record == null) {
            operationHistoryService.addNewUserLoginHistory(result.getId(), UserOperateType.LOGIN, UserOperateStatusType.SUCCESS);
            record = operationHistoryDao.getLastLoginRecordByUserId(result.getId());
        } else {
            throw FaultFactory.throwFaultException("Fail to add login history when login using PIN, please contact admin.");
        }
        return record;
    }

    private UserEntity validateUserExistence(Long userId) throws Exception {
        UserEntity user;
        try {
            user = userDao.selectUserByUserId(userId);
        } catch (Exception E) {
            throw FaultFactory.throwFaultException("fail to get user info when validating user existence");
        }

        if (userDao.selectUserByUserId(userId) == null) {
            throw FaultFactory.throwFaultException("The UserId you typed is not existed.");
        } else {
            return user;
        }
    }

    private void validateUserStatus(UserEntity user) throws Exception {
        // validate if accounts blocking now
        if (user.getStatus() == UserStatusType.BLOCKED) {
            throw FaultFactory.throwFaultException("Sorry, you have been blocked in case of security problems, please ask the bank staff for further assistance.");
        } else if (user.getStatus() == UserStatusType.DELETED || user.getStatus() == UserStatusType.PENDING_FOR_BEING_DELETED) {
            throw FaultFactory.throwFaultException("Sorry, your model account has been removed from our bank system.");
        }
    }

    private UserLoginReqReply initLoginPinDigits(UserEntity user) throws Exception {
        List<Integer> loginDigitsTemplate = RandomUtil.generateNumbsNoDuplicatedASC(1, 6, 3);
        UserLoginReqReply.Builder userLoginReqBuilder = UserLoginReqReply.newBuilder();
        StringBuilder digitsInInteger = new StringBuilder();
        for (Integer digit : loginDigitsTemplate) {
            digitsInInteger.append(digit);
            if (digit == 1) {
                userLoginReqBuilder.setPin1(PinReplyType.REQUIRED);
            } else if (digit == 2) {
                userLoginReqBuilder.setPin2(PinReplyType.REQUIRED);
            } else if (digit == 3) {
                userLoginReqBuilder.setPin3(PinReplyType.REQUIRED);
            } else if (digit == 4) {
                userLoginReqBuilder.setPin4(PinReplyType.REQUIRED);
            } else if (digit == 5) {
                userLoginReqBuilder.setPin5(PinReplyType.REQUIRED);
            } else if (digit == 6) {
                userLoginReqBuilder.setPin6(PinReplyType.REQUIRED);
            }
        }
        Integer executeResult = userDao.updateUserPinDigitById(user.getId(), digitsInInteger.toString());
        if (executeResult >= 1) {
            return userLoginReqBuilder.build();
        }
        throw FaultFactory.throwFaultException("Internal Error: fail to updateBalanceByUserAccountEntity login pin digit");
    }

    private void archiveFailedHistory(UserEntity user) throws Exception {
        try {
            // validate fail
            operationHistoryService.addNewUserLoginReqHistory(user.getId(), UserOperateStatusType.FAILURE);
            operationHistoryService.refreshUserLoginStatus(user.getId());

        } catch (Exception E) {
            throw FaultFactory.throwFaultException("Customer detail validation fails.");
        }
    }

    private void archiveSuccessfulHistory(UserEntity user) throws Exception {
        try {
            operationHistoryService.addNewUserLoginReqHistory(user.getId(), UserOperateStatusType.SUCCESS);

        } catch (Exception E) {
            throw FaultFactory.throwFaultException("Fail to add history of login req, please contact admin");
        }
    }

    private Boolean identifyLoginOptions(UserEntity user, Integer birthDay, Integer birthMon, Integer birthYear, Integer phoneLast4) {
        Calendar birthDate = Calendar.getInstance();
        birthDate.setTimeInMillis(user.getBirthDate().getTime());
        return (user.getPhone().endsWith(phoneLast4.toString())
                || (birthDay == birthDate.get(Calendar.DAY_OF_MONTH) &&
                (birthMon == birthDate.get(Calendar.MONTH) + 1) &&
                birthYear == birthDate.get(Calendar.YEAR)));
    }

    private UserLoginReply buildLoginReply(UserEntity result) throws Exception {
        UserLoginReply.Builder loginReplyBuilder = UserLoginReply.newBuilder();
        loginReplyBuilder.setUserPk(result.getId());
        loginReplyBuilder.setUserId(result.getUserId());
        loginReplyBuilder.setLastName(result.getLastName());
        loginReplyBuilder.setFirstName(result.getFirstName());
        loginReplyBuilder.setLastLoginTime(TimestampConvertHelper.mysqlToRpc(
                archiveSuccessfulLoginHistory(result).getOperateTime()));

        return loginReplyBuilder.build();
    }

    @Override
    public void forgotUserId(String firstName, String lastName, Timestamp birthDate, String contactNum, String email) throws Exception {

        UserEntity userEntity = userDao.selectUserByNameDOBPhoneEmail(firstName, lastName, birthDate, contactNum, email);

        if (userEntity == null) {
            throw FaultFactory.throwFaultException("No user record found with these details!!!");
        }
        // send email
        String mailTemplate = SysEmailService.getInstance().getMailTemplate(SysMailTemplateType.FORGET_USER_ID);
        String formatEmail = MessageFormat.format(mailTemplate, firstName, userEntity.getUserId());
        SysEmailService.getInstance().send(email, "Nuclear Bank - Your User ID", formatEmail);

    }

    /**
     * The method is responsibility for checking the information of requester, generate a new pin, and send the new PIN
     * to requester's email
     *
     * @param userId    User ID of requester
     * @param email     Email of requester
     * @param birthDate Birth date of requester
     * @throws Exception if UserId is not matched with email and birthdate
     */
    @Override
    public void forgotPIN(Long userId, String email, Timestamp birthDate) throws Exception {
        UserEntity userEntity = userDao.selectUserByUserIdEmailDOB(userId, email, birthDate);
        if (userEntity != null) {
            //Generate new PIN and save it
            PINGenerator pinGenerator = PINGenerator.getInstance();
            String PIN = String.valueOf(pinGenerator.generatePIN());
            userDao.updateUserPINByUserId(userEntity.getUserId(), PIN);


            //Send Email
            String mailTemplate = SysEmailService.getInstance().getMailTemplate(SysMailTemplateType.FORGET_PIN);
            String formatMail = MessageFormat.format(mailTemplate, userEntity.getFirstName(), PIN);
            System.out.print(formatMail);
            SysEmailService.getInstance().send(email,
                    "Nuclear Bank - Requesting new PIN",
                    formatMail);
        } else {
            throw FaultFactory.throwFaultException("UserId is not matched with email and birthdate, please check again.");

        }
    }
}
