package dao;

import entity.UserPayeeEntity;
import rpc.UserPayeesReply;

import java.util.List;

public interface IUserPayeeDao {
    List<UserPayeeEntity> getPayeeListById(Long userId);

    UserPayeeEntity getPayeeByPK(Long payee_pk);

    void addPayee(UserPayeeEntity userPayeeEntity);

    void removePayee(Long payee_pk, Long use_pk);

    UserPayeeEntity checkDuplicatePayee(UserPayeeEntity userPayeeEntity);
}
