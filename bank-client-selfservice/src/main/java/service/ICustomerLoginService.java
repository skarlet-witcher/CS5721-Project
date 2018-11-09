package service;

import model.*;
import rpc.UserLoginReply;

import java.util.List;

public interface ICustomerLoginService {
    /*
        @pre userLoginRequestModel.getPhoneNumLast4() != null
        @pre serLoginRequestModel.getUserId() != null
        @post @result != null
     */
    List<Integer> requestLoginUsingPhoneNum(UserLoginRequestModel userLoginRequestModel) throws Exception;
    /*
        @pre userLoginRequestModel.getMonth() != null
        @pre userLoginRequestModel.getYear() != null
        @pre userLoginRequestModel.getDay() != null
        @pre serLoginRequestModel.getUserId() != null
        @post @result != null
     */
    List<Integer> requestLoginUsingDOB(UserLoginRequestModel userLoginRequestModel) throws Exception;
    /*
        @pre userLoginPINModel.getPin1() != null
        @pre userLoginPINModel.getPin2() != null
        @pre userLoginPINModel.getPin3() != null
        @pre userLoginPINModel.getPin4() != null
        @pre userLoginPINModel.getPin5() != null
        @pre userLoginPINModel.getPin6() != null
        @pre userLoginPINModel.getUserId() != null
        @post @result != null
     */
    UserLoginReply requestLoginUsingPIN(UserLoginPINModel userLoginPINModel) throws Exception;
    /*
        @pre userForgotUserIdModel.getFirstName() != null
        @pre userForgotUserIdModel.getLastName() != null
        @pre userForgotUserIdModel.getBirthDate() != null
        @pre userForgotUserIdModel.getContacNum() != null
        @pre userForgotUserIdModel.getEmail() != null
     */
    void requestForgotUserId(UserForgotUserIdModel userForgotUserIdModel) throws Exception;
    /*
        @pre userForgotPINModel.getUserId() != null
        @pre userForgotPINModel.getBirthDate() != null
        @pre userForgotPINModel.getEmail() != null
     */
    void requestForgotUserPIN(UserForgotPINModel UserForgotPINModel) throws Exception;
}
