package service.impl;


import Const.UserOperateSourceType;
import Const.UserOperateStatusType;
import Const.UserOperateType;
import Const.UserStatusType;
import dao.IUserDao;
import dao.IUserOperationHistoryDao;
import dao.impl.UserDao;
import dao.impl.UserOperationHistoryDao;
import entity.UserOperationHistoryEntity;
import service.IUserCustomerOperationHistoryService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class UserCustomerOperationHistoryService implements IUserCustomerOperationHistoryService {

    private static UserCustomerOperationHistoryService instance = null;
    private IUserDao userDao = UserDao.getInstance();
    private IUserOperationHistoryDao operationHistoryDao = UserOperationHistoryDao.getInstance();

    public static UserCustomerOperationHistoryService getInstance() {
        if (instance == null) {
            return new UserCustomerOperationHistoryService();
        }
        return instance;
    }

    /**
     * add new login record.
     * if login failure, check if it is equals 3 times one day.
     *
     * @param userId
     * @param status
     */
    public void addNewUserLoginReqHistory(Long userId, Integer status) {
        UserOperationHistoryEntity historyEntity = new UserOperationHistoryEntity();
        historyEntity.setUserId(userId);
// TODO       historyEntity.setOperateNo();
        historyEntity.setOperateTime(new Timestamp(new Date().getTime()));
        historyEntity.setOperateType(UserOperateType.LOGIN_REQ);
        historyEntity.setOperateSource(UserOperateSourceType.SELF_SERVICE);
        historyEntity.setDescription("Login request: " + (status == UserOperateStatusType.SUCCESS ? "Successful" : "Fail"));
        historyEntity.setStatus(status);
        operationHistoryDao.addOperationHistory(historyEntity);
        refreshUserLoginStatus(userId);
    }

    public void addNewUserLoginHistory(Long userId, Integer operateSource, Integer status) {
        UserOperationHistoryEntity historyEntity = new UserOperationHistoryEntity();
        historyEntity.setUserId(userId);
// TODO       historyEntity.setOperateNo();
        historyEntity.setOperateTime(new Timestamp(new Date().getTime()));
        historyEntity.setOperateType(UserOperateType.LOGIN);
        historyEntity.setOperateSource(operateSource);
        historyEntity.setDescription("Login: " + (status == UserOperateStatusType.SUCCESS ? "Successful" : "Fail"));
        historyEntity.setStatus(status);
        operationHistoryDao.addOperationHistory(historyEntity);
        refreshUserLoginStatus(userId);
    }

    public void refreshUserLoginStatus(Long userId) {
        // check if its 3 times for login failure.

        List<UserOperationHistoryEntity> histories = operationHistoryDao.getOperationHistoriesTodayByUserId(userId);
        Integer count = 0;
        for (UserOperationHistoryEntity history : histories) {
            if ((history.getOperateType() == UserOperateType.LOGIN_REQ ||
                    history.getOperateType() == UserOperateType.LOGIN) &&
                    history.getStatus() == UserOperateStatusType.FAILURE) {
                count++;
                if (count >= 3) {
                    break;
                }
            }
            if (history.getOperateType() == UserOperateType.LOGIN &&
                    history.getStatus() == UserOperateStatusType.SUCCESS) {
                break;
            }
        }

        // block the user
        if (count >= 3) {
            userDao.updateUserStatusById(userId, UserStatusType.BLOCKED);
        }
    }
}
