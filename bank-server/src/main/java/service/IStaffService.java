package service;

import bankStaff_rpc.StaffLoginResponse;

public interface IStaffService {
    StaffLoginResponse login(long staffId, String password) throws Exception;
}
