package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Checker {
    private static boolean isValidInputData(String card) {
        return (Pattern.matches("(^\\d{16})(0[1-9]|1[0-2])([2-3][0-9])(\\d{3}$)", card));
    }

    private static String checkCardLimitDate(String card) {
        StringBuilder dateBr = new StringBuilder().append("01").append(card.
                substring(Constants.QUANTITY_OF_CHARACTERS_FOR_CARD_NUMBER,
                        Constants.QUANTITY_OF_CHARACTERS_FOR_CARD_NUMBER + Constants.QUANTITY_OF_CHARACTERS_FOR_DATE));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyy");
        DateTimeFormatter dtfMaxValue = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        LocalDate cardLimitDate = LocalDate.parse(dateBr, dtf).plusMonths(1).minusDays(1);
        LocalDate maxLimitDate = LocalDate.parse(Constants.MAX_NO_FACE_DATE, dtfMaxValue);
        LocalDate now = LocalDate.now();

        if (cardLimitDate.isAfter(maxLimitDate)) {
            throw new FraudCardException();
        }
        if (cardLimitDate.isBefore(now)) {
            throw new NoValidCardException();
        }
        return card;
    }

    public static String getCardAfterVerification(String card) {

        if (card != null && isValidInputData(card)) {
            return checkCardLimitDate(card);
        } else {
            throw new FraudCardException();
        }
    }
}
