package org.example;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class CardGeneratorTest {

    @Test
    void getRandomCard() {
        CardGenerator generator = CardGenerator.getInstance();
        assertEquals(23, generator.getRandomCard().length());
        for (int i = 0; i < 15; i++) {
            assertTrue(Pattern.matches("(^\\d{16})(0[1-9]|1[0-2])([2-3][0-9])(\\d{3}$)",
                    generator.getRandomCard()));
        }
    }
}