package Payment;

public class Upi implements paymentModeStrategy {
    @Override
    public void pay() {
        System.out.println("Pay upi");
    }
}
