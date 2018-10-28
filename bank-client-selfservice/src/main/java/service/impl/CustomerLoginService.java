package service.impl;

import model.UserAccountModel;
import model.UserLoginRequestModel;
import model.UserModel;
import rpc.UserLoginReply;
import rpc.UserLoginReqReply;
import rpc.UserLoginReqRequest;
import rpc.UserLoginRequest;
import rpc.client.CustomerLoginRpc;
import service.ICustomerLoginService;

public class CustomerLoginService implements ICustomerLoginService {
    private static ICustomerLoginService instance = null;

    public static ICustomerLoginService getInstance() {
        if (instance == null) {
            return new CustomerLoginService();
        }
        return instance;
    }
    @Override
    public void requestLoginUsingPhoneNum(UserLoginRequestModel userLoginRequestModel) throws Exception {
        UserLoginReqReply userLoginReqReply = CustomerLoginRpc.getInstance().loginReq(
                UserLoginReqRequest.newBuilder().setPhoneLast4(Integer.parseInt(userLoginRequestModel.getPhoneNumLast4())).
                        setUserId(userLoginRequestModel.getUserId()).build()
        );
    }
    @Override
    public void requestLoginUsingDOB(UserLoginRequestModel userLoginRequestModel) throws Exception {
        CustomerLoginRpc.getInstance().loginReq(
                UserLoginReqRequest.newBuilder().setUserId(userLoginRequestModel.getUserId()).
                        setBirthDay(userLoginRequestModel.getDay()).
                        setBirthMon(userLoginRequestModel.getMonth()).
                        setBirthYear(userLoginRequestModel.getYear()).build()
        );
    }

    @Override
    public void requestForgotUserId(UserAccountModel userAccountModel) {

    }

    @Override
    public void requestForgotUserPIN(UserModel userModel) {

    }

}
