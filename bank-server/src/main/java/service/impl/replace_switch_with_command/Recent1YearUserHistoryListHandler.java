package service.impl.replace_switch_with_command;

import dao.impl.UserHistoryDao;
import entity.UserHistoryEntity;
import service.impl.UserCustomerService;

import java.util.List;

public class Recent1YearUserHistoryListHandler extends Handler { // concrete command
    public Recent1YearUserHistoryListHandler(UserCustomerService userCustomerService) {
        super(userCustomerService);
    }

    @Override
    public List<UserHistoryEntity> execute(Long user_pk, Long account_pk) {
        return getTransactionHistory1Year(user_pk, account_pk);
    }

    private List<UserHistoryEntity> getTransactionHistory1Year(Long user_pk, Long account_pk) {
        return UserHistoryDao.getInstance().getTransactionHistory1Year(user_pk, account_pk);
    }
}
