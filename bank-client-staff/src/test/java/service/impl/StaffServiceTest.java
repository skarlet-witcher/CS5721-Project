package service.impl;

import bankStaff_rpc.ListUserApplyArchiveEntitiesResponse;
import org.junit.jupiter.api.Test;
import rpc.client.StaffRpc;

import static org.junit.jupiter.api.Assertions.*;

class StaffServiceTest {

    @Test
    void getNewApplysReplies() {
        assertDoesNotThrow(()->{
            StaffRpc.getInstance().getNewApplysReplies();
        });
    }

    @Test
    void acceptAplication() throws Exception {
        assertDoesNotThrow(()->{
            StaffRpc.getInstance().acceptApplication(StaffRpc.getInstance().getNewApplysReplies().getListUserApplyArchiveEntitiesResponseList().get(0).getId());
        });
    }
}