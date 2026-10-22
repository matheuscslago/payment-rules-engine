package com.github.matheuscslago.paymentengine.domain;

import com.github.matheuscslago.paymentengine.exception.InsufficientCreditLimitException;
import com.github.matheuscslago.paymentengine.interfaces.PaymentProcessor;

public class CreditCardPayment implements PaymentProcessor {
    private final String cardNumber;
    private double creditLimit;
    private static final double ADMINISTRATIVE_FEE = 0.02;

    public CreditCardPayment(String cardNumber, double creditLimit) {
        if (cardNumber == null || cardNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("[Error] This card needs to have a number!");
        }

        if (creditLimit < 0) {
            throw new InsufficientCreditLimitException("[Error] Initial credit limit cannot be negative!");
        }

        this.cardNumber = cardNumber;
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean processPayment(double amount){
        double total = amount + (amount * ADMINISTRATIVE_FEE);
        if(total > creditLimit){
            throw new InsufficientCreditLimitException("[Error] Insufficient Credit Limit! Attempt Value (with fee): R$" + total + " | Credit Limit: R$" + creditLimit);
        }else{
            deductCreditLimit(total);
            System.out.println("[Credit] Payment of R$" + total + " approved! Remaining Limit: R$" + this.creditLimit);
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
