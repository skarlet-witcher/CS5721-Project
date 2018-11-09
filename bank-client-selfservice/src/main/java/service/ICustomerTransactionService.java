package service;

import rpc.UserTransactionsReply;

import java.util.List;

public interface ICustomerTransactionService {
    /*
        @pre user_pk != null
        @pre accountNum != null
        @pre filter != null
        @post @result != null
     */
    List<UserTransactionsReply> getTransaction(Long user_pk, Long accountNum, int filter) throws Exception;
}
