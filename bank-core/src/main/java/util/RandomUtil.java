package util;

import java.util.Random;

public class RandomUtil {
    private static RandomUtil randomUtil = null;

    private RandomUtil() {

    }

    public static RandomUtil getInstance() {
        if(randomUtil == null) {
            randomUtil = new RandomUtil();
        }
        return randomUtil;
    }
    public int RandomNum(int min, int max) {
        return new Random().nextInt(max)%(max-min+1) + min;
    }
}
