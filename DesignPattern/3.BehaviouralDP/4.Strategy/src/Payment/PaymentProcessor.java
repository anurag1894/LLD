package Payment;

public class PaymentProcessor {
    private paymentModeStrategy paymentModeStrategy;
    public PaymentProcessor(paymentModeStrategy paymentModeStrategy) {
        this.paymentModeStrategy = paymentModeStrategy;
    }
    public void processPayment() {
        paymentModeStrategy.pay();
    }
    public void setPaymentModeStrategy(paymentModeStrategy paymentModeStrategy) {
        this.paymentModeStrategy = paymentModeStrategy;
    }
}
