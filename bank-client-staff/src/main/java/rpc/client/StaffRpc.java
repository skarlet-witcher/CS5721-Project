package rpc.client;

import Const.ResponseStatusType;
import bankStaff_rpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static Const.Server.SERVER_HOST;
import static Const.Server.SERVER_PORT;

import app.StaffClient;

import javax.net.ssl.SSLException;

//Created manually by Long
public class StaffRpc {
    private static final Logger logger = Logger.getLogger(StaffRpc.class.getName());
    private static StaffLoginGrpc.StaffLoginBlockingStub loginBlockingStub;
    private static StaffGetNewAppliesGrpc.StaffGetNewAppliesBlockingStub getNewAppliesBlockingStub;
    private static AcceptApplicationGrpc.AcceptApplicationBlockingStub applicationBlockingStub;
    private static StaffRpc instance = null;

    public static StaffRpc getInstance() throws SSLException {
        if (instance == null) {
            instance = new StaffRpc();
            loginBlockingStub = StaffLoginGrpc.newBlockingStub(StaffClient.getChannel());
            getNewAppliesBlockingStub = StaffGetNewAppliesGrpc.newBlockingStub(StaffClient.getChannel());
            applicationBlockingStub = AcceptApplicationGrpc.newBlockingStub(StaffClient.getChannel());
        }
        return instance;
    }


    public ListUserApplyArchiveEntitiesResponse getNewApplesReplies() throws Exception {
        logger.info( "Getting list of applications.");

        ListUserApplyArchiveEntitiesResponse response = getNewAppliesBlockingStub.staffGetNewApplies(Empty.newBuilder().build());

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info("Getting list of applications succeeds");
            return response;
        } else {
            logger.info("Getting list of applications fails due to" + response.getDescription());
            throw new Exception(response.getDescription());
        }
    }

    public StaffLoginResponse login(StaffLoginRequest staffLoginRequest) throws Exception {
        logger.info(staffLoginRequest.getStaffId() + " is requesting to login.");

        StaffLoginResponse response = loginBlockingStub.staffLogin(staffLoginRequest);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(staffLoginRequest.getStaffId() + " login request detail check successful.");
            return response;
        } else {
            logger.info(staffLoginRequest.getStaffId() + " login request fail due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }

    }

    public AcceptedResponse acceptApplication(long applicationId) throws Exception {
        logger.info( "Requesting to accept an application.");

        AcceptedResponse response = applicationBlockingStub.acceptApplication(AcceptedRequest.newBuilder().setApplicationId(applicationId).build());


        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info("Apply an application successfully");
            return response;
        } else {
            logger.info("Apply an application failed" );
            throw new Exception("");
        }
    }
}
