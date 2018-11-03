package rpc.client;

import Const.ResponseStatusType;
import bankStaff_rpc.StaffLoginGrpc;
import bankStaff_rpc.StaffLoginRequest;
import bankStaff_rpc.StaffLoginResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import rpc.Response;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static Const.Server.SERVER_HOST;
import static Const.Server.SERVER_PORT;

//Created manually by Long
public class StaffLoginRpc {
    private static final Logger logger = Logger.getLogger(StaffLoginRpc.class.getName());

    private static StaffLoginRpc instance = null;

    public static StaffLoginRpc getInstance() {
        if (instance == null) {
            return new StaffLoginRpc();
        }
        return instance;
    }

    public StaffLoginResponse login(StaffLoginRequest staffLoginRequest) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(SERVER_HOST, SERVER_PORT)
                .usePlaintext().build();
        StaffLoginGrpc.StaffLoginBlockingStub blockingStub = StaffLoginGrpc.newBlockingStub(channel);

        logger.info(staffLoginRequest.getStaffId() + " is requesting to login.");

        StaffLoginResponse response = blockingStub.staffLogin(staffLoginRequest);

        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(staffLoginRequest.getStaffId() + " login request detail check successful.");
            return response;
        } else {
            logger.info(staffLoginRequest.getStaffId() + " login request fail due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }

    }
}
