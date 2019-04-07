package service;

import entity.UserHistoryEntity;

import java.sql.Timestamp;

public class NewTransferHistoryFactory {
    public static UserHistoryEntity createNewTransferHistory(Long userId, Long accountId, Long payeeId,
                                                             String description, Double balance, Double amounts,
                                                             String operateNo, int currencyType, int operationType,
                                                             int status, Timestamp operateTime, Integer operateSource) {
        return new UserHistoryEntity(operateNo, operationType, operateTime, operateSource, amounts, currencyType, balance, description, status, userId, payeeId, accountId);

    }

}
