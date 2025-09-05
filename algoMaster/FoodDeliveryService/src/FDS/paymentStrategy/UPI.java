package FDS.paymentStrategy;

public class UPI implements paymentStrategy {

    @Override
    public int pay() {
        System.out.println("UPI pay");
        return 0;
    }
}
