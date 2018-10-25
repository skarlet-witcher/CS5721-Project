package service;

import java.sql.Timestamp;

public interface IUserCustomerApplyService {
    void requestPersonalAccountApply(String firstName, String lastName, String identityNum, int identityType, int accountType, int cardType,
                                     Timestamp birthDate, int gender, String address, String email, String phone, int isNewUser, long userId) throws Exception;

    void requestStudentAccountApply(String firstName, String lastName, String identityNum, int identityType, int accountType, int cardType,
                                     Timestamp birthDate, int gender, String address, String email, String phone, int isNewUser,
                                    Timestamp graduateDate, String studentId, String university, long userId) throws Exception;

    void requestYoungSaverAccountApply(String firstName, String lastName, String identityNum, int identityType, int accountType, int cardType,
                                       Timestamp birthDate, int gender, String address, String email, String phone, int isNewUser,
                                       long parentUserId, String parentFirstName, String parentLastName, long userId) throws Exception;
    void requestGoldenAccountApply(String firstName, String lastName, String identityNum, int identityType, int accountType, int cardType,
                                   Timestamp birthDate, int gender, String address, String email, String phone, int isNewUser, long userId) throws Exception;
    void checkExistingUserBeforeApply(long userId, String firstName, String lastName) throws Exception;

    void checkDuplicateApply(long userId, int accountType, int cardType) throws Exception;
}
