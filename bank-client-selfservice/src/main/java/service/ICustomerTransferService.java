package service;

public interface ICustomerTransferService {
    void transfer(Long user_pk, Long account_pk, Long payee_pk,
                  Double amount, int pin, String postScript,
                  int currencyType, int operateSource) throws Exception;
}
