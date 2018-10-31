package service.impl;

import model.UserPayeeModel;
import rpc.UserCustomerGetPayeesRequest;
import rpc.UserPayeesReply;
import rpc.client.CustomerPayeeRpc;
import rpc.client.UserCustomerRpc;
import service.ICustomerPayeeService;
import view.CustomerMainView;

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
    public UserPayeesReply addPayee(UserPayeeModel userPayeeModel) throws Exception {
        return null;
    }

    @Override
    public void removePayee(UserPayeeModel userPayeeModel) throws Exception {

    }
}
