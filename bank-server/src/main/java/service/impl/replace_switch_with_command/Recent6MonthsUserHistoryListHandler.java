package service.impl.replace_switch_with_command;

import entity.UserHistoryEntity;
import service.impl.UserCustomerService;

import java.util.List;

public class Recent6MonthsUserHistoryListHandler {  // concrete command
    private UserCustomerService userCustomerService;

    public Recent6MonthsUserHistoryListHandler(UserCustomerService userCustomerService) {
        this.userCustomerService = userCustomerService;
    }

    public List<UserHistoryEntity> getTransactionHistory6Months(Long user_pk, Long account_pk) {
        return userCustomerService.getTransactionHistory6Months(user_pk, account_pk);
    }
}
