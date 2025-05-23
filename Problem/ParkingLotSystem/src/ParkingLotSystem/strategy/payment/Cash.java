package ParkingLotSystem.strategy.payment;

public class Cash implements paymentStrategy{

    @Override
    public void makePayment(int amount) {
        System.out.println("Payment cash "+amount);
    }

    @Override
    public int getCharge() {
        return 0;
    }
}
