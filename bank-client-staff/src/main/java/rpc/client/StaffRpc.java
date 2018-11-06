package rpc.client;

import Const.ResponseStatusType;
import bankStaff_rpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static Const.Server.SERVER_HOST;
import static Const.Server.SERVER_PORT;

//Created manually by Long
public class StaffRpc {
    private static final Logger logger = Logger.getLogger(StaffRpc.class.getName());

    private static StaffRpc instance = null;

    public static StaffRpc getInstance() {
        if (instance == null) {
            return new StaffRpc();
        }
        return instance;
    }


    public ListUserApplyArchiveEntitiesResponse getNewApplysReplies() throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(SERVER_HOST, SERVER_PORT)
                .usePlaintext().build();
        StaffGetNewAppliesGrpc.StaffGetNewAppliesBlockingStub blockingStub = StaffGetNewAppliesGrpc.newBlockingStub(channel);

        logger.info( "Getting list of applications.");

        ListUserApplyArchiveEntitiesResponse response = blockingStub.staffGetNewApplies(Empty.newBuilder().build());

        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info("Getting list of applications succeeds");
            return response;
        } else {
            logger.info("Getting list of applications fails due to" + response.getDescription());
            throw new Exception(response.getDescription());
        }
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

    public AcceptedResponse acceptApplication(long applicationId) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(SERVER_HOST, SERVER_PORT)
                .usePlaintext().build();
        AcceptApplicationGrpc.AcceptApplicationBlockingStub blockingStub = AcceptApplicationGrpc.newBlockingStub(channel);

        logger.info( "Requesting to accept an application.");

        AcceptedResponse response = blockingStub.acceptApplication(AcceptedRequest.newBuilder().setApplicationId(applicationId).build());

        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info("Apply an application successfully");
            return response;
        } else {
            logger.info("Apply an application failed" );
            throw new Exception("");
        }
    }
}
