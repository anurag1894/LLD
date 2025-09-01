package Splitwise.Payment;

import Splitwise.User.User;

public interface PaymentStrategy {

    void pay(double amount, User paidBy, User paidTo);
}
