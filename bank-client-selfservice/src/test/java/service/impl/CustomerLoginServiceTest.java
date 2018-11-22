package service.impl;

import model.UserLoginPINModel;
import model.UserLoginRequestModel;
import org.junit.jupiter.api.Test;
import rpc.UserLoginReqReply;
import rpc.UserLoginReqRequest;
import rpc.UserLoginRequest;
import rpc.client.CustomerLoginRpc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerLoginServiceTest {
    CustomerLoginRpc customerLoginRpc = CustomerLoginRpc.getInstance();

    @Test
    void requestLoginUsingPhoneNum() {
        UserLoginRequestModel userLoginRequestModel = new UserLoginRequestModel(1000000001L, "6789");

        assertDoesNotThrow(() -> {
            customerLoginRpc.loginReq(
                    UserLoginReqRequest.newBuilder().setUserId(userLoginRequestModel.getUserId())
                            .setPhoneLast4(Integer.parseInt(userLoginRequestModel.getPhoneNumLast4()))
                            .build()
            );
        });
    }

    @Test
    void requestLoginUsingDOB() {
        UserLoginRequestModel userLoginRequestModel = new UserLoginRequestModel(1000000001L, 23, 03, 1996);

        assertDoesNotThrow(() -> {
            customerLoginRpc.loginReq(
                    UserLoginReqRequest.newBuilder().setUserId(userLoginRequestModel.getUserId())
                    .setBirthDay(userLoginRequestModel.getDay())
                            .setBirthMon(userLoginRequestModel.getMonth())
                            .setBirthYear(userLoginRequestModel.getYear()).build()
            );
        });
    }

    @Test
    void requestLoginUsingPIN() {
        UserLoginPINModel userLoginPINModel = new UserLoginPINModel();
        userLoginPINModel.setUserId(1000000001L);
        userLoginPINModel.setPin1(8);
        userLoginPINModel.setPin2(6);
        userLoginPINModel.setPin3(9);
        userLoginPINModel.setPin4(5);
        userLoginPINModel.setPin5(0);
        userLoginPINModel.setPin6(1);

        assertDoesNotThrow(() -> {
            customerLoginRpc.login(
                    UserLoginRequest.newBuilder().setUserId(userLoginPINModel.getUserId())
                    .setPin1(userLoginPINModel.getPin1())
                    .setPin2(userLoginPINModel.getPin2())
                    .setPin3(userLoginPINModel.getPin3())
                    .setPin4(userLoginPINModel.getPin4())
                    .setPin5(userLoginPINModel.getPin5())
                    .setPin6(userLoginPINModel.getPin6()).build()
            );
        });
    }
}