package Splitwise.Payment;

import Splitwise.User.User;

public class Cash implements PaymentStrategy{
    @Override
    public void pay(double amount, User paidBy, User paidTo){
        System.out.println("Cash payment for "+paidBy.getName()+" with "+amount +" "+paidTo.getName());
    }
}
