package service;

import model.UserAccountModel;
import model.UserModel;

public interface ICustomerHomeService {
    UserAccountModel getAccounts(UserModel userModel);

}
