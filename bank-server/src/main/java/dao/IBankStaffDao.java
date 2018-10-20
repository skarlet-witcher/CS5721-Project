package dao;

import entity.BankStaffEntity;

public interface IBankStaffDao {
    BankStaffEntity LoginStaffByUsername(String username, String password);

}
