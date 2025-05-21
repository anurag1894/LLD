package Payment;

public class Main {
    public static void main(String[] args) {
        paymentModeStrategy cashMode =  new Cash();
        paymentModeStrategy cardMode =  new Card();
        paymentModeStrategy upiMode =  new Upi();
        PaymentProcessor paymentProcessor = new PaymentProcessor(cardMode);
        paymentProcessor.processPayment();
        paymentProcessor.setPaymentModeStrategy(cashMode);
        paymentProcessor.processPayment();
        paymentProcessor.setPaymentModeStrategy(upiMode);
        paymentProcessor.processPayment();

    }
}
