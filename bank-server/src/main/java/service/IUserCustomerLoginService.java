package service;


import rpc.UserLoginReply;
import rpc.UserLoginReqReply;

public interface IUserCustomerLoginService {
    UserLoginReqReply LoginReq(Long userId, Integer phoneLast4, Integer birthDay, Integer birthMon, Integer birthYear) throws Exception;

    UserLoginReply LoginByUserId(String userId, String pin);
}
