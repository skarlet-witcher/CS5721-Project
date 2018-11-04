package service;

import bankStaff_rpc.ListUserApplyArchiveEntitiesResponse;
import rpc.UserNewApplysReply;

import java.util.List;

public interface IStaffService {
    ListUserApplyArchiveEntitiesResponse getNewApplysReplies() throws InterruptedException, Exception;
}
