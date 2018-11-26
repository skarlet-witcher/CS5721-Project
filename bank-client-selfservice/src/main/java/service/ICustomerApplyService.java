package service;

import model.*;

public interface ICustomerApplyService {
    /*
        @pre userApplyNewPersonalAccountBaseModel.getFirstName() != null
        @pre userApplyNewPersonalAccountBaseModel.getLastName() != null
        @pre userApplyNewPersonalAccountBaseModel.getGender() == 0 ||
        userApplyNewPersonalAccountBaseModel.getGender() == 1
        @pre userApplyNewPersonalAccountBaseModel.getIdentityIdType() == 1 ||
        userApplyNewPersonalAccountBaseModel.getIdentityIdType() == 2
        @pre userApplyNewPersonalAccountBaseModel.getIdentityId() != null
        @pre userApplyNewPersonalAccountBaseModel.getAccountType() == 1
        @pre userApplyNewPersonalAccountBaseModel.getCardType() == 1 ||
        userApplyNewPersonalAccountBaseModel.getCardType() == 2
        @pre userApplyNewPersonalAccountBaseModel.getAddress() != null
        @pre userApplyNewPersonalAccountBaseModel.getEmail() != null
        @pre userApplyNewPersonalAccountBaseModel.getBirthdate() != null
        @pre userApplyNewPersonalAccountBaseModel.getContactNum() != null
        @pre userApplyNewPersonalAccountBaseModel.getNewUserApply() == 1
     */
    void applyPersonalAccountForNewUser(UserApplyNewPersonalAccountBaseModel userApplyNewPersonalAccountBaseModel) throws Exception;
    /*
        @pre userApplyNewStudentAccountBaseModel.getFirstName() != null
        @pre userApplyNewStudentAccountBaseModel.getLastName() != null
        @pre userApplyNewStudentAccountBaseModel.getGender() == 0 ||
        userApplyNewStudentAccountBaseModel.getGender() == 1
        @pre userApplyNewStudentAccountBaseModel.getIdentityIdType() == 1 ||
        userApplyNewStudentAccountBaseModel.getIdentityIdType() == 2
        @pre userApplyNewStudentAccountBaseModel.getIdentityId() != null
        @pre userApplyNewStudentAccountBaseModel.getAccountType() == 1
        @pre userApplyNewStudentAccountBaseModel.getCardType() == 1 ||
        userApplyNewStudentAccountBaseModel.getCardType() == 2
        @pre userApplyNewStudentAccountBaseModel.getAddress() != null
        @pre userApplyNewStudentAccountBaseModel.getEmail() != null
        @pre userApplyNewStudentAccountBaseModel.getBirthdate() != null
        @pre userApplyNewStudentAccountBaseModel.getContactNum() != null
        @pre userApplyNewStudentAccountBaseModel.getNewUserApply() == 1
        @pre userApplyNewStudentAccountBaseModel.getGraduateDate() != null
        @pre userApplyNewStudentAccountBaseModel.getStudentId() != null
        @pre userApplyNewStudentAccountBaseModel.getSchoolName() != null
     */
    void applyStudentAccountForNewUser(UserApplyNewStudentAccountBaseModel userApplyNewStudentAccountBaseModel) throws Exception;
    /*
        @pre userApplyNewYoungSaverAccountBaseModel.getFirstName() != null
        @pre userApplyNewYoungSaverAccountBaseModel.getLastName() != null
        @pre userApplyNewYoungSaverAccountBaseModel.getGender() == 0 ||
        userApplyNewYoungSaverAccountBaseModel.getGender() == 1
        @pre userApplyNewYoungSaverAccountBaseModel.getIdentityIdType() == 1 ||
        userApplyNewYoungSaverAccountBaseModel.getIdentityIdType() == 2
        @pre userApplyNewYoungSaverAccountBaseModel.getIdentityId() != null
        @pre userApplyNewYoungSaverAccountBaseModel.getAccountType() == 1
        @pre userApplyNewYoungSaverAccountBaseModel.getCardType() == 1 ||
        userApplyNewYoungSaverAccountBaseModel.getCardType() == 2
        @pre userApplyNewYoungSaverAccountBaseModel.getAddress() != null
        @pre userApplyNewYoungSaverAccountBaseModel.getEmail() != null
        @pre userApplyNewYoungSaverAccountBaseModel.getBirthdate() != null
        @pre userApplyNewYoungSaverAccountBaseModel.getContactNum() != null
        @pre userApplyNewYoungSaverAccountBaseModel.getNewUserApply() == 1
        @pre userApplyNewYoungSaverAccountBaseModel.getParentUserId() != null
        @pre userApplyNewYoungSaverAccountBaseModel.getParentFirstName() != null
        @pre userApplyNewYoungSaverAccountBaseModel.getParentLastName() != null
     */
    void applyYoungSaverAccountForNewUser(UserApplyNewYoungSaverAccountBaseModel userApplyNewYoungSaverAccountBaseModel) throws Exception;
    /*
        @pre userApplyNewGoldenAccountBaseModel.getFirstName() != null
        @pre userApplyNewGoldenAccountBaseModel.getLastName() != null
        @pre userApplyNewGoldenAccountBaseModel.getGender() == 0 ||
        userApplyNewGoldenAccountBaseModel.getGender() == 1
        @pre userApplyNewGoldenAccountBaseModel.getIdentityIdType() == 1 ||
        userApplyNewGoldenAccountBaseModel.getIdentityIdType() == 2
        @pre userApplyNewGoldenAccountBaseModel.getIdentityId() != null
        @pre userApplyNewGoldenAccountBaseModel.getAccountType() == 1
        @pre userApplyNewGoldenAccountBaseModel.getCardType() == 1 ||
        userApplyNewGoldenAccountBaseModel.getCardType() == 2
        @pre userApplyNewGoldenAccountBaseModel.getAddress() != null
        @pre userApplyNewGoldenAccountBaseModel.getEmail() != null
        @pre userApplyNewGoldenAccountBaseModel.getBirthdate() != null
        @pre userApplyNewGoldenAccountBaseModel.getContactNum() != null
        @pre userApplyNewGoldenAccountBaseModel.getNewUserApply() == 1
     */
    void applyGoldenAccountForNewUser(UserApplyNewGoldenAccountBaseModel userApplyNewGoldenAccountBaseModel) throws Exception;
    /*
        @pre userApplyNewPersonalAccountBaseModel.getUserId() != null
        @pre userApplyNewPersonalAccountBaseModel.getAccountType == 1
        @pre userApplyNewPersonalAccountBaseModel.getCardType == 1 ||
        userApplyNewPersonalAccountBaseModel.getCardType == 2
        @pre userApplyNewPersonalAccountBaseModel.getNewUserApply() == 0
     */
    void applyPersonalAccountForExistingUser(UserApplyNewPersonalAccountBaseModel userApplyNewPersonalAccountBaseModel) throws Exception;
    /*
        @pre userApplyNewStudentAccountBaseModel.getUserId() != null
        @pre userApplyNewStudentAccountBaseModel.getAccountType == 1
        @pre userApplyNewStudentAccountBaseModel.getCardType() == 1 ||
        userApplyNewStudentAccountBaseModel.getCardType() == 2
        @pre userApplyNewStudentAccountBaseModel.getNewUserApply() == 0
        @pre userApplyNewStudentAccountBaseModel.getGraduateDate() != null
        @pre userApplyNewStudentAccountBaseModel.getStudentId() != null
        @pre userApplyNewStudentAccountBaseModel.getSchoolName() != null
     */
    void applyStudentAccountForExistingUser(UserApplyNewStudentAccountBaseModel userApplyNewStudentAccountBaseModel) throws Exception;
    /*
        @pre userApplyNewYoungSaverAccountBaseModel.getUserId() != null
        @pre userApplyNewYoungSaverAccountBaseModel.getAccountType == 1
        @pre userApplyNewYoungSaverAccountBaseModel.getCardType == 1 ||
        userApplyNewYoungSaverAccountBaseModel.getCardType == 2
        @pre userApplyNewYoungSaverAccountBaseModel.getNewUserApply() == 0
        @pre userApplyNewYoungSaverAccountBaseModel.getParentUserId() != null
        @pre userApplyNewYoungSaverAccountBaseModel.getParentFirstName() != null
        @pre userApplyNewYoungSaverAccountBaseModel.getParentLastName() != null
     */
    void applyYoungSaverAccountForExistingUser(UserApplyNewYoungSaverAccountBaseModel userApplyNewYoungSaverAccountBaseModel) throws Exception;
    /*
        @pre userApplyNewGoldenAccountBaseModel.getUserId() != null
        @pre userApplyNewGoldenAccountBaseModel.getAccountType == 1
        @pre userApplyNewGoldenAccountBaseModel.getCardType == 1 ||
        userApplyNewGoldenAccountBaseModel.getCardType == 2
        @pre userApplyNewGoldenAccountBaseModel.getNewUserApply() == 0
     */
    void applyGoldenAccountForExistingUser(UserApplyNewGoldenAccountBaseModel userApplyNewGoldenAccountBaseModel) throws Exception;
    /*
        @pre userModel.getUserId() != null
        @pre userModel.getFirstName() != null
        @pre userModel.getLastName() != null
     */
    void checkExistingUserBeforeApply(UserModel userModel) throws Exception;
}
