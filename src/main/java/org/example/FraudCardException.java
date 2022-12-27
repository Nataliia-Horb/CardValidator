package org.example;

public class FraudCardException extends RuntimeException {
    @Override
    public String toString() {
        return "The Card is fake";
    }
}
