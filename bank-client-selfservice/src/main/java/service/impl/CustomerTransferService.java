package service.impl;

import rpc.UserCustomerTransferRequest;
import rpc.client.UserCustomerRpc;
import service.ICustomerTransferService;

public class CustomerTransferService implements ICustomerTransferService {
    private static ICustomerTransferService customerTransferService = null;

    private CustomerTransferService() {}

    public static ICustomerTransferService getInstance() {
        if(customerTransferService == null) {
            customerTransferService = new CustomerTransferService();
        }
        return customerTransferService;
    }

    @Override
    public void transfer(Long user_pk, Long account_pk, Long payee_pk, Double amount,
                         int pin, String postScript, int currencyType, int operateSource) throws Exception {
        UserCustomerRpc.getInstance().transfer(
                UserCustomerTransferRequest.newBuilder().setUserPk(user_pk)
                .setAccountPk(account_pk)
                .setAmount(amount)
                .setPayeePk(payee_pk)
                .setOperateSource(operateSource)
                        .setPostScript(postScript)
                .setPin(pin).setCurrencyType(currencyType).build()
        );
    }
}
