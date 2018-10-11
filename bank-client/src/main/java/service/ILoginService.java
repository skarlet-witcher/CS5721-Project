package service;

import model.UserEntity;
import rpc.UserLoginReply;

public interface ILoginService {
    UserEntity LoginByUsername(String username, String password, Integer role) throws Exception;

}
