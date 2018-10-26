package model;

import java.sql.Timestamp;

public class UserApplyNewStudentAccountBaseModel extends UserApplyNewRequestBaseModel {
    private Integer cardType;
    private Timestamp graduateDate;
    private String studentId;
    private String schoolName;

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Timestamp getGraduateDate() {
        return graduateDate;
    }

    public void setGraduateDate(Timestamp graduateDate) {
        this.graduateDate = graduateDate;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}