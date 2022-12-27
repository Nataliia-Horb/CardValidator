package org.example;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Card {
    String cardData;
    static CardGenerator generator = CardGenerator.getInstance();


    public Card(String cardData) {
        this.cardData = cardData;
    }

    public Card() {
        this.cardData = generator.getRandomCard();
    }
}
