package service.impl;


import org.junit.jupiter.api.Test;
import service.IUserCustomerLoginService;
import java.util.HashMap;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class UserCustomerLoginServiceTest {
    private IUserCustomerLoginService userCustomerLoginService = UserCustomerLoginService.getInstance();

    @Test
    void loginReq() {
        assertDoesNotThrow(() -> {
            userCustomerLoginService.LoginReq(1000000001L, 6789, 23, 03, 1996);
        });
    }

    @Test
    void loginByUserIdAndPin() {
        Map<Integer, Integer> pin = new HashMap<Integer, Integer>(){{
            put(1,8);
            put(2,6);
            put(3,9);
            put(4,5);
            put(5,0);
            put(6,1);
        }};


        assertDoesNotThrow(() -> {
            userCustomerLoginService.login(1000000001L, pin);
        });


    }
}