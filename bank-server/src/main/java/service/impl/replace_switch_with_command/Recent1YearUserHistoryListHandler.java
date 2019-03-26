package service.impl.replace_switch_with_command;

import entity.UserHistoryEntity;
import service.impl.UserCustomerService;

import java.util.List;

public class Recent1YearUserHistoryListHandler { // concrete command
    private UserCustomerService userCustomerService;

    public Recent1YearUserHistoryListHandler(UserCustomerService userCustomerService) {
        this.userCustomerService = userCustomerService;
    }

    public List<UserHistoryEntity> getTransactionHistory1Year(Long user_pk, Long account_pk) {
        return userCustomerService.getTransactionHistory1Year(user_pk, account_pk);
    }
}
