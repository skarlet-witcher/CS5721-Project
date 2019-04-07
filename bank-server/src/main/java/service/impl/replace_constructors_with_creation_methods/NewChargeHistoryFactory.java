package service.impl.replace_constructors_with_creation_methods;

import entity.UserHistoryEntity;

import java.sql.Timestamp;

public class NewChargeHistoryFactory {
    public static UserHistoryEntity createNewChargeHistory(Long userId, Long accountId, String description,
                                         Double balance, Double amounts, String operateNo,
                                         int currencyType, int operationType, int status,
                                         Timestamp operateTime, Integer operateSource) {
        return new UserHistoryEntity(operateNo, operationType, operateTime, operateSource, amounts, currencyType, balance, description, status, userId, accountId);

    }
}
