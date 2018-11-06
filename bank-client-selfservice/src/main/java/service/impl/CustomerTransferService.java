package service.impl;

import model.UserTransferModel;
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
    public void transfer(UserTransferModel userTransferModel, int pin) throws Exception {
        UserCustomerRpc.getInstance().transfer(
                UserCustomerTransferRequest.newBuilder().setUserPk(userTransferModel.getPayee().getUserId())
                .setAccountPk(userTransferModel.getAccount().getAccount_pk())
                .setAmount(userTransferModel.getAmounts())
                .setPayeePk(userTransferModel.getPayee().getPayee_pk())
                        .setPostScript(userTransferModel.getPostScript())
                .setPin(pin).setCurrencyType(userTransferModel.getAccount().getCurrencyType()).build()
        );
    }
}
