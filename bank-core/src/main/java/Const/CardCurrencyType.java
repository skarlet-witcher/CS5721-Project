package Const;

public class CardCurrencyType {
    public static final int EURO = 0;
    public static final int DOLLAR = 1;

    public static String getCurrencyType(int typeNum) {
        switch (typeNum) {
            case 0:
                return "EURO";
            case 1:
                return "DOLLAR";

                default: return "EURO";
        }
    }
}
