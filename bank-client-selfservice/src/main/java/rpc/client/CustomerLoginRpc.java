package rpc.client;

import Const.ResponseStatusType;
import rpc.*;

import javax.net.ssl.SSLException;
import java.util.logging.Logger;

public class CustomerLoginRpc extends ClientRpc {
    private static final Logger logger = Logger.getLogger(CustomerLoginRpc.class.getName());
    private static UserCustomerLoginGrpc.UserCustomerLoginBlockingStub blockingStub;
    private static CustomerLoginRpc instance = null;

    public static CustomerLoginRpc getInstance() throws SSLException {
        if (instance == null) {
            instance = new CustomerLoginRpc();
            blockingStub = UserCustomerLoginGrpc.newBlockingStub(getChannel());
        }
        return instance;
    }

    /**
     * Open a RPC connection to request a new PIN
     *
     * @param userForgetPinRequest typical RPC request which is wrapped by information of userForgotPINModel object
     * @return RPC response from server-side
     * @throws Exception if system failed to execute this request
     */
    public Response forgetPinReq(UserForgetPinRequest userForgetPinRequest) throws Exception {
        logger.info(userForgetPinRequest.getUserId() + " is requesting to get PIN.");

        Response response = blockingStub.forgetPin(userForgetPinRequest);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(userForgetPinRequest.getUserId() + " requesting to get PIN is successful");
            return response;
        } else {
            logger.info(userForgetPinRequest.getUserId() + " requesting to get PIN is failed due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }

    }

    public UserLoginReqReply loginReq(UserLoginReqRequest loginReqRequest) throws Exception {
        logger.info(loginReqRequest.getUserId() + " is requesting to login.");

        Response response = blockingStub.loginReq(loginReqRequest);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(loginReqRequest.getUserId() + " login request successful. Details of inputting the PIN have returned. ");
            return response.getUserLoginReqReply();
        } else {
            logger.info(loginReqRequest.getUserId() + " login request fail due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }

    }

    public UserLoginReply login(UserLoginRequest userLoginRequest) throws Exception {
        logger.info(userLoginRequest.getUserId() + " is requesting to login using PIN.");

        Response response = blockingStub.login(userLoginRequest);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(userLoginRequest.getUserId() + " PIN login request check successful.");
            return response.getUserLoginReply();
        } else {
            logger.info(userLoginRequest.getUserId() + " PIN login request fail due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }
    }

//Ashly

    public Response forgotUserIdReq(UserForgetUserIdRequest forgotUserIdRequest) throws Exception {
        logger.info(forgotUserIdRequest.getFirstName() + " forgot his user ID");

        Response response = blockingStub.forgetUserId(forgotUserIdRequest);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(forgotUserIdRequest.getFirstName() + " details verified to be successful");
            return response;
        } else {
            logger.info(forgotUserIdRequest.getFirstName() + " request failed due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }

    }


}
