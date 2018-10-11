package dao;

import model.UserEntity;
import model.UserStaffEntity;

public interface IUserDao {
    UserEntity LoginCustomerByUsername(String username, String password);

    UserStaffEntity LoginStaffByUsername(String username, String password);
}
