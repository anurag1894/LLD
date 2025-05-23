package ParkingLotSystem.strategy.payment;

public interface paymentStrategy {
    public void makePayment(int amount);
    public int getCharge();
}
