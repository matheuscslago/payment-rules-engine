package com.github.matheuscslago.paymentengine.exception;

public class InsufficientDebitLimitException extends RuntimeException {
    public InsufficientDebitLimitException(String message) {
        super(message);
    }
}
