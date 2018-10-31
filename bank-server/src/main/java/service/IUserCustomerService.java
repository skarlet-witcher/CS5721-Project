package service;

import rpc.UserAccountsReply;
import rpc.UserProfileReply;

import java.util.List;

public interface IUserCustomerService {
    List<UserAccountsReply> getAccounts(Long Id);

    UserProfileReply getUserProfile(Long Id) throws Exception;
}
