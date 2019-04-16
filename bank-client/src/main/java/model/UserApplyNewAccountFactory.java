package model;

/*
    intent: Define an interface for creating an object, but let subclasses decide which class
            to instantiate. Factory Method lets a class defer instantiation to subclasses.
 */

public class UserApplyNewAccountFactory {
    public static UserApplyNewRequestBaseModel applyAccount(String type) {
        if(type == "Personal Current Account") {
            return new UserApplyNewPersonalAccountBaseModel();
        } else if(type == "Student Current Account") {
            return new UserApplyNewStudentAccountBaseModel();
        } else if(type == "Young Saver Account") {
            return new UserApplyNewYoungSaverAccountBaseModel();
        } else if(type == "Golden Account") {
            return new UserApplyNewGoldenAccountBaseModel();
        } else {
            return null;
        }
    }
}
