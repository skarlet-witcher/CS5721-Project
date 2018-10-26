package service;

import model.UserLoginRequestModel;

public interface ICustomerLoginService {
    void requestLoginUsingPhoneNum(UserLoginRequestModel userLoginRequestModel) throws Exception;

    void requestLoginUsingDOB(UserLoginRequestModel userLoginRequestModel) throws Exception;
}
