package com.github.matheuscslago.paymentengine.domain;

import com.github.matheuscslago.paymentengine.exception.InsufficientDebitLimitException;
import com.github.matheuscslago.paymentengine.exception.InvalidPixKeyException;
import com.github.matheuscslago.paymentengine.interfaces.PaymentProcessor;

public class PixPayment implements PaymentProcessor {
    private final String pixKey;
    private double debitLimit;

    public PixPayment(String pixKey, double debitLimit) {
        if (!pixKey.trim().isEmpty()) {
            this.pixKey = pixKey;
        } else {
            throw new InvalidPixKeyException();
        }

        if (debitLimit >= 0) {
            this.debitLimit = debitLimit;
        } else {
            throw new IllegalArgumentException("[Error] Debit Limit must be positive!");
        }
    }

    @Override
    public boolean processPayment(double amount) throws RuntimeException {
        if(amount > debitLimit){
            throw new InsufficientDebitLimitException("[Error] Insufficient Debit Limit! Attempt Value: " + amount + " | Debit Limit: " + debitLimit);
        }else{
            deductDebitLimit(amount);
            System.out.println("Payment of R$" + amount + " instantly made!");
            return true;
        }
    }

    public String getPixKey() {
        return pixKey;
    }

    public double getDebitLimit() {
        return debitLimit;
    }

    public void deductDebitLimit(double value){
        this.debitLimit -= value;
    }

    public void depositDebitLimit(double value){
        this.debitLimit += value;
    }
}
