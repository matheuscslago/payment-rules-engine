package com.github.matheuscslago.paymentengine.domain;

import com.github.matheuscslago.paymentengine.exception.InsufficientDebitLimitException;
import com.github.matheuscslago.paymentengine.exception.InvalidPixKeyException;
import com.github.matheuscslago.paymentengine.interfaces.PaymentProcessor;

public class PixPayment implements PaymentProcessor {
    private final String pixKey;
    private double debitLimit;

    public PixPayment(String pixKey, double debitLimit) {
        if (pixKey == null || pixKey.trim().isEmpty()) {
            throw new InvalidPixKeyException();
        }
        if (debitLimit < 0) {
            throw new IllegalArgumentException("[Error] Debit Limit must be positive!");
        }
        this.pixKey = pixKey;
        this.debitLimit = debitLimit;
    }

    @Override
    public boolean processPayment(double amount) {
        if (amount > debitLimit) {
            throw new InsufficientDebitLimitException("[Error] Insufficient Debit Limit! Attempt Value: R$" + amount + " | Debit Limit: R$" + debitLimit);
        } else {
            deductDebitLimit(amount);
            System.out.println("[Pix] Payment of R$" + amount + " instantly approved! Remaining Limit: R$" + this.debitLimit);
            return true;
        }
    }

    public String getPixKey() {
        return pixKey;
    }

    public double getDebitLimit() {
        return debitLimit;
    }

    public void deductDebitLimit(double value) {
        this.debitLimit -= value;
    }

    public void depositDebitLimit(double value) {
        this.debitLimit += value;
    }
}
