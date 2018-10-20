package util;

import java.util.*;

public class RandomUtil {

    public static int generateOneNum(int min, int max) {
        return new Random().nextInt(max) % (max - min + 1) + min;
    }

    public static List<Integer> generateNumbsNoDuplicatedASC(Integer min, Integer max, Integer numbersNeeded) {
        Set<Integer> generated = new LinkedHashSet<Integer>();
        while (generated.size() < numbersNeeded) {
            Integer next = generateOneNum(min, max);
            // As we're adding to a set, this will automatically do a containment check
            generated.add(next);
        }

        List<Integer> sortedList = new ArrayList<Integer>(generated);
        Collections.sort(sortedList);
        return sortedList;
    }

}
