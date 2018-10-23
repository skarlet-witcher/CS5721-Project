package rpc.client;

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
        if(customerApplyRpc == null) {
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

        if (response.getStatusCode() == 200) {
            logger.info(applyAccountRequest.getFirstName() + " apply request successful.");
            return response;
        } else {
            logger.info(applyAccountRequest.getFirstName() + " apply request fail due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }
    }
}
