package util;

import dao.impl.BankStaffDao;
import entity.BankStaffEntity;

import java.util.List;

public class StaffIdGenerator {
    private static StaffIdGenerator staffIdGenerator = null;

    private StaffIdGenerator() {

    }

    public static StaffIdGenerator getInstance() {
        if(staffIdGenerator == null) {
            staffIdGenerator = new StaffIdGenerator();
        }
        return staffIdGenerator;
    }

    public long generateStaffId() {
        long currentId = 1000000000;
        List<BankStaffEntity> bankStaffList = BankStaffDao.getInstance().getBankStaff();
        for(int i = 0; i< bankStaffList.size(); i++) {
            if(bankStaffList.size() <= 0) {
                break;
            }
            if(bankStaffList.get(i).getStaffId() == currentId) {
                currentId++;
            }
        }
        return currentId;
    }
}
