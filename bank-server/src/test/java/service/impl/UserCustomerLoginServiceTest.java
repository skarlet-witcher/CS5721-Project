package service.impl;


import Const.PinReplyType;
import Const.UserOperateStatusType;
import Const.UserStatusType;
import dao.IUserDao;
import dao.IUserHistoryDao;
import dao.impl.UserDao;
import dao.impl.UserHistoryDao;
import entity.UserEntity;
import org.junit.jupiter.api.Test;
import rpc.UserLoginReqReply;
import service.IUserCustomerHistoryService;
import util.FaultFactory;
import util.RandomUtil;

import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class UserCustomerLoginServiceTest {
    private IUserDao userDao = UserDao.getInstance();

    @Test
    void loginReq() throws Exception {
        UserEntity user;
        user = validateUserExistence(1000000001L);
        validateUserStatus(user);

        assertDoesNotThrow(() -> {
            initLoginPinDigits(user);
        });
    }

    @Test
    void loginByUserIdAndPin() {
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
        throw FaultFactory.throwFaultException("Internal Error: fail to update login pin digit");
    }



}