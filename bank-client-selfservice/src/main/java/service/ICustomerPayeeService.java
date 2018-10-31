package service;

import model.UserPayeeModel;
import rpc.UserPayeesReply;

import java.util.List;

public interface ICustomerPayeeService {
    List<UserPayeesReply> getPayeeList(UserPayeeModel userPayeeModel) throws Exception;

    UserPayeesReply addPayee(UserPayeeModel userPayeeModel) throws Exception;

    void removePayee(UserPayeeModel userPayeeModel) throws Exception;

}
