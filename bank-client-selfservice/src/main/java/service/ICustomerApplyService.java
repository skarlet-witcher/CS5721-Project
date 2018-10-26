package service;

import model.*;

public interface ICustomerApplyService {
    void applyPersonalAccountForNewUser(UserApplyNewPersonalAccountBaseModel userApplyNewPersonalAccountBaseModel) throws Exception;

    void applyStudentAccountForNewUser(UserApplyNewStudentAccountBaseModel userApplyNewStudentAccountBaseModel) throws Exception;

    void applyYoungSaverAccountForNewUser(UserApplyNewYoungSaverAccountBaseModel userApplyNewYoungSaverAccountBaseModel) throws Exception;

    void applyGoldenAccountForNewUser(UserApplyNewGoldenAccountBaseModel userApplyNewGoldenAccountBaseModel) throws Exception;

    void applyPersonalAccountForExistingUser(UserApplyNewPersonalAccountBaseModel userApplyNewPersonalAccountBaseModel) throws Exception;

    void applyStudentAccountForExistingUser(UserApplyNewStudentAccountBaseModel userApplyNewStudentAccountBaseModel) throws Exception;

    void applyYoungSaverAccountForExistingUser(UserApplyNewYoungSaverAccountBaseModel userApplyNewYoungSaverAccountBaseModel) throws Exception;

    void applyGoldenAccountForExistingUser(UserApplyNewGoldenAccountBaseModel userApplyNewGoldenAccountBaseModel) throws Exception;

    void checkExistingUserBeforeApply(UserModel userModel) throws Exception;
}
