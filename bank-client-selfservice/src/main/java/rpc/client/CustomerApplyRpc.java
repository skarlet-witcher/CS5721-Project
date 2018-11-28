package rpc.client;

import Const.ResponseStatusType;
import app.MainApp;
import rpc.Response;
import rpc.UserApplyNewAccountRequest;
import rpc.UserCustomerLoginGrpc;
import rpc.UserValidateExistingUserRequest;

import javax.net.ssl.SSLException;
import java.util.logging.Logger;

/*
    @author Xiangkai Tang
 */

public class CustomerApplyRpc {
    private static final Logger logger = Logger.getLogger(CustomerApplyRpc.class.getName());
    private static UserCustomerLoginGrpc.UserCustomerLoginBlockingStub blockingStub;
    private static CustomerApplyRpc customerApplyRpc = null;

    public static CustomerApplyRpc getInstance() throws SSLException {
        if (customerApplyRpc == null) {
            customerApplyRpc = new CustomerApplyRpc();
            blockingStub = UserCustomerLoginGrpc.newBlockingStub(MainApp.getChannel());
        }
        return customerApplyRpc;
    }

    public Response applyReq(UserApplyNewAccountRequest applyAccountRequest) throws Exception {

        logger.info("A new User is requesting to apply.");

        Response response = blockingStub.applyNewAccount(applyAccountRequest);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(applyAccountRequest.getFirstName() + " apply request successful.");
            return response;
        } else {
            logger.info(applyAccountRequest.getFirstName() + " apply request fail due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }
    }

    public Response checkExistingUserBeforeApply(UserValidateExistingUserRequest userValidateExistingUserRequest) throws Exception {
        logger.info(userValidateExistingUserRequest.getUserId() + " is requesting to validate user existence.");

        Response response = blockingStub.validateExistingUser(userValidateExistingUserRequest);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(userValidateExistingUserRequest.getUserId() + " validate user existence successful.");
            return response;
        } else {
            logger.info(userValidateExistingUserRequest.getUserId() + " validate user existence failure due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }

    }

}
