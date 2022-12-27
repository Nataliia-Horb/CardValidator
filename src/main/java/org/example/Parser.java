package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static String parseStringInCard(Card card) {
        String cardAfterValidation = Checker.getCardAfterVerification(card.getCardData());

        Pattern pattern =
                Pattern.compile("(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{2})(\\d{2})(\\d{3})");
        Matcher matcher = pattern.matcher(cardAfterValidation);

        return matcher.replaceAll("$1 $2 $3 $4 $5/$6 ($7)");
    }

    public static String getCardDataAfterParsing(Card card) {
        return parseStringInCard(card);
    }
}

