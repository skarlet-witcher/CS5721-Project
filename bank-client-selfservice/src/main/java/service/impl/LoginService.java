package service.impl;

import model.UserEntity;
import rpc.client.LoginRpc;
import service.ILoginService;

public class LoginService implements ILoginService {
    private static LoginService instance = null;

    public static LoginService getInstance() {
        if (instance == null) {
            return new LoginService();
        }
        return instance;
    }

    public static void main(String[] args) {
        try {
            UserEntity entity = getInstance().LoginByUsername("123", "123", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public UserEntity LoginByUsername(String username, String password, Integer role) {
        return LoginRpc.getInstance().login(username, password, role);
    }
}
