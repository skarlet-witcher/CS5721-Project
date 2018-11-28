package service.impl;

import bankStaff_rpc.*;
import rpc.client.StaffRpc;
import service.IStaffService;

import java.util.logging.Logger;

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
        return StaffRpc.getInstance().getNewApplesReplies();
    }


    @Override
    public AcceptedResponse acceptAplication(long applicationId) throws Exception {
        return StaffRpc.getInstance().acceptApplication(applicationId);
    }
}
