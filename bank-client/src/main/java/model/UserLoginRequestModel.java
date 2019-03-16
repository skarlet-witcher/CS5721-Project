package model;

public class UserLoginRequestModel {
    private Long userId;
    private String phoneNumLast4;
    private int day;
    private int month;
    private int year;

    // login with last 4 digit of phone number
    public UserLoginRequestModel(Long userId, String phoneNumLast4) {
        this.userId = userId;
        this.phoneNumLast4 = phoneNumLast4;
    }

    // login with date of birth
    public UserLoginRequestModel(Long userId, int day, int month, int year) {
        this.userId = userId;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public UserLoginRequestModel() {}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhoneNumLast4() {
        return phoneNumLast4;
    }

    public void setPhoneNumLast4(String phoneNumLast4) {
        this.phoneNumLast4 = phoneNumLast4;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
