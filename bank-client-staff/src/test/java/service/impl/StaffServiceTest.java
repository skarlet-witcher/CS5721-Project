package service.impl;

import org.junit.jupiter.api.Test;
import rpc.client.StaffRpc;

import static org.junit.jupiter.api.Assertions.*;

class StaffServiceTest {

    @Test
    void getNewApplysReplies() {
        assertDoesNotThrow(()->{
            StaffRpc.getInstance().getNewApplesReplies();
        });
    }

    @Test
    void acceptAplication() throws Exception {
        assertDoesNotThrow(()->{
            StaffRpc.getInstance().acceptApplication(StaffRpc.getInstance().getNewApplesReplies().getListUserApplyArchiveEntitiesResponseList().get(0).getId());
        });
    }
}