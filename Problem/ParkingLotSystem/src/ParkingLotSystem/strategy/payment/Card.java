package ParkingLotSystem.strategy.payment;

public class Card implements paymentStrategy{

    @Override
    public void makePayment(int amount) {
        System.out.println("Payment Card "+amount);
    }

    @Override
    public int getCharge() {
        return 2;
    }
}
