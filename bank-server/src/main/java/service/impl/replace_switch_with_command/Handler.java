package service.impl.replace_switch_with_command;

import entity.UserHistoryEntity;
import service.impl.UserCustomerService;

import java.util.List;

public abstract class Handler { // Command
    protected UserCustomerService userCustomerService;

    public Handler(UserCustomerService userCustomerService) {
        this.userCustomerService = userCustomerService;
    }

    public abstract List<UserHistoryEntity> execute(Long user_pk, Long account_pk);
}
