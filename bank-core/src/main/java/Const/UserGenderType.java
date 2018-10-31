package Const;

public class UserGenderType {
    public static final int WOMAN = 0;
    public static final int MAN = 1;

    public static String getGenderType(int typeNum) {
        switch (typeNum) {
            case 0: return "FEMALE";
            case 1: return "MALE";
            default: return "UNKNOWN";
        }
    }
}
