package util;

import java.util.ArrayList;
import java.util.List;

public class PINFieldSetter {
    private static PINFieldSetter pinFieldSetter = null;

    private PINFieldSetter() {

    }

    public static PINFieldSetter getInstance() {
        if(pinFieldSetter == null) {
            pinFieldSetter = new PINFieldSetter();
        }
        return pinFieldSetter;
    }

    public List<Integer> setPINField() {
        List<Integer> pinField = new ArrayList<Integer>();
        for(int i = 0; i < 6; i++) {
            pinField.add(RandomUtil.generateOneNum(0, 3));
        }
        return pinField;
    }



}
