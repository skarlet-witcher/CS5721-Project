package service.impl;

import service.ILoginService;

public class LoginService implements ILoginService {
    private static LoginService services = null;

    public static LoginService getInstance() {
        if (services == null) {
            return new LoginService();
        }
        return services;
    }
}
