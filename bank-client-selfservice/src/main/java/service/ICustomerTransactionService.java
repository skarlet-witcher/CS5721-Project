package service;

import rpc.UserTransactionsReply;

import java.util.List;

public interface ICustomerTransactionService {
    List<UserTransactionsReply> getTransaction(Long user_pk, Long accountNum, int filter) throws Exception;
}
