package service.impl;

import model.StaffLoginModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaffLoginServiceTest {

    @Test
    void staffLogin() {
        assertDoesNotThrow(() ->{
            StaffLoginModel staffLoginModel = new StaffLoginModel(1000000000,"123123");
            StaffLoginService.getInstance().staffLogin(staffLoginModel);
        });
    }
}