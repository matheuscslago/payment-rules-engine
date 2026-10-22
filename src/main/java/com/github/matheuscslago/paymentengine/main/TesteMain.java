package com.github.matheuscslago.paymentengine.main;

import com.github.matheuscslago.paymentengine.domain.CreditCardPayment;
import com.github.matheuscslago.paymentengine.domain.PixPayment;
import com.github.matheuscslago.paymentengine.interfaces.PaymentProcessor;
import com.github.matheuscslago.paymentengine.service.ExecutePayment;

public class TesteMain {
    static void main(String[] args) {
        ExecutePayment engine = new ExecutePayment();

        System.out.println("=== Payment Engine Test ===");

        PaymentProcessor creditPayment = new CreditCardPayment("01923", 5000.0);
        engine.executePayment(creditPayment, 7000.0);

        System.out.println("============");

        PaymentProcessor pixPayment = new PixPayment("01312", 1000.0);
        engine.executePayment(pixPayment, 150.0);

    }
}
