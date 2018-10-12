package dao;

import model.UserEntity;

public interface IUserDao {
    UserEntity LoginCustomerByUsername(String username, String password);

}
