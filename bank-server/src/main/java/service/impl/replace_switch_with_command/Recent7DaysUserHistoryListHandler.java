package service.impl.replace_switch_with_command;

import entity.UserHistoryEntity;
import service.impl.UserCustomerService;

import java.util.List;

public class Recent7DaysUserHistoryListHandler { // concrete command
    private UserCustomerService userCustomerService;

    public Recent7DaysUserHistoryListHandler(UserCustomerService userCustomerService) {
        this.userCustomerService = userCustomerService;
    }

    public List<UserHistoryEntity> getTransactionHistory7Days(Long user_pk, Long account_pk) {
        return userCustomerService.getTransactionHistory7Days(user_pk, account_pk);
    }
}
