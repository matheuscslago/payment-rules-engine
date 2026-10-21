package com.github.matheuscslago.paymentengine.domain;

import com.github.matheuscslago.paymentengine.exception.InsufficientCreditLimitException;
import com.github.matheuscslago.paymentengine.interfaces.PaymentProcessor;

public class CreditCardPayment implements PaymentProcessor {
    private final String cardNumber;
    private double creditLimit;
    private static final double ADMINISTRATIVE_FEE = 0.02;

    public CreditCardPayment(String cardNumber, double creditLimit) {
        if (!cardNumber.trim().isEmpty()) {
            this.cardNumber = cardNumber;
        } else {
            throw new IllegalArgumentException("[Error] This card needs to have a number!");
        }

        if (creditLimit > 0) {
            this.creditLimit = creditLimit;
        } else {
            throw new InsufficientCreditLimitException("[Error] Initial credit limit cannot be negative!");
        }
    }

    @Override
    public boolean processPayment(double amount) throws RuntimeException {
        double total = amount + (amount * ADMINISTRATIVE_FEE);
        if(total > creditLimit){
            throw new InsufficientCreditLimitException("[Error] Insufficient Credit Limit! Attempt Value: " + total + " | Credit Limit: " + creditLimit);
        }else{
            deductCreditLimit(total);
            System.out.println("Payment of R$" + total + " made!");
            return true;
        }
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void deductCreditLimit(double value){
        this.creditLimit -= value;
    }

    public void depositCreditLimit(double value){
        this.creditLimit += value;
    }
}
