package dao;


import bankStaff_rpc.ListUserApplyArchiveEntitiesResponse;
import bankStaff_rpc.UserApplyArchiveEntitiesResponse;
import entity.BankStaffEntity;

import java.util.List;

public interface IBankStaffDao {

    Long selectTheBiggestId();

    BankStaffEntity selectStaffByIdAndPassword(Long staffId, String password);
    ListUserApplyArchiveEntitiesResponse selectUserApplyArchiveEntity();

}
