package service;

import bankStaff_rpc.*;
import entity.UserApplyArchiveEntity;
import rpc.UserNewApplysReply;

import java.util.List;

public interface IStaffService {
    StaffLoginResponse login(long staffId, String password) throws Exception;
    ListUserApplyArchiveEntitiesResponse getUserApplyArchiveEntities();

    AcceptedResponse acceptApplication(AcceptedRequest request);
}
