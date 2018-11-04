package service.impl;

import bankStaff_rpc.ListUserApplyArchiveEntitiesResponse;
import bankStaff_rpc.StaffLoginResponse;
import dao.IBankStaffDao;
import dao.impl.BankStaffDao;
import entity.BankStaffEntity;
import service.IStaffService;
import util.FaultFactory;

public class StaffService implements IStaffService {

    public static StaffService instance = null;
    private IBankStaffDao bankStaffDao = BankStaffDao.getInstance();


    public static StaffService getInstance() {
        if (instance == null) {
            instance = new StaffService();
        }
        return instance;
    }

    @Override
    public StaffLoginResponse login(long staffId, String password) throws Exception {
        BankStaffEntity bankStaffEntity = bankStaffDao.selectStaffByIdAndPassword(staffId, password);
        if (bankStaffEntity == null) {
            throw FaultFactory.throwFaultException("The Id you typed is not existed.");
        }
        StaffLoginResponse staffLoginResponse = StaffLoginResponse.newBuilder()
                .setIsValid(true)
                .setStatusCode(200).build();
        return staffLoginResponse;
    }


    @Override
    public ListUserApplyArchiveEntitiesResponse getUserApplyArchiveEntities() {
        ListUserApplyArchiveEntitiesResponse userApplyArchiveEntityList = bankStaffDao.selectUserApplyArchiveEntity();
        return userApplyArchiveEntityList;
    }
}
