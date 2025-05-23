package ParkingLotSystem.vehicle;

import ParkingLotSystem.strategy.charges.ChargesStrategy;

public interface vehicle {
    public int getId();
    public void setId(int id);
    public int getParkingCharge();
    public int getParkingLot();
    public void setParkingLot(int parkingLot);
    public void setChargesStrategy(ChargesStrategy chargesStrategy);
    public ChargesStrategy getChargesStrategy();
}
