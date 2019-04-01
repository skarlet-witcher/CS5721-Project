package dao;

import entity.UserAccountEntity;

import java.util.List;

public interface IUserAccountDao {
    Long getBiggestUserAccountNumber();

    UserAccountEntity getUserAccountByAccountNumber(Long accountNumber);

    List<UserAccountEntity> getUserAccountByUserId(Long userId);

    List<UserAccountEntity> getAccountsByAccountType(Long acId);

    UserAccountEntity getUserAccountByIBAN(String iban);

    UserAccountEntity getUserAccountByPK(Long id);
    UserAccountEntity updateBalanceByUserAccountEntity(UserAccountEntity UserAccountEntity);

    Integer updateUserAccountByBalanceAndPk(Double balance, Long account_pk);

    Integer updateUserAccountByBalanceAndIban(Double balance, String iban);

    void createUserAccount(UserAccountEntity userAccountEntity);
}
