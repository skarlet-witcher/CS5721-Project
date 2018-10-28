package service;

import model.UserAccountModel;
import model.UserLoginPINModel;
import model.UserLoginRequestModel;
import model.UserModel;

import java.util.List;

public interface ICustomerLoginService {
    List<Integer> requestLoginUsingPhoneNum(UserLoginRequestModel userLoginRequestModel) throws Exception;

    List<Integer> requestLoginUsingDOB(UserLoginRequestModel userLoginRequestModel) throws Exception;

    void requestLoginUsingPIN(UserLoginPINModel userLoginPINModel) throws Exception;

    void requestForgotUserId(UserAccountModel userAccountModel) throws Exception;

    void requestForgotUserPIN(UserModel userModel) throws Exception;
}
