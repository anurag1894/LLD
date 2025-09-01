package Splitwise.Payment;

import Splitwise.User.User;

public class UPI implements PaymentStrategy{

    @Override
    public void pay(double amount, User paidBy, User paidTo) {
        System.out.println("UPI payment method called");
        System.out.print("amount: " + amount);
        System.out.print(" paidBy: " + paidBy);
        System.out.println(" paidTo: " + paidTo);
    }
}
