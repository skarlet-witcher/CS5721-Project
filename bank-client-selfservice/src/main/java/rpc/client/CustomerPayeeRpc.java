package rpc.client;

import Const.ResponseStatusType;
import rpc.*;

import javax.net.ssl.SSLException;
import java.util.List;
import java.util.logging.Logger;

public class CustomerPayeeRpc extends ClientRpc {
    private static final Logger logger = Logger.getLogger(CustomerPayeeRpc.class.getName());
    private static UserCustomerGrpc.UserCustomerBlockingStub blockingStub;
    private static CustomerPayeeRpc customerPayeeRpc = null;

    public static CustomerPayeeRpc getInstance() throws SSLException {
        if (customerPayeeRpc == null) {
            customerPayeeRpc = new CustomerPayeeRpc();
            blockingStub = UserCustomerGrpc.newBlockingStub(getChannel());
        }
        return customerPayeeRpc;
    }

    public List<UserPayeesReply> getPayeeList(UserCustomerGetPayeesRequest userCustomerGetPayeesRequest) throws Exception {
        logger.info(userCustomerGetPayeesRequest.getUserPk() + " is requesting to get payee list.");

        Response response = blockingStub.getPayees(userCustomerGetPayeesRequest);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(userCustomerGetPayeesRequest.getUserPk() + " requesting to get payee list is successful");
            return response.getUserPayeesList();
        } else {
            logger.info(userCustomerGetPayeesRequest.getUserPk() + " requesting to get payee list is failed due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }
    }

    public Response addPayee(UserCustomerAddPayeeRequest userCustomerAddPayeeRequest) throws Exception {
        logger.info(userCustomerAddPayeeRequest.getUserPk() + " is requesting to add payee.");

        Response response = blockingStub.addPayee(userCustomerAddPayeeRequest);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(userCustomerAddPayeeRequest.getUserPk() + " requesting to add payee is successful");
            return response;
        } else {
            logger.info(userCustomerAddPayeeRequest.getUserPk() + " requesting to add payee is failed due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }
    }

    public Response removePayee(UserCustomerRemovePayeeRequest userCustomerRemovePayeeRequest) throws Exception {
        logger.info(userCustomerRemovePayeeRequest.getUserPk() + " is requesting to remove payee.");

        Response response = blockingStub.removePayee(userCustomerRemovePayeeRequest);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(userCustomerRemovePayeeRequest.getUserPk() + " requesting to remove payee is successful");
            return response;
        } else {
            logger.info(userCustomerRemovePayeeRequest.getUserPk() + " requesting to remove payee is failed due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }
    }

}
