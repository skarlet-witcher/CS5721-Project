package dao;

import entity.UserAccountEntity;

import java.util.List;

public interface IUserAccountDao {
    Long getBiggestUserAccountNumber();

    UserAccountEntity getUserAccountByAccountNumber(long accountNumber);

}
