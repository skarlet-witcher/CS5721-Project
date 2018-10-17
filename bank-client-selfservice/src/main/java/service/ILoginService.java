package service;

import model.UserEntity;

public interface ILoginService {
    UserEntity LoginByUsername(String username, String password, Integer role) throws Exception;

}
