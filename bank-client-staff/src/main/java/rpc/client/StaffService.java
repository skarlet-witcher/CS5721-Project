package rpc.client;

import Const.ResponseStatusType;
import bankStaff_rpc.Empty;
import bankStaff_rpc.ListUserApplyArchiveEntitiesResponse;
import bankStaff_rpc.StaffGetNewAppliesGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import rpc.Response;
import rpc.UserNewApplysReply;
import service.IStaffService;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static Const.Server.SERVER_HOST;
import static Const.Server.SERVER_PORT;

public class StaffService implements IStaffService {
    private static final Logger logger = Logger.getLogger(StaffLoginRpc.class.getName());

    private static StaffService staffService;
    public static StaffService getInstance(){
        if(staffService == null){
            staffService = new StaffService();
            return staffService;
        }
        else return staffService;
    }
    @Override
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
}
