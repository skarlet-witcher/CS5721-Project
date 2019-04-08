package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "user_apply_archive", schema = "bank_manage", catalog = "")
public class UserApplyArchiveEntity {
    private Long id;
    private String firstName;
    private String lastName;
    private String identityId;
    private Integer identityIdType;
    private Integer accountType;
    private Integer cardType;
    private Timestamp graduateDate;
    private String university;
    private String studentId;
    private Long parentUserId;
    private String parentFirstName;
    private String parentLastName;
    private Timestamp birthDate;
    private Integer gender;
    private String address;
    private String email;
    private String phone;
    private Timestamp applyTime;
    private Integer status;
    private String remark;
    private Long userId;
    private Integer newUserApply;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name", nullable = true, length = 255)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 255)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "identity_id", nullable = true, length = 50)
    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    @Basic
    @Column(name = "identity_id_type", nullable = true)
    public Integer getIdentityIdType() {
        return identityIdType;
    }

    public void setIdentityIdType(Integer identityIdType) {
        this.identityIdType = identityIdType;
    }

    @Basic
    @Column(name = "account_type", nullable = false)
    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    @Basic
    @Column(name = "card_type", nullable = false)
    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
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
    @Column(name = "birth_date", nullable = true)
    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "gender", nullable = true)
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 20)
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
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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

    @Basic
    @Column(name = "new_user_apply", nullable = false)
    public Integer getNewUserApply() {
        return newUserApply;
    }

    public void setNewUserApply(Integer newUserApply) {
        this.newUserApply = newUserApply;
    }



    public UserApplyArchiveEntity generateObjectFromUserEntity(UserEntity userEntity){

        UserApplyArchiveEntity userApplyArchiveEntity= new UserApplyArchiveEntity();

        userApplyArchiveEntity.setFirstName(userEntity.getFirstName());
        userApplyArchiveEntity.setLastName(userEntity.getLastName());
       // userApplyArchiveEntity.setIdentityId(userEntity.getId());
        userApplyArchiveEntity.setAccountType(userEntity.getaccountType);
        userApplyArchiveEntity.setCardType(cardType);
        userApplyArchiveEntity.setBirthDate(birthDate);
        userApplyArchiveEntity.setGender(gender);
        userApplyArchiveEntity.setAddress(address);
        userApplyArchiveEntity.setEmail(email);
        userApplyArchiveEntity.setPhone(phone);
        userApplyArchiveEntity.setApplyTime(new Timestamp(new Date().getTime()));
        userApplyArchiveEntity.setStatus(0);
        userApplyArchiveEntity.setNewUserApply(isNewUser);
        userApplyArchiveEntity.setUserId(userId)



    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserApplyArchiveEntity that = (UserApplyArchiveEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (identityId != null ? !identityId.equals(that.identityId) : that.identityId != null) return false;
        if (identityIdType != null ? !identityIdType.equals(that.identityIdType) : that.identityIdType != null)
            return false;
        if (accountType != null ? !accountType.equals(that.accountType) : that.accountType != null) return false;
        if (cardType != null ? !cardType.equals(that.cardType) : that.cardType != null) return false;
        if (graduateDate != null ? !graduateDate.equals(that.graduateDate) : that.graduateDate != null) return false;
        if (university != null ? !university.equals(that.university) : that.university != null) return false;
        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;
        if (parentUserId != null ? !parentUserId.equals(that.parentUserId) : that.parentUserId != null) return false;
        if (parentFirstName != null ? !parentFirstName.equals(that.parentFirstName) : that.parentFirstName != null)
            return false;
        if (parentLastName != null ? !parentLastName.equals(that.parentLastName) : that.parentLastName != null)
            return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (applyTime != null ? !applyTime.equals(that.applyTime) : that.applyTime != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        return newUserApply != null ? newUserApply.equals(that.newUserApply) : that.newUserApply == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (identityId != null ? identityId.hashCode() : 0);
        result = 31 * result + (identityIdType != null ? identityIdType.hashCode() : 0);
        result = 31 * result + (accountType != null ? accountType.hashCode() : 0);
        result = 31 * result + (cardType != null ? cardType.hashCode() : 0);
        result = 31 * result + (graduateDate != null ? graduateDate.hashCode() : 0);
        result = 31 * result + (university != null ? university.hashCode() : 0);
        result = 31 * result + (studentId != null ? studentId.hashCode() : 0);
        result = 31 * result + (parentUserId != null ? parentUserId.hashCode() : 0);
        result = 31 * result + (parentFirstName != null ? parentFirstName.hashCode() : 0);
        result = 31 * result + (parentLastName != null ? parentLastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (applyTime != null ? applyTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (newUserApply != null ? newUserApply.hashCode() : 0);
        return result;
    }
}
