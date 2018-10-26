package rpc.client;

import Const.ResponseStatusType;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import rpc.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static Const.Server.SERVER_HOST;
import static Const.Server.SERVER_PORT;

public class CustomerApplyRpc {
    private static final Logger logger = Logger.getLogger(CustomerApplyRpc.class.getName());

    private static CustomerApplyRpc customerApplyRpc = null;

    public static CustomerApplyRpc getInstance() {
        if (customerApplyRpc == null) {
            customerApplyRpc = new CustomerApplyRpc();
        }
        return customerApplyRpc;
    }

    public Response applyReq(UserApplyNewAccountRequest applyAccountRequest) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(SERVER_HOST, SERVER_PORT)
                .usePlaintext().build();
        UserCustomerLoginGrpc.UserCustomerLoginBlockingStub blockingStub = UserCustomerLoginGrpc.newBlockingStub(channel);


        logger.info("A new User is requesting to apply.");

        Response response = blockingStub.applyNewAccount(applyAccountRequest);

        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(applyAccountRequest.getFirstName() + " apply request successful.");
            return response;
        } else {
            logger.info(applyAccountRequest.getFirstName() + " apply request fail due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }

    }
    public Response checkExistingUserBeforeApply(UserValidateExistingUserRequest userValidateExistingUserRequest) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(SERVER_HOST, SERVER_PORT)
                .usePlaintext().build();
        UserCustomerLoginGrpc.UserCustomerLoginBlockingStub blockingStub = UserCustomerLoginGrpc.newBlockingStub(channel);


        logger.info(userValidateExistingUserRequest.getUserId() +" is requesting to validate.");

        Response response = blockingStub.validateExistingUser(userValidateExistingUserRequest);

        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(userValidateExistingUserRequest.getUserId() + " validation request successful.");
            return response;
        } else {
            logger.info(userValidateExistingUserRequest.getUserId() + " validation request failure due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }

    }

}
