package service.impl;

import dao.impl.UserDao;
import model.UserEntity;
import model.UserStaffEntity;
import service.ILoginService;

public class LoginService implements ILoginService {
    private static LoginService instance = null;

    public static LoginService getInstance() {
        if (instance == null) {
            return new LoginService();
        }
        return instance;
    }

    /**
     * @param username
     * @param password
     * @param role 0 customer, 1 staff
     * @return
     */
    public UserEntity LoginByUsername(String username, String password, Integer role) {
        UserEntity user;
        if (role == 0) {
            user = UserDao.getInstance().LoginCustomerByUsername(username, password);
        } else {
            UserStaffEntity staff = UserDao.getInstance().LoginStaffByUsername(username, password);
            UserEntity entity = new UserEntity();
            entity.setId(staff.getId());
            entity.setFirstName(staff.getFirstName());
            entity.setLastName(staff.getLastName());
            entity.setUsername(staff.getUsername());
            entity.setEmail(staff.getEmail());
            entity.setAddress(staff.getAddress());
            entity.setPhone(null);
            user = entity;
        }
        return user;
    }
}
