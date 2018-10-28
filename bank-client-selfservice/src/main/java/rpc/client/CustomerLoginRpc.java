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

    public Response login(UserLoginRequest userLoginRequest) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(SERVER_HOST, SERVER_PORT)
                .usePlaintext().build();
        UserCustomerLoginGrpc.UserCustomerLoginBlockingStub blockingStub = UserCustomerLoginGrpc.newBlockingStub(channel);

        logger.info(userLoginRequest.getUserId() + " is requesting to login.");

        Response response = blockingStub.login(userLoginRequest);

        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(userLoginRequest.getUserId() + " login request detail check successful.");
            return response;
        } else {
            logger.info(userLoginRequest.getUserId() + " login request fail due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }
    }

}
