package util;

import java.util.Random;

public class RandomUtil {

    public static int RandomNum(int min, int max) {
        return new Random().nextInt(max) % (max - min + 1) + min;
    }

}
