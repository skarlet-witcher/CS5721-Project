package dao;

import entity.UserPayeeEntity;

import java.util.List;

public interface IUserPayeeDao {
    List<UserPayeeEntity> getPayeeListById(Long userId);

    void addPayee(UserPayeeEntity userPayeeEntity);

    Integer removePayee(UserPayeeEntity userPayeeEntity);

    UserPayeeEntity checkDuplicatePayee(UserPayeeEntity userPayeeEntity);
}
