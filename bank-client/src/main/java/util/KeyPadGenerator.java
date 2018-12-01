package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KeyPadGenerator {
    private static KeyPadGenerator keyPadGenerator = null;

    private KeyPadGenerator() {

    }

    public static KeyPadGenerator getInstance() {
        if(keyPadGenerator == null) {
            keyPadGenerator = new KeyPadGenerator();
        }
        return keyPadGenerator;
    }

    public List<Integer> getKeyPadArr() {
        List<Integer> digits = new ArrayList<Integer>();
        for(int digit = 0; digit< 10; digit++) {
            digits.add(digit);
        }
        Collections.shuffle(digits);
        return digits;
    }
}
