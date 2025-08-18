package AMS.strategy;

public class UpiPayment implements PaymentStrategy {

    @Override
    public int makePayment(int amount) {
        System.out.println("UpiPayment called with amount (no extra charge)" + amount);
        return amount;
    }
}
