package com.github.matheuscslago.paymentengine.exception;

public class InvalidPixKeyException extends RuntimeException {

    public InvalidPixKeyException() {
        super("Invalid Pix Key!");
    }

    public InvalidPixKeyException(String message) {
        super(message);
    }
}
