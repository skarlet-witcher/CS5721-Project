package dao;

import entity.UserAccountEntity;

import java.util.List;

public interface IUserAccountDao {
    Long getBiggestUserAccountNumber();

    UserAccountEntity getUserAccountByAccountNumber(Long accountNumber);

    List<UserAccountEntity> getUserAccountByUserId(Long userId);

    UserAccountEntity getUserAccountByIBAN(String iban);

    UserAccountEntity getUserAccountByPK(Long id);

    Integer updateUserAccountByBalanceAndPk(Double balance, Long account_pk);

    Integer updateUserAccountByBalanceAndIban(Double balance, String iban);

}
