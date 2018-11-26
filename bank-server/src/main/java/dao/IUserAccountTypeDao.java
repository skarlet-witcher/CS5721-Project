package dao;

import entity.UserAccountTypeEntity;

public interface IUserAccountTypeDao {
    UserAccountTypeEntity getUserAccountType(Long accountType);
}
