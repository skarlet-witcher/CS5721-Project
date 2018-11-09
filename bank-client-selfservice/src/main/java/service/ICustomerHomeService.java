package service;

import rpc.UserAccountsReply;

import java.util.List;

public interface ICustomerHomeService {
    /*
     @pre id != null
     @post @result != null
     */
    List<UserAccountsReply> getAccounts(Long id) throws Exception;

}
