package util;

import java.util.Random;

public class PINGenerator {
    private static PINGenerator pinGenerator = null;

    private PINGenerator() {

    }
    public static PINGenerator getInstance() {
        if(pinGenerator == null) {
            pinGenerator = new PINGenerator();
        }
        return pinGenerator;
    }

    public int generatePIN() {
        return new Random().nextInt(999999);
    }
}
