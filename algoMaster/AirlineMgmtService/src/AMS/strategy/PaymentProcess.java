package AMS.strategy;

public class PaymentProcess {
    private PaymentStrategy paymentStrategy;
    public PaymentProcess(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    public int processPayment(int amount) {
        return paymentStrategy.makePayment(amount);
    }
}
