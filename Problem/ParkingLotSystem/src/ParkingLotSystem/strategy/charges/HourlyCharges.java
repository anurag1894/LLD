package ParkingLotSystem.strategy.charges;

public class HourlyCharges implements ChargesStrategy{

    @Override
    public int getCharges() {
        return 20;
    }
}
