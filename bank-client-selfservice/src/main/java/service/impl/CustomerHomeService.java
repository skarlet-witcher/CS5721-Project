package service.impl;

import model.UserAccountModel;
import model.UserModel;

import service.ICustomerHomeService;

public class CustomerHomeService implements ICustomerHomeService {
    private static ICustomerHomeService customerHomeService = null;

    public static ICustomerHomeService getInstance() {
        if(customerHomeService == null) {
            customerHomeService = new CustomerHomeService();
        }
        return customerHomeService;
    }

    @Override
    public UserAccountModel getAccounts(UserModel userModel) {
        return null;
    }

}
