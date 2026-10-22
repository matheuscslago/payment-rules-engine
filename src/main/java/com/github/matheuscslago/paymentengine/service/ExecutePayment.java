package com.github.matheuscslago.paymentengine.service;

import com.github.matheuscslago.paymentengine.exception.InsufficientCreditLimitException;
import com.github.matheuscslago.paymentengine.exception.InsufficientDebitLimitException;
import com.github.matheuscslago.paymentengine.exception.InvalidPixKeyException;
import com.github.matheuscslago.paymentengine.interfaces.PaymentProcessor;

public class ExecutePayment {
    public void executePayment(PaymentProcessor payment, double value) {
        try {
            payment.processPayment(value);
            System.out.println("Status: [Approved] Payment Made!)");
        }catch (InsufficientDebitLimitException | InsufficientCreditLimitException e){
            System.out.println(e.getMessage());
            System.out.println("Status: [Refused] Insufficient Limit.");
        }catch (InvalidPixKeyException e){
            System.out.println(e.getMessage());
            System.out.println("Status: [Refused] Invalid Pix Key.");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println("Status: [Refused] Invalid Data.");
        }
    }
}
