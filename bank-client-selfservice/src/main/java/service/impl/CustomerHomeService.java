package service.impl;

import rpc.UserAccountsReply;
import rpc.UserCustomerGetAccountsRequest;
import rpc.client.CustomerMainRpc;
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
        List<UserAccountsReply> userAccountsReply = CustomerMainRpc.getInstance().getAccounts(
                UserCustomerGetAccountsRequest.newBuilder()
                        .setUserPk(id).build()
        );
        return userAccountsReply;

    }

}
