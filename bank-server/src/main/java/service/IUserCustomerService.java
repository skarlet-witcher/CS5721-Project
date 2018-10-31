package service;

import rpc.UserAccountsReply;
import rpc.UserProfileReply;

import java.util.List;

public interface IUserCustomerService {
    List<UserAccountsReply> getAccounts(Long Id) throws Exception;

    UserProfileReply getUserProfile(Long Id) throws Exception;

    void editUserProfile(Long id, String address, String email, String contactNum) throws Exception;
}
