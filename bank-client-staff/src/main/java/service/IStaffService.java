package service;

import bankStaff_rpc.AcceptedResponse;
import bankStaff_rpc.ListUserApplyArchiveEntitiesResponse;
import bankStaff_rpc.UserApplyArchiveEntitiesResponse;
import rpc.UserNewApplysReply;

import java.util.List;

public interface IStaffService {
    ListUserApplyArchiveEntitiesResponse getNewApplysReplies() throws InterruptedException, Exception;
    AcceptedResponse acceptAplication(long applicationId) throws Exception;
}
