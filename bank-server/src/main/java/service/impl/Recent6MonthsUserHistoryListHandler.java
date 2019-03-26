package service.impl;

import entity.UserHistoryEntity;

import java.util.List;

public class Recent6MonthsUserHistoryListHandler {
    private UserCustomerService userCustomerService;

    public Recent6MonthsUserHistoryListHandler(UserCustomerService userCustomerService) {
        this.userCustomerService = userCustomerService;
    }

    public List<UserHistoryEntity> getTransactionHistory6Months(Long user_pk, Long account_pk) {
        return userCustomerService.getTransactionHistory6Months(user_pk, account_pk);
    }
}
