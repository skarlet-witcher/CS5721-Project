package Const;

public class UserStatusType {
    public static final int BLOCKED = 0;
    public static final int NORMAL = 1;
    public static final int PENDING_FOR_BEING_DELETED = 2;
    public static final int DELETED = 3;

    public static String getStatusType(int typeNum) {
        switch (typeNum) {
            case 0:
                return "BLOCKED";
            case 1:
                return "NORMAL";
            case 2:
                return "PENDING_FOR_BEING_DELETED";
            case 3:
                return "DELETED";
            default: return "NORMAL";
        }
    }

}
