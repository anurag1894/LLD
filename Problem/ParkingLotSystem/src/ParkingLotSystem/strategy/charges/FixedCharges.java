package ParkingLotSystem.strategy.charges;

public class FixedCharges implements ChargesStrategy{

    @Override
    public int getCharges() {
        return 50;
    }
}
