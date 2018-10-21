package util;

import dao.IBankStaffDao;
import dao.IUserDao;
import dao.impl.BankStaffDao;
import dao.impl.UserDao;

public class IdGenerator {
    private IUserDao userDao = UserDao.getInstance();
    private IBankStaffDao staffDao = BankStaffDao.getInstance();

    public long generateUserId() {
        // 10 digit userId
        long currentId = 1000000001L;
        Long userId = userDao.selectTheBiggestId();
        if (userId != null) {
            currentId = userId + 1L;
        }

        return currentId;
    }

    public long generateStaffId() {
        // 10 digit userId
        long currentId = 1000000001L;
        Long staffId = staffDao.selectTheBiggestId();
        if (staffId != null) {
            currentId = staffId + 1L;
        }

        return currentId;
    }

}
