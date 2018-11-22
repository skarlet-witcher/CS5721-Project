package rpc.client;

import Const.ResponseStatusType;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import rpc.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static Const.Server.SERVER_HOST;
import static Const.Server.SERVER_PORT;

public class CustomerLoginRpc {
    private static final Logger logger = Logger.getLogger(CustomerLoginRpc.class.getName());

    private static CustomerLoginRpc instance = null;

    public static CustomerLoginRpc getInstance() {
        if (instance == null) {
            return new CustomerLoginRpc();
        }
        return instance;
    }

    /**
     * Open a RPC connection to request a new PIN
     * @param userForgetPinRequest typical RPC request which is wrapped by information of userForgotPINModel object
     * @return RPC response from server-side
     * @throws Exception if system failed to execute this request
     */
    public Response forgetPinReq(UserForgetPinRequest userForgetPinRequest) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(SERVER_HOST, SERVER_PORT)
                .usePlaintext().build();
        UserCustomerLoginGrpc.UserCustomerLoginBlockingStub blockingStub = UserCustomerLoginGrpc.newBlockingStub(channel);
        logger.info(userForgetPinRequest.getUserId() + " is requesting to get PIN.");

        Response response = blockingStub.forgetPin(userForgetPinRequest);
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(userForgetPinRequest.getUserId() + " requesting to get PIN is successful");
            return response;
        } else {
            logger.info(userForgetPinRequest.getUserId() + " requesting to get PIN is failed due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }

    }
    public UserLoginReqReply loginReq(UserLoginReqRequest loginReqRequest) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(SERVER_HOST, SERVER_PORT)
                .usePlaintext().build();
        UserCustomerLoginGrpc.UserCustomerLoginBlockingStub blockingStub = UserCustomerLoginGrpc.newBlockingStub(channel);

        logger.info(loginReqRequest.getUserId() + " is requesting to login.");

        Response response = blockingStub.loginReq(loginReqRequest);

        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(loginReqRequest.getUserId() + " login request detail check successful.");
            return response.getUserLoginReqReply();
        } else {
            logger.info(loginReqRequest.getUserId() + " login request fail due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }

    }

    public UserLoginReply login(UserLoginRequest userLoginRequest) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(SERVER_HOST, SERVER_PORT)
                .usePlaintext().build();
        UserCustomerLoginGrpc.UserCustomerLoginBlockingStub blockingStub = UserCustomerLoginGrpc.newBlockingStub(channel);

        logger.info(userLoginRequest.getUserId() + " is requesting to login.");

        Response response = blockingStub.login(userLoginRequest);

        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(userLoginRequest.getUserId() + " login request detail check successful.");
            return response.getUserLoginReply();
        } else {
            logger.info(userLoginRequest.getUserId() + " login request fail due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }
    }

//Ashly

    public Response forgotUserIdReq(UserForgetUserIdRequest forgotUserIdRequest) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(SERVER_HOST, SERVER_PORT)
                .usePlaintext().build();
        UserCustomerLoginGrpc.UserCustomerLoginBlockingStub blockingStub = UserCustomerLoginGrpc.newBlockingStub(channel);

        logger.info(forgotUserIdRequest.getFirstName() + " forgot his user ID");

        Response response = blockingStub.forgetUserId(forgotUserIdRequest);

        
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(forgotUserIdRequest.getFirstName() + " details verified to be successful");
            return response;

        } else {
            logger.info(forgotUserIdRequest.getFirstName() + " request failed due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }

    }



}
