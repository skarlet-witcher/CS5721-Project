package dao;

import entity.UserAccountEntity;

import java.util.List;

public interface IUserAccountDao {
    Long getBiggestUserAccountNumber();

    UserAccountEntity getUserAccountByAccountNumber(Long accountNumber);

    List<UserAccountEntity> getUserAccountByUserId(Long userId);

}
