package service.impl;

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
    void requestLoginUsingPhoneNum() throws Exception {
        Long userId = 1000000000L;
        String last4PhoneNum = "3222";
        UserLoginRequestModel userLoginRequestModel = new UserLoginRequestModel(userId, last4PhoneNum);
        UserLoginReqReply userLoginReqReply = customerLoginRpc.loginReq(
                UserLoginReqRequest.newBuilder().setUserId(userLoginRequestModel.getUserId())
                .setPhoneLast4(Integer.parseInt(userLoginRequestModel.getPhoneNumLast4()))
                .build()
        );
        List<Integer> PinDigits = new ArrayList<>();
        if(userLoginReqReply.getPin1() == 1) {
            PinDigits.add(1);
        }
        if(userLoginReqReply.getPin2() == 1) {
            PinDigits.add(2);
        }
        if(userLoginReqReply.getPin3() == 1) {
            PinDigits.add(3);
        }
        if(userLoginReqReply.getPin4() == 1) {
            PinDigits.add(4);
        }
        if(userLoginReqReply.getPin5() == 1) {
            PinDigits.add(5);
        }
        if(userLoginReqReply.getPin6() == 1) {
            PinDigits.add(6);
        }
        for(int digit: PinDigits) {
            System.out.println(digit);
        }
    }

    @Test
    void requestLoginUsingDOB() {
    }
}