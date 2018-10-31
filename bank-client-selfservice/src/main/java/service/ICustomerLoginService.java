package service;

import model.*;
import rpc.UserLoginReply;

import java.util.List;

public interface ICustomerLoginService {
    List<Integer> requestLoginUsingPhoneNum(UserLoginRequestModel userLoginRequestModel) throws Exception;

    List<Integer> requestLoginUsingDOB(UserLoginRequestModel userLoginRequestModel) throws Exception;

    UserLoginReply requestLoginUsingPIN(UserLoginPINModel userLoginPINModel) throws Exception;

    void requestForgotUserId(UserForgotUserIdModel userForgotUserIdModel) throws Exception;

    void requestForgotUserPIN(UserForgotPINModel UserForgotPINModel) throws Exception;
}
