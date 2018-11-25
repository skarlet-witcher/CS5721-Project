package service.impl;

import Const.CardType;
import Const.UserGenderType;
import bankStaff_rpc.AcceptedRequest;
import entity.UserAccountEntity;
import entity.UserApplyArchiveEntity;
import entity.UserCardEntity;
import entity.UserEntity;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static Const.UserAccountType.PERSONAL_ACCOUNT;
import static org.junit.jupiter.api.Assertions.*;

class StaffServiceTest {

    @Test
    void login() {
        assertDoesNotThrow(() -> {
            long id = 1000000000;
            String password = "123123";
            StaffService.getInstance().login(id,password);
        });
        assertThrows(Exception.class, ()-> {
            long id = 1000000000;
            String password = "1231abc3424g23";
            StaffService.getInstance().login(id,password);
        });
    }

    @Test
    void getUserApplyArchiveEntities() {
        assertDoesNotThrow(() -> {
            StaffService.getInstance().getUserApplyArchiveEntities();
        });
    }

    @Test
    void acceptApplication() {
        assertDoesNotThrow(() -> {
            long id = StaffService.getInstance().getUserApplyArchiveEntities().getListUserApplyArchiveEntitiesResponseList().get(0).getId();
            AcceptedRequest acceptedRequest = AcceptedRequest.newBuilder().setApplicationId(id).build();
            StaffService.getInstance().acceptApplication(acceptedRequest);
        });
    }


    @Test
    void createUserCard() {

        assertDoesNotThrow(() -> {
            UserAccountEntity userAccountEntity = new UserAccountEntity();
            userAccountEntity.setId((long)35);
            userAccountEntity.setExpiredDate(Timestamp.valueOf("2030-01-01 01:00:00"));
            UserApplyArchiveEntity userApplyArchiveEntity = new UserApplyArchiveEntity();
            userApplyArchiveEntity.setCardType(1);
            StaffService.getInstance().createUserCard(userAccountEntity,userApplyArchiveEntity);
        });

    }

    @Test
    void createUserAccount() {
        assertDoesNotThrow(() -> {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserId((long)1);

            UserApplyArchiveEntity userApplyArchiveEntity = new UserApplyArchiveEntity();
            userApplyArchiveEntity.setBirthDate(Timestamp.valueOf("1966-01-01 01:00:00"));
            userApplyArchiveEntity.setGraduateDate(Timestamp.valueOf("2022-01-01 01:00:00"));
            userApplyArchiveEntity.setApplyTime(Timestamp.valueOf("2018-11-22 12:17:55"));
            userApplyArchiveEntity.setAccountType(PERSONAL_ACCOUNT);
            StaffService.getInstance().createUserAccount(userEntity, userApplyArchiveEntity);
        });

    }

    @Test
    void applyForExistingUser() {
        assertDoesNotThrow(() -> {
            long appId = StaffService.getInstance().getUserApplyArchiveEntities().getListUserApplyArchiveEntitiesResponseList().get(0).getId();
            AcceptedRequest request = AcceptedRequest.newBuilder().setApplicationId(appId).build();
            UserApplyArchiveEntity userApplyArchiveEntity = new UserApplyArchiveEntity();
            userApplyArchiveEntity.setUserId((long)1000000000);
            userApplyArchiveEntity.setAddress("University of Limerick");
            userApplyArchiveEntity.setBirthDate(Timestamp.valueOf("1966-01-01 01:00:00"));
            userApplyArchiveEntity.setEmail("18038514@ul.ie");
            userApplyArchiveEntity.setFirstName("This is firstname");
            userApplyArchiveEntity.setLastName("This is lastname");
            userApplyArchiveEntity.setCardType(CardType.DEBIT_CARD);
            userApplyArchiveEntity.setGender(UserGenderType.MALE);
            userApplyArchiveEntity.setPhone("0875213584");
            userApplyArchiveEntity.setGraduateDate(Timestamp.valueOf("2022-01-01 01:00:00"));
            userApplyArchiveEntity.setApplyTime(Timestamp.valueOf("2018-11-22 12:17:55"));
            userApplyArchiveEntity.setAccountType(PERSONAL_ACCOUNT);
            StaffService.getInstance().applyForExistingUser(request,userApplyArchiveEntity);

        });

    }

    @Test
    void applyForNewUser() {
        assertDoesNotThrow(() -> {
            long appId = StaffService.getInstance().getUserApplyArchiveEntities().getListUserApplyArchiveEntitiesResponseList().get(0).getId();
            AcceptedRequest request = AcceptedRequest.newBuilder().setApplicationId(appId).build();
            UserApplyArchiveEntity userApplyArchiveEntity = new UserApplyArchiveEntity();
            userApplyArchiveEntity.setAddress("University of Limerick");
            userApplyArchiveEntity.setBirthDate(Timestamp.valueOf("1966-01-01 01:00:00"));
            userApplyArchiveEntity.setEmail("18038514@ul.ie");
            userApplyArchiveEntity.setFirstName("Firstname");
            userApplyArchiveEntity.setLastName("Lastname");
            userApplyArchiveEntity.setCardType(CardType.DEBIT_CARD);
            userApplyArchiveEntity.setGender(UserGenderType.MALE);
            userApplyArchiveEntity.setPhone("0875213584");
            userApplyArchiveEntity.setGraduateDate(Timestamp.valueOf("2022-01-01 01:00:00"));
            userApplyArchiveEntity.setApplyTime(Timestamp.valueOf("2018-11-22 12:17:55"));
            userApplyArchiveEntity.setAccountType(PERSONAL_ACCOUNT);
            StaffService.getInstance().applyForNewUser(request,userApplyArchiveEntity);
        });

    }
}