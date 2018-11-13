package service.impl;

import model.Observer;
import model.Subject;
import model.UserTransferModel;
import rpc.UserCustomerTransferRequest;
import rpc.client.UserCustomerRpc;
import service.ICustomerTransferService;

import java.util.ArrayList;
import java.util.List;

public class CustomerTransferService implements ICustomerTransferService {
    private static ICustomerTransferService customerTransferService = null;
    private List<Observer> observers;

    private CustomerTransferService() {
        observers = new ArrayList<>();
    }

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
