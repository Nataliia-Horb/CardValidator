package org.example;

public class Main {
    public static void main(String[] args) {

/**
 * Class card
 * Class CardGenerator -> return random String
 * Class Parser
 * Class Checker
 * Class NoValidCardException.class (Runtime)
 * Class FraudCardException.class (Runtime)
 */
        //Отдельный метод, который выдергивает из цифр месяц и год.
        //Отдельный метод, который сравнивает месяц и год из набора цифр с текущей датой и
        //если срок действия истек, выбрасывает NoValidCardException.class ( Runtime )

        Card card = new Card();
        System.out.println(card);
        System.out.println(Parser.getCardDataAfterParsing(card));
    }

}