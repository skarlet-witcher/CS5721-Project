package service.impl;

import rpc.UserLoginReqRequest;
import rpc.UserLoginRequest;
import rpc.client.CustomerLoginRpc;
import service.ICustomerLoginService;

public class CustomerLoginService implements ICustomerLoginService {
    private static CustomerLoginService instance = null;

    public static CustomerLoginService getInstance() {
        if (instance == null) {
            return new CustomerLoginService();
        }
        return instance;
    }
    public void requestLoginUsingPhoneNum(String phoneLast4, long userId) throws Exception {
        CustomerLoginRpc.getInstance().loginReq(
                UserLoginReqRequest.newBuilder().setPhoneLast4(Integer.parseInt(phoneLast4)).
                        setUserId(userId).build()
        );
    }
    public void requestLoginUsingDOB(int day, int month, int year, long userId) throws Exception {
        CustomerLoginRpc.getInstance().loginReq(
                UserLoginReqRequest.newBuilder().setUserId(userId).
                        setBirthDay(day).
                        setBirthMon(month).
                        setBirthYear(year).build()
        );
    }

}
