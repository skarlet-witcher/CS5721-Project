package service.impl;

import dao.IUserApplyDao;
import dao.IUserDao;
import dao.impl.UserApplyDao;
import dao.impl.UserDao;
import entity.UserApplyArchiveEntity;
import entity.UserEntity;
import service.IUserCustomerApplyService;
import util.FaultFactory;

import java.sql.Timestamp;
import java.util.Date;

public class UserCustomerApplyService implements IUserCustomerApplyService {
    private static UserCustomerApplyService userCustomerApplyService = null;
    private IUserApplyDao userApplyDao = UserApplyDao.getInstance();
    private IUserDao userDao = UserDao.getInstance();

    public static UserCustomerApplyService getInstance() {
        if (userCustomerApplyService == null) {
            return new UserCustomerApplyService();
        }
        return userCustomerApplyService;
    }

    @Override
    public void requestPersonalAccountApply(String firstName, String lastName, String identityNum, int identityType, int accountType, int cardType,
                                            Timestamp birthDate, int gender, String address, String email, String phone, int isNewUser, Long userId) throws Exception {
        try {
            // basic info
            UserApplyArchiveEntity UserApplyArchiveEntity = new UserApplyArchiveEntity();
            UserApplyArchiveEntity.setFirstName(firstName);
            UserApplyArchiveEntity.setLastName(lastName);
            UserApplyArchiveEntity.setIdentityId(identityNum);
            UserApplyArchiveEntity.setIdentityIdType(identityType);
            UserApplyArchiveEntity.setAccountType(accountType);
            UserApplyArchiveEntity.setCardType(cardType);
            UserApplyArchiveEntity.setBirthDate(birthDate);
            UserApplyArchiveEntity.setGender(gender);
            UserApplyArchiveEntity.setAddress(address);
            UserApplyArchiveEntity.setEmail(email);
            UserApplyArchiveEntity.setPhone(phone);
            UserApplyArchiveEntity.setApplyTime(new Timestamp(new Date().getTime()));
            UserApplyArchiveEntity.setStatus(0);
            UserApplyArchiveEntity.setNewUserApply(isNewUser);
            UserApplyArchiveEntity.setUserId(userId);
            userApplyDao.requestAccountApply(UserApplyArchiveEntity);
        } catch (Exception e) {
            throw FaultFactory.throwFaultException("Fail to apply a personal current account");
        }
    }

    @Override
    public void requestStudentAccountApply(String firstName, String lastName, String identityNum, int identityType, int accountType, int cardType, Timestamp birthDate, int gender,
                                           String address, String email, String phone, int isNewUser,
                                           Timestamp graduateDate, String studentId, String university, Long userId) throws Exception {
        try {
            UserApplyArchiveEntity UserApplyArchiveEntity = new UserApplyArchiveEntity();
            UserApplyArchiveEntity.setFirstName(firstName);
            UserApplyArchiveEntity.setLastName(lastName);
            UserApplyArchiveEntity.setIdentityId(identityNum);
            UserApplyArchiveEntity.setIdentityIdType(identityType);
            UserApplyArchiveEntity.setAccountType(accountType);
            UserApplyArchiveEntity.setCardType(cardType);
            UserApplyArchiveEntity.setBirthDate(birthDate);
            UserApplyArchiveEntity.setGender(gender);
            UserApplyArchiveEntity.setAddress(address);
            UserApplyArchiveEntity.setEmail(email);
            UserApplyArchiveEntity.setPhone(phone);
            UserApplyArchiveEntity.setApplyTime(new Timestamp(new Date().getTime()));
            UserApplyArchiveEntity.setNewUserApply(isNewUser);
            UserApplyArchiveEntity.setUserId(userId);
            UserApplyArchiveEntity.setStatus(0);
            // student info
            UserApplyArchiveEntity.setGraduateDate(graduateDate);
            UserApplyArchiveEntity.setStudentId(studentId);
            UserApplyArchiveEntity.setUniversity(university);

            userApplyDao.requestAccountApply(UserApplyArchiveEntity);

        } catch (Exception e) {
            throw FaultFactory.throwFaultException("Fail to apply a student current account");
        }
    }

