package AMS.strategy;

public class DebitCardPayment implements PaymentStrategy {

    @Override
    public int makePayment(int amount) {
        int totalAmount = amount + 20;
        System.out.println("Debit card payment for "+ totalAmount);
        return totalAmount;
    }
}
