package model;

public class StaffLoginModel {
    private long staffId;
    private String password;

    public StaffLoginModel(long staffId, String password) {
        this.staffId = staffId;
        this.password = password;
    }

    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
