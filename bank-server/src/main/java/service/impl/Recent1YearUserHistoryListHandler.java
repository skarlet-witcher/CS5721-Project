package service.impl;

import entity.UserHistoryEntity;

import java.util.List;

public class Recent1YearUserHistoryListHandler {
    private UserCustomerService userCustomerService;

    public Recent1YearUserHistoryListHandler(UserCustomerService userCustomerService) {
        this.userCustomerService = userCustomerService;
    }

    public List<UserHistoryEntity> getTransactionHistory1Year(Long user_pk, Long account_pk) {
        return userCustomerService.getTransactionHistory1Year(user_pk, account_pk);
    }
}
