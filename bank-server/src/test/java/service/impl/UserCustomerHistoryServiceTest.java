package service.impl;

import Const.AccountCurrencyType;
import Const.UserOperateSourceType;
import Const.UserOperateStatusType;
import Const.UserOperateType;
import dao.IUserHistoryDao;
import dao.impl.UserHistoryDao;
import entity.UserHistoryEntity;
import org.junit.jupiter.api.Test;
import service.NewTransferHistoryFactory;
import service.impl.replace_constructors_with_creation_methods.NewChargeHistoryFactory;
import service.impl.replace_constructors_with_creation_methods.NewUserLoginReqHistoryFactory;
import util.OperationNoGenerator;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserCustomerHistoryServiceTest {

    private IUserHistoryDao operationHistoryDao = UserHistoryDao.getInstance();
    private OperationNoGenerator operationNoGenerator = OperationNoGenerator.getInstance();

    @Test
    void addNewUserLoginReqHistory() {
        assertDoesNotThrow(() -> {
            UserHistoryEntity userHistoryEntity = NewUserLoginReqHistoryFactory.createNewUserLoginReqHistory(15L, operationNoGenerator.generateOperationNo(),
                    new Timestamp(new Date().getTime()), UserOperateType.LOGIN_REQ,
                    UserOperateSourceType.SELF_SERVICE,
                    "Login request: Success (Test)", UserOperateStatusType.SUCCESS);

            operationHistoryDao.addOperationHistory(userHistoryEntity);

        });
    }

    @Test
    void addNewUserLoginHistory() {
        assertDoesNotThrow(() -> {
            UserHistoryEntity userHistoryEntity = NewUserLoginReqHistoryFactory.createNewUserLoginReqHistory(15L, operationNoGenerator.generateOperationNo(),
                    new Timestamp(new Date().getTime()), UserOperateType.LOGIN,
                    UserOperateSourceType.SELF_SERVICE,
                    "Login: Success (Test)", UserOperateStatusType.SUCCESS);

            operationHistoryDao.addOperationHistory(userHistoryEntity);
        });
    }

    @Test
    void addNewTransferHistory() {
        assertDoesNotThrow(() -> {
            UserHistoryEntity userHistoryEntity = NewTransferHistoryFactory.createNewTransferHistory(15L, 13L, 10L,
                    "transfer test", 5995D, -500D,
                    operationNoGenerator.generateOperationNo(), AccountCurrencyType.EURO, UserOperateType.TRANSFER, UserOperateStatusType.SUCCESS,
                    new Timestamp(new Date().getTime()), UserOperateSourceType.SELF_SERVICE);

            operationHistoryDao.addOperationHistory(userHistoryEntity);
        });
    }

    @Test
    void addNewChargeHistory() {
        assertDoesNotThrow(() -> {
            UserHistoryEntity userHistoryEntity = NewChargeHistoryFactory.createNewChargeHistory(15L, 13L,
                    "charge test", 5995D, -500D,
                    operationNoGenerator.generateOperationNo(), AccountCurrencyType.EURO, UserOperateType.TRANSFER, UserOperateStatusType.SUCCESS,
                    new Timestamp(new Date().getTime()), UserOperateSourceType.SELF_SERVICE);

            operationHistoryDao.addOperationHistory(userHistoryEntity);
        });
    }
}