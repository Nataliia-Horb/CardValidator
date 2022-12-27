package org.example;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class CheckerTest {

    @Test
    void getCardAfterVerification() {

        String validCard = "36540977890792080624972";
        assertTrue(Pattern.matches("(^\\d{16})(0[1-9]|1[0-2])([2-3][0-9])(\\d{3}$)", validCard));
        assertEquals(validCard, Checker.getCardAfterVerification(validCard));
        String validCardCurrentMonth = "36540977890792081222972";
        assertEquals(validCardCurrentMonth, Checker.getCardAfterVerification(validCardCurrentMonth));
        assertEquals(validCard, Checker.getCardAfterVerification(validCard));
        assertThrows(NoValidCardException.class, () -> Checker.getCardAfterVerification("18723153249405170120393"));
        assertThrows(FraudCardException.class, () -> Checker.getCardAfterVerification("8723"));
        assertThrows(FraudCardException.class, () -> Checker.getCardAfterVerification("18723153249405170145393"));
        assertThrows(FraudCardException.class, () -> Checker.getCardAfterVerification(null));
        assertThrows(FraudCardException.class, () -> Checker.getCardAfterVerification("87231532494051701gdj93"));
    }
}