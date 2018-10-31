package dao;

import entity.UserPayeeEntity;

import java.util.List;

public interface IUserPayeeDao {
    List<UserPayeeEntity> getPayeeListById(Long userId);

    UserPayeeEntity addPayee(Long userId, String payeeName, String iban);

    Integer removePayee(Long userId, String payeeName, String iban);
}
