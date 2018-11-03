package service;

import rpc.UserAccountsReply;
import rpc.UserPayeesReply;
import rpc.UserProfileReply;

import java.util.List;

public interface IUserCustomerService {
    List<UserAccountsReply> getAccounts(Long user_pk) throws Exception;

    UserProfileReply getUserProfile(Long user_pk) throws Exception;

    void editUserProfile(Long user_pk, String address, String email, String contactNum) throws Exception;

    List<UserPayeesReply> getPayeeList(Long user_pk) throws Exception;

    void addPayee(Long user_pk, String payeeName, String iban, String pin) throws Exception;

    void removePayee(Long user_pk, Long userId) throws Exception;

    void transfer(Long payee_pk, Long user_pk, Long account_pk, Double amount, String pin) throws Exception;
}
