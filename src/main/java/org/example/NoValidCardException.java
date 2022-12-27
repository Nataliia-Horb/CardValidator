package org.example;

public class NoValidCardException extends RuntimeException {

    @Override
    public String toString() {
        return "The Card is not valid";
    }
}
