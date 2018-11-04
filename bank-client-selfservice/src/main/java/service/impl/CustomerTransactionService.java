package service.impl;

import rpc.UserCustomerGetTransactionsRequest;
import rpc.UserTransactionsReply;
import rpc.client.UserCustomerRpc;
import service.ICustomerTransactionService;

import javax.swing.*;
import java.util.List;

public class CustomerTransactionService implements ICustomerTransactionService {
    private static ICustomerTransactionService customerTransactionService=  null;

    private CustomerTransactionService() {}

    public static ICustomerTransactionService getInstance() {
        if(customerTransactionService == null) {
            customerTransactionService = new CustomerTransactionService();
        }
        return customerTransactionService;
    }


    @Override
    public List<UserTransactionsReply> getTransaction(Long user_pk, Long accountPk, int filter) throws Exception {
        List<UserTransactionsReply> userTransactionsReplies = UserCustomerRpc.getInstance().getTransactions(
                UserCustomerGetTransactionsRequest.newBuilder().setUserPk(user_pk)
                .setFilterByAccount(accountPk)
                .setFilterByAccount(filter).build()
        );
        return userTransactionsReplies;
    }
}
