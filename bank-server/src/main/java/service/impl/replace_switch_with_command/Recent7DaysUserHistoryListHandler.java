package service.impl.replace_switch_with_command;

import dao.impl.UserHistoryDao;
import entity.UserHistoryEntity;
import service.impl.UserCustomerService;

import java.util.List;

public class Recent7DaysUserHistoryListHandler extends Handler { // concrete command
    public Recent7DaysUserHistoryListHandler(UserCustomerService userCustomerService) {
        super(userCustomerService);
    }

    @Override
    public List<UserHistoryEntity> execute(Long user_pk, Long account_pk) {
        return getTransactionHistory7Days(user_pk, account_pk);
    }

    private List<UserHistoryEntity> getTransactionHistory7Days(Long user_pk, Long account_pk) {
        return UserHistoryDao.getInstance().getTransactionHistory7Days(user_pk, account_pk);
    }
}
