package service.impl;

import Const.ResponseStatusType;
import bankStaff_rpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import rpc.client.StaffRpc;
import service.IStaffService;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static Const.Server.SERVER_HOST;
import static Const.Server.SERVER_PORT;

public class StaffService implements IStaffService {
    private static final Logger logger = Logger.getLogger(StaffRpc.class.getName());

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
        return StaffRpc.getInstance().getNewApplysReplies();
    }


    @Override
    public AcceptedResponse acceptAplication(long applicationId) throws Exception {
        return StaffRpc.getInstance().acceptApplication(applicationId);
    }
}
