package service.impl;

import bankStaff_rpc.StaffLoginRequest;
import bankStaff_rpc.StaffLoginResponse;
import model.StaffLoginModel;
import rpc.client.StaffLoginRpc;
import service.IStaffLoginService;

public class StaffLoginService implements IStaffLoginService {
    private static IStaffLoginService instance;

    public static IStaffLoginService getInstance(){
        if(instance ==null){
            return new StaffLoginService();
        }
        else return instance;
    }
    @Override
    public boolean staffLogin(StaffLoginModel staffLoginModel) throws Exception {

        StaffLoginResponse staffLoginResponse = StaffLoginRpc.getInstance().login(
                StaffLoginRequest.newBuilder().setStaffId(staffLoginModel.getStaffId())
                .setPassword(staffLoginModel.getPassword())
                .build());
        if(staffLoginResponse.getIsValid()) return true;
        return false;
    }
}
