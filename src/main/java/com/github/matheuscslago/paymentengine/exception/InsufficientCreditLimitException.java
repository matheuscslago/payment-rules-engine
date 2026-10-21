package com.github.matheuscslago.paymentengine.exception;

public class InvalidCreditLimitException extends RuntimeException {
    public InvalidCreditLimitException(){
        super("Insufficient Credit Limit!");
    }
    public InvalidCreditLimitException(String message) {
        super(message);
    }
}
