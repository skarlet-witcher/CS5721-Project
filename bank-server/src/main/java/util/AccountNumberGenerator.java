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
        long currentAccountNumber = 1000000000;
        List<UserAccountEntity> userAccountList = UserAccountDao.getInstance().getUserAccountList();
        for(int i = 0; i < userAccountList.size(); i++) {
            if(userAccountList.size() <= 0) {
                break;
            }
            if(userAccountList.get(i).getAccountNumber() == currentAccountNumber) {
                currentAccountNumber++;
            }
        }
        return currentAccountNumber;
    }
}
