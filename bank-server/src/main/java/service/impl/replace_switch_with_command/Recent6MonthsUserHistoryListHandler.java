package service.impl.replace_switch_with_command;

import dao.impl.UserHistoryDao;
import entity.UserHistoryEntity;
import service.impl.UserCustomerService;

import java.util.List;

public class Recent6MonthsUserHistoryListHandler extends Handler {  // concrete command
    public Recent6MonthsUserHistoryListHandler(UserCustomerService userCustomerService) {
        super(userCustomerService);
    }

    @Override
    public List<UserHistoryEntity> execute(Long user_pk, Long account_pk) {
        return getTransactionHistory6Months(user_pk, account_pk);
    }

    private List<UserHistoryEntity> getTransactionHistory6Months(Long user_pk, Long account_pk) {
        // UserHistoryDao is the receiver
        return UserHistoryDao.getInstance().getTransactionHistory6Month(user_pk, account_pk);
    }
}
