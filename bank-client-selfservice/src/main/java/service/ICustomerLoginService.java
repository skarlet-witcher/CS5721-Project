package service;

import model.*;

import java.util.List;

public interface ICustomerLoginService {
    List<Integer> requestLoginUsingPhoneNum(UserLoginRequestModel userLoginRequestModel) throws Exception;

    List<Integer> requestLoginUsingDOB(UserLoginRequestModel userLoginRequestModel) throws Exception;

    void requestLoginUsingPIN(UserLoginPINModel userLoginPINModel) throws Exception;

    void requestForgotUserId(UserForgotUserIdModel userForgotUserIdModel) throws Exception;

    void requestForgotUserPIN(UserForgotPINModel UserForgotPINModel) throws Exception;
}
