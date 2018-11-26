package Const;

public class UserAccountType {
    public static final int PERSONAL_ACCOUNT = 1;
    public static final int STUDENT_ACCOUNT = 2;
    public static final int YOUNG_SAVER_ACCOUNT = 3;
    public static final int GOLDEN_ACCOUNT = 4;

    public static String getTypeName(int typeNum) {
        switch (typeNum) {
            case 1:
                return "Current Account";
            case 2:
                return "Student Account";
            case 3:
                return "Young Saver Account";
            case 4:
                return "Golden Account";
            default:
                return "Other Account";
        }
    }
}
