package service.impl;

import entity.UserHistoryEntity;

import java.sql.Timestamp;

public class NewUserLoginHistoryFactory {
    public static UserHistoryEntity createNewUserLoginHistory(Long userId, String operationNo, Timestamp operateTime,
                                                              Integer operateType, Integer operateSource, String description,
                                                              Integer status) {
        return new UserHistoryEntity(operationNo, operateType, operateTime, operateSource, description, userId, status);
    }
}



