package service;

import rpc.UserAccountsReply;

import java.util.List;

public interface IUserCustomerService {
    List<UserAccountsReply> getAccounts(Long id);
}
