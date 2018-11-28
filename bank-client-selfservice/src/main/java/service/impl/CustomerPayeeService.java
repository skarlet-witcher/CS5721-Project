package service.impl;

import model.UserPayeeModel;
import rpc.UserCustomerAddPayeeRequest;
import rpc.UserCustomerGetPayeesRequest;
import rpc.UserCustomerRemovePayeeRequest;
import rpc.UserPayeesReply;
import rpc.client.CustomerPayeeRpc;
import service.ICustomerPayeeService;

import java.util.List;

public class CustomerPayeeService implements ICustomerPayeeService {
    private static ICustomerPayeeService customerPayeeService = null;

    public static ICustomerPayeeService getInstance() {
        if(customerPayeeService == null) {
            customerPayeeService = new CustomerPayeeService();
        }
        return customerPayeeService;
    }

    @Override
    public List<UserPayeesReply> getPayeeList(UserPayeeModel userPayeeModel) throws Exception {
        List<UserPayeesReply> userPayeesReplies = CustomerPayeeRpc.getInstance().getPayeeList(
                UserCustomerGetPayeesRequest.newBuilder()
                        .setUserPk(userPayeeModel.getUserId()).build()
        );
        return userPayeesReplies;
    }

    @Override
    public void addPayee(UserPayeeModel userPayeeModel, String pin) throws Exception {
        CustomerPayeeRpc.getInstance().addPayee(
                UserCustomerAddPayeeRequest.newBuilder()
                .setUserPk(userPayeeModel.getUserId())
                .setIban(userPayeeModel.getIban())
                .setPin(pin)
                .setName(userPayeeModel.getName()).build()
        );
    }

    @Override
    public void removePayee(UserPayeeModel userPayeeModel) throws Exception {
        CustomerPayeeRpc.getInstance().removePayee(
                UserCustomerRemovePayeeRequest.newBuilder().setPayeePk(userPayeeModel.getPayee_pk())
                .setUserPk(userPayeeModel.getUserId()).build()
        );
    }
}
