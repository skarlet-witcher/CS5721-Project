package service;

import bankStaff_rpc.ListUserApplyArchiveEntitiesResponse;
import bankStaff_rpc.StaffLoginResponse;
import bankStaff_rpc.UserApplyArchiveEntitiesResponse;
import entity.UserApplyArchiveEntity;
import rpc.UserNewApplysReply;

import java.util.List;

public interface IStaffService {
    StaffLoginResponse login(long staffId, String password) throws Exception;
    ListUserApplyArchiveEntitiesResponse getUserApplyArchiveEntities();
}
