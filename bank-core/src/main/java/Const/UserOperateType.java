package Const;

public class UserOperateType {
    public static final int CHARGE = 0;
    public static final int DEPOSIT = 1;
    public static final int WITHDRAW = 2;
    public static final int TRANSFER = 3;
    public static final int CHANGE_PROFILE = 4;
    public static final int LOGIN_REQ = 5;
    public static final int LOGIN = 6;
    public static final int CREATE_ACCOUNT = 7;
    public static final int REMOVE_ACCOUNT = 8;

    public static String getType(int typeNum) {
        switch(typeNum) {
            case 0:
                return "CHARGE";
            case 1:
                return "DEPOSIT";
            case 2:
                return "WITHDRAW";
            case 3:
                return "TRANSFER";
            case 4:
                return "CHANGE_PROFILE";
            case 5:
                return "LOGIN_REQ";
            case 6:
                return "LOGIN";
            case 7:
                return "CREATE_ACCOUNT";
            case 8:
                return "REMOVE_ACCOUNT";

                default: return "NOT FOUND";
        }
    }
}
