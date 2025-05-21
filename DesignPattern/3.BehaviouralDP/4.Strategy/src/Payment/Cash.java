package Payment;

public class Cash implements paymentModeStrategy {
    @Override
    public void pay() {
        System.out.println("Pay Cash");
    }
}
