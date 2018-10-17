package service.impl;

import service.ICustomerLoginService;

public class CustomerLoginService implements ICustomerLoginService {
    private static CustomerLoginService instance = null;

    public static CustomerLoginService getInstance() {
        if (instance == null) {
            return new CustomerLoginService();
        }
        return instance;
    }
}
