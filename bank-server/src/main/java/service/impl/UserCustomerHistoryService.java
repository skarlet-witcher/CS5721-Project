package service.impl;


import Const.UserOperateSourceType;
import Const.UserOperateStatusType;
import Const.UserOperateType;
import Const.UserStatusType;
import dao.IUserDao;
import dao.IUserHistoryDao;
import dao.impl.UserDao;
import dao.impl.UserHistoryDao;
import entity.UserHistoryEntity;
import service.IUserCustomerHistoryService;
import util.OperationNoGenerator;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class UserCustomerHistoryService implements IUserCustomerHistoryService {

    private static UserCustomerHistoryService instance = null;
    private IUserDao userDao = UserDao.getInstance();
    private IUserHistoryDao operationHistoryDao = UserHistoryDao.getInstance();
    private OperationNoGenerator operationNoGenerator = OperationNoGenerator.getInstance();

    public static UserCustomerHistoryService getInstance() {
        if (instance == null) {
            return new UserCustomerHistoryService();
        }
        return instance;
    }

    /**
     * add new login record.
     * if login failure, check if it is equals 3 times one day.
     *
     */
    public void addNewUserLoginReqHistory(Long userId, Integer status) {
        UserHistoryEntity historyEntity = new UserHistoryEntity();
        historyEntity.setUserId(userId);
        historyEntity.setOperateNo(operationNoGenerator.generateOperationNo());
        historyEntity.setOperateTime(new Timestamp(new Date().getTime()));
        historyEntity.setOperateType(UserOperateType.LOGIN_REQ);
        historyEntity.setOperateSource(UserOperateSourceType.SELF_SERVICE);
        historyEntity.setDescription("Login request: " + (status == UserOperateStatusType.SUCCESS ? "Successful" : "Fail"));
        historyEntity.setStatus(status);
        operationHistoryDao.addOperationHistory(historyEntity);
        refreshUserLoginStatus(userId);
    }

    public void addNewUserLoginHistory(Long userId, Integer operateSource, Integer status) {
        UserHistoryEntity historyEntity = new UserHistoryEntity();
        historyEntity.setUserId(userId);
        historyEntity.setOperateNo(operationNoGenerator.generateOperationNo());
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

        List<UserHistoryEntity> histories = operationHistoryDao.getOperationHistoriesTodayByUserId(userId);
        Integer count = 0;
        for (UserHistoryEntity history : histories) {
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

        // block the model
        if (count >= 3) {
            userDao.updateUserStatusById(userId, UserStatusType.BLOCKED);
        }
    }
}
