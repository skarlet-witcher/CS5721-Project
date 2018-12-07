package service;

import bankStaff_rpc.AcceptedResponse;
import bankStaff_rpc.ListUserApplyArchiveEntitiesResponse;

public interface IStaffService {
    ListUserApplyArchiveEntitiesResponse getNewApplysReplies() throws InterruptedException, Exception;
    AcceptedResponse acceptAplication(long applicationId) throws Exception;
}
