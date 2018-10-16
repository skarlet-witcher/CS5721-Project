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
        List<Integer> li = new ArrayList<Integer>();
        for(int i = 0; i< 10; i++) {
            li.add(i);
        }
        Collections.shuffle(li);
        return li;
    }
}