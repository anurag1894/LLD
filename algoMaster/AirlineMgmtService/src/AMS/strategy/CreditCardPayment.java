package AMS.strategy;

public class CreditCardPayment implements PaymentStrategy {

    @Override
    public int makePayment(int amount) {
        int totalAmount = amount + 40;
        System.out.println("Credit Card Payment is about to make payment: " + totalAmount);
        return totalAmount;
    }
}
