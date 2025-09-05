package FDS.paymentStrategy;

public class Card implements paymentStrategy {

    @Override
    public int pay() {
        System.out.println("Paying Card");
        return 10;
    }
}
