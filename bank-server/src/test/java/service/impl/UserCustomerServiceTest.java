package service.impl;

import Const.AccountCurrencyType;
import org.junit.jupiter.api.Test;
import service.IUserCustomerService;

import static org.junit.jupiter.api.Assertions.*;

class UserCustomerServiceTest {
    private static IUserCustomerService userCustomerService = UserCustomerService.getInstance();

    @Test
    void transfer() {
        assertDoesNotThrow(() -> {
            userCustomerService.transfer(2L,15L, 13L,
                    50.0, "869501", "transfer test",
                    AccountCurrencyType.EURO);
        });
    }
}