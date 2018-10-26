package model;

import java.sql.Timestamp;

public class UserForgotPINModel {
    private Long userId;
    private Timestamp birthDate;
    private String email;
    private Integer identityType;
    private Integer identityNum;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdentityType() {
        return identityType;
    }

    public void setIdentityType(Integer identityType) {
        this.identityType = identityType;
    }

    public Integer getIdentityNum() {
        return identityNum;
    }

    public void setIdentityNum(Integer identityNum) {
        this.identityNum = identityNum;
    }
}
