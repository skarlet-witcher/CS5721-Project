package service.impl.replace_switch_with_command;

import entity.UserHistoryEntity;
import service.impl.UserCustomerService;

import java.util.List;

public class Recent1MonthUserHistoryListHandler {
    private UserCustomerService userCustomerService;

    public Recent1MonthUserHistoryListHandler(UserCustomerService userCustomerService) {
        this.userCustomerService = userCustomerService;
    }

    public List<UserHistoryEntity> getTransactionHistory1Month(Long user_pk, Long account_pk) {
        return userCustomerService.getTransactionHistory1Month(user_pk, account_pk);
    }
}
