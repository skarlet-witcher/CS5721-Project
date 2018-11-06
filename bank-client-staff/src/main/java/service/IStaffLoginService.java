package service;

import model.StaffLoginModel;

public interface IStaffLoginService {
    boolean staffLogin(StaffLoginModel staffLoginModel) throws Exception;
}
