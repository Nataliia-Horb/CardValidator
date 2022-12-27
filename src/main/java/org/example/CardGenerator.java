package org.example;

import java.util.Random;
import java.util.stream.IntStream;

public class CardGenerator {

    Random random = new Random();
    static CardGenerator cg = null;

    private static final int MONTHS_IN_YEAR = 12;
    private static final int MIN_YEAR_FOR_GENERATOR = 20;
    private static final int MAX_YEAR_FOR_GENERATOR = 32;


    private CardGenerator() {
    }

    public static CardGenerator getInstance() {
        return cg == null ? new CardGenerator() : cg;
    }

    private String createRandomCard() {
        StringBuilder sb = new StringBuilder();
        IntStream.generate(() -> random.nextInt(10)).limit(Constants.QUANTITY_OF_CHARACTERS_FOR_CARD_NUMBER).
                forEach(sb::append);

        int month = 1 + random.nextInt(MONTHS_IN_YEAR);

        if (month < 10) {
            sb.append("0").append(month);
        } else {
            sb.append(month);
        }
        sb.append(MIN_YEAR_FOR_GENERATOR + random.nextInt(MAX_YEAR_FOR_GENERATOR - MIN_YEAR_FOR_GENERATOR));

        IntStream.generate(() -> random.nextInt(10)).limit(Constants.QUANTITY_OF_CHARACTERS_FOR_CVV).
                forEach(sb::append);
        return sb.toString();
    }

    public String getRandomCard() {
        return createRandomCard();
    }


}
