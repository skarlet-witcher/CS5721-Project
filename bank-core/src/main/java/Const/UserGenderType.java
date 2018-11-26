package Const;

public class UserGenderType {
    public static final int FEMALE = 0;
    public static final int MALE = 1;

    public static String getGenderType(int typeNum) {
        switch (typeNum) {
            case 0: return "FEMALE";
            case 1: return "MALE";
            default: return "UNKNOWN";
        }
    }
}
