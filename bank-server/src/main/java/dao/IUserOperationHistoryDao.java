package dao;

import entity.UserOperationHistoryEntity;

import java.util.List;

public interface IUserOperationHistoryDao {

    void addOperationHistory(UserOperationHistoryEntity operationHistory);

    List<UserOperationHistoryEntity> getOperationHistoriesTodayByUserId(Long userId);

    UserOperationHistoryEntity getLastLoginRecordByUserId(Long userId);
}
