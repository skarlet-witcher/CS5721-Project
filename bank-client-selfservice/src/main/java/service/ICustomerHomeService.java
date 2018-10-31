package service;

import rpc.UserAccountsReply;

import java.util.List;

public interface ICustomerHomeService {
    List<UserAccountsReply> getAccounts(Long id) throws Exception;

}
