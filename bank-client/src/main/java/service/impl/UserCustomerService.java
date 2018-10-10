package service.impl;

import service.IUserCustomerService;

public class UserCustomerService implements IUserCustomerService {
    private static UserCustomerService services = null;

    public static UserCustomerService getInstance() {
        if (services == null) {
            return new UserCustomerService();
        }
        return services;
    }
}
