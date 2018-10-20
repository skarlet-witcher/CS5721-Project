package dao;

import entity.UserAccountEntity;

import java.util.List;

public interface IUserAccountDao {
    List<UserAccountEntity> getUserAccountList();
}
