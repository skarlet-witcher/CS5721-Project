package entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_apply_archive", schema = "bank_manage", catalog = "")
public class UserApplyArchiveEntity {
    private long id;
    private String firstName;
    private String lastName;
    private String identityId;
    private int identityIdType;
    private long accountType;
    private int cardType;
    private Timestamp graduateDate;
    private String university;
    private String studentId;
    private Long parentUserId;
    private String parentFirstName;
    private String parentLastName;
    private Timestamp birthDate;
    private int gender;
    private String address;
    private String email;
    private String phone;
    private Timestamp applyTime;
    private int status;
    private String remark;
    private Long userId;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 255)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 255)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "identity_id", nullable = false, length = 50)
    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    @Basic
    @Column(name = "identity_id_type", nullable = false)
    public int getIdentityIdType() {
        return identityIdType;
    }

    public void setIdentityIdType(int identityIdType) {
        this.identityIdType = identityIdType;
    }

    @Basic
    @Column(name = "account_type", nullable = false)
    public long getAccountType() {
        return accountType;
    }

    public void setAccountType(long accountType) {
        this.accountType = accountType;
    }

    @Basic
    @Column(name = "card_type", nullable = false)
    public int getCardType() {
        return cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    @Basic
    @Column(name = "graduate_date", nullable = true)
    public Timestamp getGraduateDate() {
        return graduateDate;
    }

    public void setGraduateDate(Timestamp graduateDate) {
        this.graduateDate = graduateDate;
    }

    @Basic
    @Column(name = "university", nullable = true, length = 255)
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Basic
    @Column(name = "student_id", nullable = true, length = 50)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "parent_user_id", nullable = true)
    public Long getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(Long parentUserId) {
        this.parentUserId = parentUserId;
    }

    @Basic
    @Column(name = "parent_first_name", nullable = true, length = 255)
    public String getParentFirstName() {
        return parentFirstName;
    }

    public void setParentFirstName(String parentFirstName) {
        this.parentFirstName = parentFirstName;
    }

    @Basic
    @Column(name = "parent_last_name", nullable = true, length = 255)
    public String getParentLastName() {
        return parentLastName;
    }

    public void setParentLastName(String parentLastName) {
        this.parentLastName = parentLastName;
    }

    @Basic
    @Column(name = "birth_date", nullable = false)
    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "gender", nullable = false)
    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "apply_time", nullable = false)
    public Timestamp getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Timestamp applyTime) {
        this.applyTime = applyTime;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 255)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserApplyArchiveEntity that = (UserApplyArchiveEntity) o;

        if (id != that.id) return false;
        if (identityIdType != that.identityIdType) return false;
        if (accountType != that.accountType) return false;
        if (cardType != that.cardType) return false;
        if (gender != that.gender) return false;
        if (status != that.status) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (identityId != null ? !identityId.equals(that.identityId) : that.identityId != null) return false;
        if (graduateDate != null ? !graduateDate.equals(that.graduateDate) : that.graduateDate != null) return false;
        if (university != null ? !university.equals(that.university) : that.university != null) return false;
        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;
        if (parentUserId != null ? !parentUserId.equals(that.parentUserId) : that.parentUserId != null) return false;
        if (parentFirstName != null ? !parentFirstName.equals(that.parentFirstName) : that.parentFirstName != null)
            return false;
        if (parentLastName != null ? !parentLastName.equals(that.parentLastName) : that.parentLastName != null)
            return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (applyTime != null ? !applyTime.equals(that.applyTime) : that.applyTime != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        return userId != null ? userId.equals(that.userId) : that.userId == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (identityId != null ? identityId.hashCode() : 0);
        result = 31 * result + identityIdType;
        result = 31 * result + (int) (accountType ^ (accountType >>> 32));
        result = 31 * result + cardType;
        result = 31 * result + (graduateDate != null ? graduateDate.hashCode() : 0);
        result = 31 * result + (university != null ? university.hashCode() : 0);
        result = 31 * result + (studentId != null ? studentId.hashCode() : 0);
        result = 31 * result + (parentUserId != null ? parentUserId.hashCode() : 0);
        result = 31 * result + (parentFirstName != null ? parentFirstName.hashCode() : 0);
        result = 31 * result + (parentLastName != null ? parentLastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + gender;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (applyTime != null ? applyTime.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
