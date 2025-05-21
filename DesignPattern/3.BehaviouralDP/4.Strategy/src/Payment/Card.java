package Payment;

public class Card implements paymentModeStrategy {
    @Override
    public void pay() {
            System.out.println("Pay Card");
    }
}
