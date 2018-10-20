package util;


import java.util.Random;

public class CardNumberGenerator {
    private static CardNumberGenerator cardNumberGenerator = null;

    private CardNumberGenerator() {

    }

    public static CardNumberGenerator getInstance() {
        if(cardNumberGenerator == null) {
            cardNumberGenerator = new CardNumberGenerator();
        }
        return cardNumberGenerator;
    }

    public long getCardNumber() {
        Random rand = new Random();
        long accumulator = 1 + rand.nextInt(9); // ensures that the 16th digit isn't 0
        for(int i = 0; i < 15; i++) {
            accumulator *= 10L;
            accumulator += rand.nextInt(10);
        }
        return accumulator;
    }
}
