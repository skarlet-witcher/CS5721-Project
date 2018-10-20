package service;


import rpc.UserLoginReply;
import rpc.UserLoginReqReply;

import java.util.Map;

public interface IUserCustomerLoginService {
    UserLoginReqReply LoginReq(Long userId, Integer phoneLast4, Integer birthDay, Integer birthMon, Integer birthYear) throws Exception;

    UserLoginReply LoginByUserIdAndPin(Long userId, Map<Integer, Integer> pin) throws Exception;
}
