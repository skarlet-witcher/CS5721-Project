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
    @Override
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
    @Override
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

    @Override
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

        // block the user
        if (count >= 3) {
            userDao.updateUserStatusById(userId, UserStatusType.BLOCKED);
        }
    }

    @Override
    public void addNewTransferHistory(Long user_pk, Long account_pk, Long payee_pk, String postScript, Double balance, Double amounts,
                                      int currencyType, int operationType, int operateStatus) {
        UserHistoryEntity userHistoryEntity = new UserHistoryEntity();
        userHistoryEntity.setOperateNo(operationNoGenerator.generateOperationNo());
        userHistoryEntity.setOperateType(operationType);
        userHistoryEntity.setOperateTime(new Timestamp(new Date().getTime()));
        userHistoryEntity.setOperateSource(UserOperateSourceType.SELF_SERVICE);
        userHistoryEntity.setAmount(amounts);
        userHistoryEntity.setCurrencyType(currencyType);
        userHistoryEntity.setBalance(balance);
        userHistoryEntity.setDescription(postScript);
        userHistoryEntity.setStatus(operateStatus);
        userHistoryEntity.setUserId(user_pk);
        userHistoryEntity.setToPayeeId(payee_pk);
        userHistoryEntity.setAccountId(account_pk);
        operationHistoryDao.addOperationHistory(userHistoryEntity);
    }

}
