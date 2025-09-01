package Splitwise.Payment;

import Splitwise.User.User;

public class Payment {
    private int id;
    private double amount;
    private User paidBy;
    private User paidTo;
    private PaymentStrategy paymentStrategy;

    public Payment(int id, double amount, User paidBy, User paidTo, PaymentStrategy paymentStrategy) {
        this.id = id;
        this.amount = amount;
        this.paidBy = paidBy;
        this.paidTo = paidTo;
        this.paymentStrategy = paymentStrategy;
    }

    // Execute the payment using the selected strategy
    public void executePayment() {
        paymentStrategy.pay(amount, paidBy, paidTo);
    }

    // Change payment method dynamically
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}