package com.github.matheuscslago.paymentengine.interfaces;

public interface PaymentProcessor {
    boolean processPayment(double amount);
}
