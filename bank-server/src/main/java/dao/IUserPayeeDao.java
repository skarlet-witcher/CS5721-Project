package dao;

import entity.UserPayeeEntity;

import java.util.List;

public interface IUserPayeeDao {
    List<UserPayeeEntity> getPayeeListById(Long userId);

    void addPayee(UserPayeeEntity userPayeeEntity);

    void removePayee(Long payee_pk, Long use_pk);

    UserPayeeEntity checkDuplicatePayee(UserPayeeEntity userPayeeEntity);
}
