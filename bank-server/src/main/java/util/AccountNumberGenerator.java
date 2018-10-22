package util;

import dao.impl.UserAccountDao;
import entity.UserAccountEntity;

import java.util.List;

public class AccountNumberGenerator {
    private static AccountNumberGenerator accountNumberGenerator = null;

    private AccountNumberGenerator() {

    }

    public static AccountNumberGenerator getInstance() {
        if(accountNumberGenerator == null) {
            accountNumberGenerator = new AccountNumberGenerator();
        }
        return accountNumberGenerator;
    }

    public long generateAccountNumber() {
        long currentAccountNumber = 1000000001L;
        Long accountNumber = UserAccountDao.getInstance().getBiggestUserAccountNumber();
        if(accountNumber != null) {
            currentAccountNumber = accountNumber + 1L;
        }
        return currentAccountNumber;
    }
}
