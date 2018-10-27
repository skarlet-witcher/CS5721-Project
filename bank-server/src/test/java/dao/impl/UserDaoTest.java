package dao.impl;

import dao.IUserDao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class UserDaoTest {
    private IUserDao userDao = UserDao.getInstance();

    @Test
    void selectTheBiggestId() {
        assertDoesNotThrow(() -> {
            userDao.selectTheBiggestId();
        });
    }
}