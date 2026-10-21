package com.github.matheuscslago.paymentengine.exception;

public class InsufficientCreditLimitException extends RuntimeException {
    public InsufficientCreditLimitException(){
        super("Insufficient Credit Limit!");
    }
    public InsufficientCreditLimitException(String message) {
        super(message);
    }
}
