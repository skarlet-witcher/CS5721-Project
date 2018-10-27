package service.impl;

import model.*;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class CustomerApplyServiceTest {

    @Test
    void applyPersonalAccountForNewUser() throws Exception {
        UserApplyNewPersonalAccountBaseModel userApplyNewPersonalAccountBaseModel = new UserApplyNewPersonalAccountBaseModel();

        userApplyNewPersonalAccountBaseModel.setFirstName("xiangkai");
        userApplyNewPersonalAccountBaseModel.setLastName("tang");
        userApplyNewPersonalAccountBaseModel.setGender(1);
        userApplyNewPersonalAccountBaseModel.setIdentityType(1);
        userApplyNewPersonalAccountBaseModel.setIdentityNum("12312343");
        userApplyNewPersonalAccountBaseModel.setAccountType(1);
        userApplyNewPersonalAccountBaseModel.setCardType(1);
        userApplyNewPersonalAccountBaseModel.setAddress("troy village");
        userApplyNewPersonalAccountBaseModel.setEmail("empathytxk@hotmail.com");
        userApplyNewPersonalAccountBaseModel.setBirthDate(Timestamp.valueOf("1970-01-01 01:00:00"));
        userApplyNewPersonalAccountBaseModel.setContactNum("083444332");
        userApplyNewPersonalAccountBaseModel.setNewUserApply(1);

        CustomerApplyService.getInstance().applyPersonalAccountForNewUser(userApplyNewPersonalAccountBaseModel);

    }

    @Test
    void applyStudentAccountForNewUser() throws Exception {
        UserApplyNewStudentAccountBaseModel userApplyNewStudentAccountBaseModel = new UserApplyNewStudentAccountBaseModel();
        userApplyNewStudentAccountBaseModel.setFirstName("xiangkai22");
        userApplyNewStudentAccountBaseModel.setLastName("tang");
        userApplyNewStudentAccountBaseModel.setIdentityNum("323231");
        userApplyNewStudentAccountBaseModel.setIdentityType(1);
        userApplyNewStudentAccountBaseModel.setAccountType(2);
        userApplyNewStudentAccountBaseModel.setCardType(1);
        userApplyNewStudentAccountBaseModel.setBirthDate(Timestamp.valueOf("1970-01-01 01:00:00"));
        userApplyNewStudentAccountBaseModel.setGender(1);
        userApplyNewStudentAccountBaseModel.setAddress("troy village");
        userApplyNewStudentAccountBaseModel.setEmail("empathytx@gmail.com");
        userApplyNewStudentAccountBaseModel.setContactNum("083999232");
        userApplyNewStudentAccountBaseModel.setNewUserApply(1);
        userApplyNewStudentAccountBaseModel.setGraduateDate(Timestamp.valueOf("2020-01-01 01:00:00"));
        userApplyNewStudentAccountBaseModel.setStudentId("17080118");
        userApplyNewStudentAccountBaseModel.setSchoolName("ul");

        CustomerApplyService.getInstance().applyStudentAccountForNewUser(userApplyNewStudentAccountBaseModel);

    }

    @Test
    void applyYoungSaverAccountForNewUser() throws Exception {
        UserApplyNewYoungSaverAccountBaseModel userApplyNewYoungSaverAccountBaseModel = new UserApplyNewYoungSaverAccountBaseModel();
        userApplyNewYoungSaverAccountBaseModel.setFirstName("haha");
        userApplyNewYoungSaverAccountBaseModel.setLastName("lailai");
        userApplyNewYoungSaverAccountBaseModel.setIdentityNum("12312313");
        userApplyNewYoungSaverAccountBaseModel.setIdentityType(1);
        userApplyNewYoungSaverAccountBaseModel.setAccountType(3);
        userApplyNewYoungSaverAccountBaseModel.setCardType(1);
        userApplyNewYoungSaverAccountBaseModel.setBirthDate(Timestamp.valueOf("1999-01-01 01:00:00"));
        userApplyNewYoungSaverAccountBaseModel.setGender(2);
        userApplyNewYoungSaverAccountBaseModel.setAddress("village");
        userApplyNewYoungSaverAccountBaseModel.setEmail("dsaff@qq.com");
        userApplyNewYoungSaverAccountBaseModel.setContactNum("038223334");
        userApplyNewYoungSaverAccountBaseModel.setNewUserApply(1);
        userApplyNewYoungSaverAccountBaseModel.setParentUserId(Long.parseLong("1000000000"));
        userApplyNewYoungSaverAccountBaseModel.setParentFirstName("xiangkai");
        userApplyNewYoungSaverAccountBaseModel.setParentLastName("tang");

        CustomerApplyService.getInstance().applyYoungSaverAccountForNewUser(userApplyNewYoungSaverAccountBaseModel);
    }

    @Test
    void applyGoldenAccountForNewUser() throws Exception {
        UserApplyNewGoldenAccountBaseModel userApplyNewGoldenAccountBaseModel = new UserApplyNewGoldenAccountBaseModel();
        userApplyNewGoldenAccountBaseModel.setFirstName("kaikai");
        userApplyNewGoldenAccountBaseModel.setLastName("tangtang");
        userApplyNewGoldenAccountBaseModel.setIdentityNum("131231231");
        userApplyNewGoldenAccountBaseModel.setIdentityType(1);
        userApplyNewGoldenAccountBaseModel.setAccountType(4);
        userApplyNewGoldenAccountBaseModel.setCardType(1);
        userApplyNewGoldenAccountBaseModel.setBirthDate(Timestamp.valueOf("1970-01-01 01:00:00"));
        userApplyNewGoldenAccountBaseModel.setGender(1);
        userApplyNewGoldenAccountBaseModel.setAddress("village");
        userApplyNewGoldenAccountBaseModel.setEmail("emaafwa@hotmail.com");
        userApplyNewGoldenAccountBaseModel.setContactNum("31231232");
        userApplyNewGoldenAccountBaseModel.setNewUserApply(1);

        CustomerApplyService.getInstance().applyGoldenAccountForNewUser(userApplyNewGoldenAccountBaseModel);
    }

    @Test
    void checkExistingUserBeforeApply() throws Exception {
        UserModel userModel = new UserModel();
        userModel.setUserId(Long.parseLong("1000000000"));
        userModel.setFirstName("xiangkai");
        userModel.setLastName("tang");

        CustomerApplyService.getInstance().checkExistingUserBeforeApply(userModel);
    }

    @Test
    void applyPersonalAccountForExistingUser() throws Exception {
        UserApplyNewPersonalAccountBaseModel userApplyNewPersonalAccountBaseModel = new UserApplyNewPersonalAccountBaseModel();
        userApplyNewPersonalAccountBaseModel.setUserId(Long.parseLong("1000000000"));
        userApplyNewPersonalAccountBaseModel.setAccountType(1);
        userApplyNewPersonalAccountBaseModel.setCardType(1);
        userApplyNewPersonalAccountBaseModel.setNewUserApply(0);

        CustomerApplyService.getInstance().applyPersonalAccountForExistingUser(userApplyNewPersonalAccountBaseModel);
    }

    @Test
    void applyStudentAccountForExistingUser() throws Exception {
        UserApplyNewStudentAccountBaseModel userApplyNewStudentAccountBaseModel = new UserApplyNewStudentAccountBaseModel();
        userApplyNewStudentAccountBaseModel.setUserId(Long.parseLong("1000000001"));
        userApplyNewStudentAccountBaseModel.setAccountType(2);
        userApplyNewStudentAccountBaseModel.setCardType(1);
        userApplyNewStudentAccountBaseModel.setNewUserApply(0);
        userApplyNewStudentAccountBaseModel.setGraduateDate(Timestamp.valueOf("2020-01-01 01:00:00"));
        userApplyNewStudentAccountBaseModel.setStudentId("17080118");
        userApplyNewStudentAccountBaseModel.setSchoolName("ul");

        CustomerApplyService.getInstance().applyStudentAccountForNewUser(userApplyNewStudentAccountBaseModel);
    }

    @Test
    void applyYoungSaverAccountForExistingUser() throws Exception {
        UserApplyNewYoungSaverAccountBaseModel userApplyNewYoungSaverAccountBaseModel = new UserApplyNewYoungSaverAccountBaseModel();
        userApplyNewYoungSaverAccountBaseModel.setUserId(Long.parseLong("1000000000"));
        userApplyNewYoungSaverAccountBaseModel.setAccountType(3);
        userApplyNewYoungSaverAccountBaseModel.setCardType(1);
        userApplyNewYoungSaverAccountBaseModel.setNewUserApply(0);
        userApplyNewYoungSaverAccountBaseModel.setParentUserId(Long.parseLong("1000000001"));
        userApplyNewYoungSaverAccountBaseModel.setParentFirstName("hao");
        userApplyNewYoungSaverAccountBaseModel.setParentLastName("lu");

        CustomerApplyService.getInstance().applyYoungSaverAccountForExistingUser(userApplyNewYoungSaverAccountBaseModel);
    }

    @Test
    void applyGoldenAccountForExistingUser() throws Exception {
        UserApplyNewGoldenAccountBaseModel userApplyNewGoldenAccountBaseModel = new UserApplyNewGoldenAccountBaseModel();
        userApplyNewGoldenAccountBaseModel.setUserId(Long.parseLong("1000000000"));
        userApplyNewGoldenAccountBaseModel.setAccountType(4);
        userApplyNewGoldenAccountBaseModel.setCardType(1);
        userApplyNewGoldenAccountBaseModel.setNewUserApply(0);

        CustomerApplyService.getInstance().applyGoldenAccountForExistingUser(userApplyNewGoldenAccountBaseModel);
    }
}