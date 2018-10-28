package service;


import rpc.UserLoginReply;
import rpc.UserLoginReqReply;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Map;

public interface IUserCustomerLoginService {
    UserLoginReqReply LoginReq(Long userId, Integer phoneLast4, Integer birthDay, Integer birthMon, Integer birthYear) throws Exception;

    UserLoginReply LoginByUserIdAndPin(Long userId, Map<Integer, Integer> pin) throws Exception;

    void forgotUserId(String firstName, String lastName, Timestamp birthDate, String contactNum, String email);

    void forgotPIN(Long userId, String email, Timestamp birthDate);
}
