package service.impl;

import service.IUserStaffService;

public class UserStaffService implements IUserStaffService {
    private static UserStaffService services = null;

    public static UserStaffService getInstance() {
        if (services == null) {
            return new UserStaffService();
        }
        return services;
    }

    @Override
    public void staffLogin(Long staffId, String password) {

    }
}
