package service.impl;

import Const.UserOperateStatusType;
import Const.UserStatusType;
import dao.IUserDao;
import dao.IUserOperationHistoryDao;
import dao.impl.UserDao;
import dao.impl.UserOperationHistoryDao;
import entity.UserEntity;
import entity.UserHistoryEntity;
import rpc.UserLoginReply;
import rpc.UserLoginReqReply;
import service.IUserCustomerLoginService;
import service.IUserCustomerOperationHistoryService;
import util.RandomUtil;
import util.TimestampConvertHelper;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class UserCustomerLoginService implements IUserCustomerLoginService {
    private static UserCustomerLoginService instance = null;
    private IUserDao userDao = UserDao.getInstance();
    private IUserOperationHistoryDao operationHistoryDao = UserOperationHistoryDao.getInstance();
    private IUserCustomerOperationHistoryService operationHistoryService = UserCustomerOperationHistoryService.getInstance();

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
        UserEntity user = userDao.selectUserByUserId(userId);

        if (user == null) {
            throw new Exception("The UserId you typed is not existed.");
        }

        // validate if accounts blocking now
        if (user.getStatus() == UserStatusType.BLOCKED) {
            throw new Exception("Sorry, you have been blocked in case of security problems, please ask bank staff for farther assistance.");
        } else if (user.getStatus() == UserStatusType.DELETED || user.getStatus() == UserStatusType.PENDING_FOR_BEING_DELETED) {
            throw new Exception("Sorry, your user account has been removed from our bank system.");
        }

        Calendar birthDate = Calendar.getInstance();
        birthDate.setTimeInMillis(user.getBirthDate().getTime());

        if (user.getPhone().endsWith(phoneLast4.toString())
                || (birthDay == birthDate.get(Calendar.DAY_OF_MONTH) &&
                (birthMon == birthDate.get(Calendar.MONTH) + 1) &&
                birthYear == birthDate.get(Calendar.YEAR))) {
            // validate pass

            try {
                List<Integer> digits = RandomUtil.generateNumbsNoDuplicatedASC(1, 6, 3);
                UserLoginReqReply.Builder userLoginReqBuilder = UserLoginReqReply.newBuilder();
                StringBuilder digitsInInteger = new StringBuilder();
                for (Integer digit : digits) {
                    digitsInInteger.append(digit);
                    if (digit == 1) {
                        userLoginReqBuilder.setPin1(1);
                    } else if (digit == 2) {
                        userLoginReqBuilder.setPin2(1);
                    } else if (digit == 3) {
                        userLoginReqBuilder.setPin3(1);
                    } else if (digit == 4) {
                        userLoginReqBuilder.setPin4(1);
                    } else if (digit == 5) {
                        userLoginReqBuilder.setPin5(1);
                    } else if (digit == 6) {
                        userLoginReqBuilder.setPin6(1);
                    }
                }
                Integer executeResult = userDao.updateUserPinDigitById(user.getId(), digitsInInteger.toString());
                if (executeResult >= 1) {
                    return userLoginReqBuilder.build();
                }
                throw new Exception();
            } catch (Exception e) {
                throw new Exception("Operation Fails.");
            }
        } else {
            // validate fail
            operationHistoryService.addNewUserLoginReqHistory(user.getId(), UserOperateStatusType.FAILURE);
            operationHistoryService.refreshUserLoginStatus(user.getId());
            throw new Exception("Customer detail validation fails.");
        }
    }

    public UserLoginReply LoginByUserIdAndPin(Long userId, Map<Integer, Integer> pin) throws Exception {
        UserEntity userEntity = userDao.LoginByUserIdAndPin(userId, pin);
        if (userEntity != null) {
            UserLoginReply.Builder loginReplyBuilder = UserLoginReply.newBuilder();
            loginReplyBuilder.setUserPk(userEntity.getId());
            loginReplyBuilder.setUserId(userEntity.getUserId());
            loginReplyBuilder.setLastName(userEntity.getLastName());
            loginReplyBuilder.setFirstName(userEntity.getFirstName());

            UserHistoryEntity record = operationHistoryDao.getLastLoginRecordByUserId(userEntity.getId());
            loginReplyBuilder.setLastLoginTime(TimestampConvertHelper.mysqlToRpc(record.getOperateTime()));

            return loginReplyBuilder.build();
        } else {
            throw new Exception("UserId is not matched with pin, please check again.");
        }

    }
}
