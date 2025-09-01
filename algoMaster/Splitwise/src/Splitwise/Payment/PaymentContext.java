package Splitwise.Payment;

import Splitwise.User.User;

public class PaymentContext { // we don't need it
    PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount, User paidBy,User paidTo) {
        paymentStrategy.pay(amount,paidBy,paidTo);
    }
}