    @Override
    public void requestYoungSaverAccountApply(String firstName, String lastName, String identityNum, int identityType, int accountType, int cardType, Timestamp birthDate, int gender, String address, String email, String phone, int isNewUser, Long parentUserId, String parentFirstName, String parentLastName, long userId) throws Exception {

        UserApplyArchiveEntity UserApplyArchiveEntity = new UserApplyArchiveEntity();
        UserEntity result = null;
        UserEntity UserEntity = new UserEntity();
        UserApplyArchiveEntity.setFirstName(firstName);
        UserApplyArchiveEntity.setLastName(lastName);
        UserApplyArchiveEntity.setIdentityId(identityNum);
        UserApplyArchiveEntity.setIdentityIdType(identityType);
        UserApplyArchiveEntity.setAccountType(accountType);
        UserApplyArchiveEntity.setCardType(cardType);
        UserApplyArchiveEntity.setBirthDate(birthDate);
        UserApplyArchiveEntity.setGender(gender);
        UserApplyArchiveEntity.setAddress(address);
        UserApplyArchiveEntity.setEmail(email);
        UserApplyArchiveEntity.setPhone(phone);
        UserApplyArchiveEntity.setApplyTime(new Timestamp(new Date().getTime()));
        UserApplyArchiveEntity.setNewUserApply(isNewUser);
        UserApplyArchiveEntity.setUserId(userId);
        UserApplyArchiveEntity.setStatus(0);
        // young saver info
        UserApplyArchiveEntity.setParentUserId(parentUserId);
        UserApplyArchiveEntity.setParentFirstName(parentFirstName);
        UserApplyArchiveEntity.setParentLastName(parentLastName);

        // check parent info
        UserEntity.setUserId(parentUserId);
        UserEntity.setFirstName(parentFirstName);
        UserEntity.setLastName(parentLastName);
        try {
            result = userDao.selectUserByIdAndName(parentUserId, parentFirstName, parentLastName);
        } catch (Exception e) {
            throw FaultFactory.throwFaultException("Fail to apply a young saver account");
        }
        if (result == null) {
            throw FaultFactory.throwFaultException("parent info does not exist!");
        }
        userApplyDao.requestAccountApply(UserApplyArchiveEntity);
    }

    @Override
    public void requestGoldenAccountApply(String firstName, String lastName, String identityNum, int identityType, int accountType, int cardType,
                                          Timestamp birthDate, int gender, String address, String email, String phone, int isNewUser, Long userId) throws Exception {
        try {
            // basic info
            UserApplyArchiveEntity UserApplyArchiveEntity = new UserApplyArchiveEntity();
            UserApplyArchiveEntity.setFirstName(firstName);
            UserApplyArchiveEntity.setLastName(lastName);
            UserApplyArchiveEntity.setIdentityId(identityNum);
            UserApplyArchiveEntity.setIdentityIdType(identityType);
            UserApplyArchiveEntity.setAccountType(accountType);
            UserApplyArchiveEntity.setCardType(cardType);
            UserApplyArchiveEntity.setBirthDate(birthDate);
            UserApplyArchiveEntity.setGender(gender);
            UserApplyArchiveEntity.setAddress(address);
            UserApplyArchiveEntity.setEmail(email);
            UserApplyArchiveEntity.setPhone(phone);
            UserApplyArchiveEntity.setApplyTime(new Timestamp(new Date().getTime()));
            UserApplyArchiveEntity.setNewUserApply(isNewUser);
            UserApplyArchiveEntity.setStatus(0);
            UserApplyArchiveEntity.setUserId(userId);
            userApplyDao.requestAccountApply(UserApplyArchiveEntity);
        } catch (Exception e) {
            throw FaultFactory.throwFaultException("Fail to apply a golden current account");
        }
    }

    @Override
    public void checkExistingUserBeforeApply(Long userId, String firstName, String lastName) throws Exception {
        UserEntity result = null;
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userId);
        userEntity.setFirstName(firstName);
        userEntity.setLastName(lastName);
        try {
            result = userDao.selectUserByIdAndName(userId, firstName, lastName);

        } catch (Exception E) {
            throw FaultFactory.throwFaultException("check existing model fail");
        }
        if (result == null) {
            throw FaultFactory.throwFaultException("no existing model found");
        }
    }

    @Override
    public void checkDuplicateApply(Long userId, int accountType, int cardType) throws Exception {
        UserApplyArchiveEntity result = null;
        UserApplyArchiveEntity UserApplyArchiveEntity = new UserApplyArchiveEntity();
        UserApplyArchiveEntity.setUserId(userId);
        UserApplyArchiveEntity.setAccountType(accountType);
        UserApplyArchiveEntity.setCardType(cardType);
        try {
            result = userApplyDao.selectApplyByUserId(UserApplyArchiveEntity);

        } catch (Exception E) {
            throw FaultFactory.throwFaultException("duplicate apply operation fail");
        }
        if (result != null) {
            throw FaultFactory.throwFaultException("duplicate apply detected");
        }
    }
}
