package ParkingLotSystem.vehicle;

import ParkingLotSystem.strategy.charges.ChargesStrategy;

public class BUS implements vehicle {
    int vehicleID;
    int parkingLotID;
    ChargesStrategy chargesStrategy;

    @Override
    public int getId() {
        return vehicleID;
    }

    @Override
    public void setId(int id) {
        this.vehicleID = id;
    }

    @Override
    public int getParkingCharge() {
        return 50;
    }

    @Override
    public int getParkingLot() {
        return parkingLotID;
    }

    @Override
    public void setParkingLot(int parkingLot) {
        this.parkingLotID = parkingLot;
    }

    @Override
    public void setChargesStrategy(ChargesStrategy chargesStrategy) {
        this.chargesStrategy = chargesStrategy;
    }

    @Override
    public ChargesStrategy getChargesStrategy() {
        return chargesStrategy;
    }
}
