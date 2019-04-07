package service.impl.replace_constructors_with_creation_methods;

import entity.UserHistoryEntity;

import java.sql.Timestamp;

public class NewUserLoginReqHistoryFactory {
    public static UserHistoryEntity createNewUserLoginReqHistory(Long userId, String operationNo, Timestamp operateTime,
                                                                 Integer operateType, Integer operateSource, String description,
                                                                 Integer status) {
        return new UserHistoryEntity(operationNo, operateType, operateTime, operateSource, description, userId, status);
    }
}
