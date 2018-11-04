package dao;

import entity.UserHistoryEntity;

import java.util.List;

public interface IUserHistoryDao {

    int addOperationHistory(UserHistoryEntity operationHistory);

    List<UserHistoryEntity> getOperationHistoriesTodayByUserId(Long userId);

    UserHistoryEntity getLastLoginRecordByUserId(Long userId);

    List<UserHistoryEntity> getTransactionHistory7Days(Long user_pk, Long account_pk);

    List<UserHistoryEntity> getTransactionHistory1Month(Long user_pk, Long account_pk);

    List<UserHistoryEntity> getTransactionHistory6Month(Long user_pk, Long account_pk);

    List<UserHistoryEntity> getTransactionHistory1Year(Long user_pk, Long account_pk);
}
