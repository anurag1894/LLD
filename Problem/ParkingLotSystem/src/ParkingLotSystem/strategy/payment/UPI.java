package ParkingLotSystem.strategy.payment;

public class UPI implements paymentStrategy {
    @Override
    public void makePayment(int amount) {
        System.out.println("UPI Payment "+ amount);
    }

    @Override
    public int getCharge() {
        return 0;
    }
}
