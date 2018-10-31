package dao;


import entity.BankStaffEntity;

public interface IBankStaffDao {

    Long selectTheBiggestId();

    BankStaffEntity selectStaffByIdAndPassword(Long staffId, String password);
}
