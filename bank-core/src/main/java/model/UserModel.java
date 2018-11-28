package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private Long id;
    private Long userId;
    private String firstName;
    private String lastName;
    private int gender;
    private Timestamp birthDate;
    private String address;
    private String email;
    private String contactNum;
    private Integer pin;
    private List<UserAccountModel> userAccountList;
    private List<UserPayeeModel> userPayeeList;
    private Timestamp lastLoginTime;

    public UserModel() {
        userAccountList = new ArrayList<>();
        userPayeeList = new ArrayList<>();
    }

    public UserModel(Long userId) {
        this.setUserId(userId);
        userAccountList = new ArrayList<>();
        userPayeeList = new ArrayList<>();
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public List<UserAccountModel> getUserAccountList() {
        return userAccountList;
    }

    public void setUserAccountList(List<UserAccountModel> userAccountList) {
        this.userAccountList = userAccountList;
    }

    public List<UserPayeeModel> getUserPayeeList() {
        return userPayeeList;
    }

    public void setUserPayeeList(List<UserPayeeModel> userPayeeList) {
        this.userPayeeList = userPayeeList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }
}
