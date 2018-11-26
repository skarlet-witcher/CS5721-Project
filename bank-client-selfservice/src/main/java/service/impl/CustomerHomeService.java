package service.impl;

import model.UserAccountModel;
import model.UserModel;

import rpc.UserAccountsReply;
import rpc.UserCustomerGetAccountsRequest;
import rpc.client.UserCustomerRpc;
import service.ICustomerHomeService;

import java.util.List;


public class CustomerHomeService implements ICustomerHomeService {
    private static ICustomerHomeService customerHomeService = null;

    public static ICustomerHomeService getInstance() {
        if(customerHomeService == null) {
            customerHomeService = new CustomerHomeService();
        }
        return customerHomeService;
    }

    @Override
    public List<UserAccountsReply> getAccounts(Long id) throws Exception {
        List<UserAccountsReply> userAccountsReply = UserCustomerRpc.getInstance().getAccounts(
                UserCustomerGetAccountsRequest.newBuilder()
                        .setUserPk(id).build()
        );
        return userAccountsReply;

    }

}
