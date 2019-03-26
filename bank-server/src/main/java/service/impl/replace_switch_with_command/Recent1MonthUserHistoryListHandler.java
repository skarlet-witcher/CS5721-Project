package service.impl.replace_switch_with_command;

import dao.impl.UserHistoryDao;
import entity.UserHistoryEntity;
import service.impl.UserCustomerService;

import java.util.List;

public class Recent1MonthUserHistoryListHandler extends Handler { // concrete command

    public Recent1MonthUserHistoryListHandler(UserCustomerService userCustomerService) {
        super(userCustomerService);
    }

    @Override
    public List<UserHistoryEntity> execute(Long user_pk, Long account_pk) {
        return getTransactionHistory1Month(user_pk, account_pk);
    }

    private List<UserHistoryEntity> getTransactionHistory1Month(Long user_pk, Long account_pk) {
        // UserHistoryDao is the receiver
        return UserHistoryDao.getInstance().getTransactionHistory1Month(user_pk, account_pk);
    }

}
