package service.impl;

import Const.*;
import model.*;
import org.hibernate.annotations.common.reflection.java.generics.IdentityTypeEnvironment;
import org.junit.jupiter.api.Test;
import service.ICustomerApplyService;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class CustomerApplyServiceTest {
    ICustomerApplyService customerApplyService = CustomerApplyService.getInstance();

    @Test
    void applyPersonalAccountForNewUser() throws Exception {
        UserApplyNewPersonalAccountBaseModel userApplyNewPersonalAccountBaseModel = new UserApplyNewPersonalAccountBaseModel();

        userApplyNewPersonalAccountBaseModel.setFirstName("xiangkai");
        userApplyNewPersonalAccountBaseModel.setLastName("tang");
        userApplyNewPersonalAccountBaseModel.setGender(UserGenderType.MAN);
        userApplyNewPersonalAccountBaseModel.setIdentityType(UserIdentityType.PASSPORT);
        userApplyNewPersonalAccountBaseModel.setIdentityNum("12312343");
        userApplyNewPersonalAccountBaseModel.setAccountType(UserAccountType.PERSONAL_ACCOUNT);
        userApplyNewPersonalAccountBaseModel.setCardType(CardType.DEBIT_CARD);
        userApplyNewPersonalAccountBaseModel.setAddress("troy village");
        userApplyNewPersonalAccountBaseModel.setEmail("empathytxk@hotmail.com");
        userApplyNewPersonalAccountBaseModel.setBirthDate(Timestamp.valueOf("1970-01-01 01:00:00"));
        userApplyNewPersonalAccountBaseModel.setContactNum("083444332");
        userApplyNewPersonalAccountBaseModel.setNewUserApply(UserType.NEW_USER);

        assertDoesNotThrow(() -> {
            customerApplyService.applyPersonalAccountForNewUser(userApplyNewPersonalAccountBaseModel);
        });
    }

    @Test
    void applyStudentAccountForNewUser() throws Exception {
        UserApplyNewStudentAccountBaseModel userApplyNewStudentAccountBaseModel = new UserApplyNewStudentAccountBaseModel();
        userApplyNewStudentAccountBaseModel.setFirstName("xiangkai22");
        userApplyNewStudentAccountBaseModel.setLastName("tang");
        userApplyNewStudentAccountBaseModel.setIdentityNum("323231");
        userApplyNewStudentAccountBaseModel.setIdentityType(UserIdentityType.PASSPORT);
        userApplyNewStudentAccountBaseModel.setAccountType(UserAccountType.STUDENT_ACCOUNT);
        userApplyNewStudentAccountBaseModel.setCardType(CardType.DEBIT_CARD);
        userApplyNewStudentAccountBaseModel.setBirthDate(Timestamp.valueOf("1970-01-01 01:00:00"));
        userApplyNewStudentAccountBaseModel.setGender(UserGenderType.MAN);
        userApplyNewStudentAccountBaseModel.setAddress("troy village");
        userApplyNewStudentAccountBaseModel.setEmail("empathytx@gmail.com");
        userApplyNewStudentAccountBaseModel.setContactNum("083999232");
        userApplyNewStudentAccountBaseModel.setNewUserApply(UserType.NEW_USER);
        userApplyNewStudentAccountBaseModel.setGraduateDate(Timestamp.valueOf("2020-01-01 01:00:00"));
        userApplyNewStudentAccountBaseModel.setStudentId("17080118");
        userApplyNewStudentAccountBaseModel.setSchoolName("ul");

        assertDoesNotThrow(() -> {
            customerApplyService.applyStudentAccountForNewUser(userApplyNewStudentAccountBaseModel);
        });

    }

    @Test
    void applyYoungSaverAccountForNewUser() throws Exception {
        UserApplyNewYoungSaverAccountBaseModel userApplyNewYoungSaverAccountBaseModel = new UserApplyNewYoungSaverAccountBaseModel();
        userApplyNewYoungSaverAccountBaseModel.setFirstName("haha");
        userApplyNewYoungSaverAccountBaseModel.setLastName("lailai");
        userApplyNewYoungSaverAccountBaseModel.setIdentityNum("12312313");
        userApplyNewYoungSaverAccountBaseModel.setIdentityType(UserIdentityType.PASSPORT);
        userApplyNewYoungSaverAccountBaseModel.setAccountType(UserAccountType.YOUNG_SAVER_ACCOUNT);
        userApplyNewYoungSaverAccountBaseModel.setCardType(CardType.DEBIT_CARD);
        userApplyNewYoungSaverAccountBaseModel.setBirthDate(Timestamp.valueOf("1999-01-01 01:00:00"));
        userApplyNewYoungSaverAccountBaseModel.setGender(UserGenderType.WOMAN);
        userApplyNewYoungSaverAccountBaseModel.setAddress("village");
        userApplyNewYoungSaverAccountBaseModel.setEmail("dsaff@qq.com");
        userApplyNewYoungSaverAccountBaseModel.setContactNum("038223334");
        userApplyNewYoungSaverAccountBaseModel.setNewUserApply(UserType.NEW_USER);
        userApplyNewYoungSaverAccountBaseModel.setParentUserId(Long.parseLong("1000000000"));
        userApplyNewYoungSaverAccountBaseModel.setParentFirstName("xiangkai");
        userApplyNewYoungSaverAccountBaseModel.setParentLastName("tang");

        assertDoesNotThrow(() -> {
            customerApplyService.applyYoungSaverAccountForNewUser(userApplyNewYoungSaverAccountBaseModel);
        });
    }

    @Test
    void applyGoldenAccountForNewUser() throws Exception {
        UserApplyNewGoldenAccountBaseModel userApplyNewGoldenAccountBaseModel = new UserApplyNewGoldenAccountBaseModel();
        userApplyNewGoldenAccountBaseModel.setFirstName("kaikai");
        userApplyNewGoldenAccountBaseModel.setLastName("tangtang");
        userApplyNewGoldenAccountBaseModel.setIdentityNum("131231231");
        userApplyNewGoldenAccountBaseModel.setIdentityType(UserIdentityType.PASSPORT);
        userApplyNewGoldenAccountBaseModel.setAccountType(UserAccountType.GOLDEN_ACCOUNT);
        userApplyNewGoldenAccountBaseModel.setCardType(CardType.DEBIT_CARD);
        userApplyNewGoldenAccountBaseModel.setBirthDate(Timestamp.valueOf("1970-01-01 01:00:00"));
        userApplyNewGoldenAccountBaseModel.setGender(UserGenderType.MAN);
        userApplyNewGoldenAccountBaseModel.setAddress("village");
        userApplyNewGoldenAccountBaseModel.setEmail("emaafwa@hotmail.com");
        userApplyNewGoldenAccountBaseModel.setContactNum("31231232");
        userApplyNewGoldenAccountBaseModel.setNewUserApply(UserType.NEW_USER);

        assertDoesNotThrow(() -> {
            CustomerApplyService.getInstance().applyGoldenAccountForNewUser(userApplyNewGoldenAccountBaseModel);
        });
    }

    @Test
    void checkExistingUserBeforeApply() throws Exception {
        UserModel userModel = new UserModel();
        userModel.setUserId(Long.parseLong("1000000000"));
        userModel.setFirstName("xiangkai");
        userModel.setLastName("tang");

        assertDoesNotThrow(() -> {
            customerApplyService.checkExistingUserBeforeApply(userModel);
        });
    }

    @Test
    void applyPersonalAccountForExistingUser() throws Exception {
        UserApplyNewPersonalAccountBaseModel userApplyNewPersonalAccountBaseModel = new UserApplyNewPersonalAccountBaseModel();
        userApplyNewPersonalAccountBaseModel.setUserId(Long.parseLong("1000000000"));
        userApplyNewPersonalAccountBaseModel.setAccountType(UserAccountType.PERSONAL_ACCOUNT);
        userApplyNewPersonalAccountBaseModel.setCardType(CardType.DEBIT_CARD);
        userApplyNewPersonalAccountBaseModel.setNewUserApply(UserType.EXISTING_USER);

        assertDoesNotThrow(() -> {
            customerApplyService.applyPersonalAccountForExistingUser(userApplyNewPersonalAccountBaseModel);
        });
    }

    @Test
    void applyStudentAccountForExistingUser() throws Exception {
        UserApplyNewStudentAccountBaseModel userApplyNewStudentAccountBaseModel = new UserApplyNewStudentAccountBaseModel();
        userApplyNewStudentAccountBaseModel.setUserId(Long.parseLong("1000000001"));
        userApplyNewStudentAccountBaseModel.setAccountType(UserAccountType.STUDENT_ACCOUNT);
        userApplyNewStudentAccountBaseModel.setCardType(CardType.DEBIT_CARD);
        userApplyNewStudentAccountBaseModel.setNewUserApply(UserType.EXISTING_USER);
        userApplyNewStudentAccountBaseModel.setGraduateDate(Timestamp.valueOf("2020-01-01 01:00:00"));
        userApplyNewStudentAccountBaseModel.setStudentId("17080118");
        userApplyNewStudentAccountBaseModel.setSchoolName("ul");

        assertDoesNotThrow(() -> {
            customerApplyService.applyStudentAccountForNewUser(userApplyNewStudentAccountBaseModel);
        });
    }

    @Test
    void applyYoungSaverAccountForExistingUser() throws Exception {
        UserApplyNewYoungSaverAccountBaseModel userApplyNewYoungSaverAccountBaseModel = new UserApplyNewYoungSaverAccountBaseModel();
        userApplyNewYoungSaverAccountBaseModel.setUserId(Long.parseLong("1000000000"));
        userApplyNewYoungSaverAccountBaseModel.setAccountType(UserAccountType.YOUNG_SAVER_ACCOUNT);
        userApplyNewYoungSaverAccountBaseModel.setCardType(CardType.DEBIT_CARD);
        userApplyNewYoungSaverAccountBaseModel.setNewUserApply(UserType.EXISTING_USER);
        userApplyNewYoungSaverAccountBaseModel.setParentUserId(Long.parseLong("1000000001"));
        userApplyNewYoungSaverAccountBaseModel.setParentFirstName("hao");
        userApplyNewYoungSaverAccountBaseModel.setParentLastName("lu");

        assertDoesNotThrow(() -> {
            customerApplyService.applyYoungSaverAccountForExistingUser(userApplyNewYoungSaverAccountBaseModel);
        });
    }

    @Test
    void applyGoldenAccountForExistingUser() throws Exception {
        UserApplyNewGoldenAccountBaseModel userApplyNewGoldenAccountBaseModel = new UserApplyNewGoldenAccountBaseModel();
        userApplyNewGoldenAccountBaseModel.setUserId(Long.parseLong("1000000000"));
        userApplyNewGoldenAccountBaseModel.setAccountType(UserAccountType.GOLDEN_ACCOUNT);
        userApplyNewGoldenAccountBaseModel.setCardType(CardType.DEBIT_CARD);
        userApplyNewGoldenAccountBaseModel.setNewUserApply(UserType.EXISTING_USER);

        assertDoesNotThrow(() -> {
            customerApplyService.applyGoldenAccountForExistingUser(userApplyNewGoldenAccountBaseModel);
        });
    }
}