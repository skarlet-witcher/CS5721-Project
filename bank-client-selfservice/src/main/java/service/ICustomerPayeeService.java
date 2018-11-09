package service;

import model.UserPayeeModel;
import rpc.UserPayeesReply;

import java.util.List;

public interface ICustomerPayeeService {
    /*
        @pre userPayeeModel.getUserId() != null
        @post @result != null
     */
    List<UserPayeesReply> getPayeeList(UserPayeeModel userPayeeModel) throws Exception;
    /*
        @pre userPayeeModel.getUserId() != null
        @pre userPayeeModel.getIban() != null
        @pre pin != null
        @pre userPayeeModel.getName() != null
     */
    void addPayee(UserPayeeModel userPayeeModel, String pin) throws Exception;
    /*
        @pre userPayeeModel.getPayee_pk() != null
        @pre userPayeeModel.getUserId() != null
     */
    void removePayee(UserPayeeModel userPayeeModel) throws Exception;

}
