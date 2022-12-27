package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class ParserTest {


    MockedStatic<Checker> checker = Mockito.mockStatic(Checker.class);

    @Test
    void getCardDataAfterParsing() {

        String s = "18723153249405170120393";
        when(Checker.getCardAfterVerification(anyString())).thenReturn(s);
        assertEquals("1872 3153 2494 0517 01/20 (393)", Parser.getCardDataAfterParsing(new Card(s)));
        String s1 = "19483835128074461228294";
        when(Checker.getCardAfterVerification(anyString())).thenReturn(s1);
        assertEquals("1948 3835 1280 7446 12/28 (294)", Parser.getCardDataAfterParsing(new Card(s1)));
        when(Checker.getCardAfterVerification("8723")).thenReturn("8723");
        assertEquals("8723", Parser.getCardDataAfterParsing(new Card("8723")));
    }
}