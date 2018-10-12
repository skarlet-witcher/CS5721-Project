package dao;

import model.UserStaffEntity;

public interface IUserStaffDao {
    UserStaffEntity LoginStaffByUsername(String username, String password);

}
