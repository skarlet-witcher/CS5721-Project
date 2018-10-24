package service;

import java.sql.Timestamp;

public interface IUserCustomerApplyService {
    void requestPersonalAccountApply(String firstName, String lastName, String identityNum, int identityType, int accountType, int cardType,
                                     Timestamp birthDate, int gender, String address, String email, String phone) throws Exception;

    void requestStudentAccountApply(String firstName, String lastName, String identityNum, int identityType, int accountType, int cardType,
                                     Timestamp birthDate, int gender, String address, String email, String phone,
                                    Timestamp graduateDate, String studentId, String university) throws Exception;

    void requestYoungSaverAccountApply(String firstName, String lastName, String identityNum, int identityType, int accountType, int cardType,
                                       Timestamp birthDate, int gender, String address, String email, String phone,
                                       long parentUserId, String parentFirstName, String parentLastName) throws Exception;
}
