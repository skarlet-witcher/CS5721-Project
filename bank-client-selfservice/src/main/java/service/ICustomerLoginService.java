package service;

import model.UserAccountModel;
import model.UserLoginRequestModel;
import model.UserModel;

public interface ICustomerLoginService {
    void requestLoginUsingPhoneNum(UserLoginRequestModel userLoginRequestModel) throws Exception;

    void requestLoginUsingDOB(UserLoginRequestModel userLoginRequestModel) throws Exception;

    void requestForgotUserId(UserAccountModel userAccountModel) throws Exception;

    void requestForgotUserPIN(UserModel userModel) throws Exception;
}
