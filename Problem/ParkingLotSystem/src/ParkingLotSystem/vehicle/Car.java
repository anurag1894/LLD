package ParkingLotSystem.vehicle;

import ParkingLotSystem.strategy.charges.ChargesStrategy;

public class Car implements vehicle{

    int vehicleID;
    int parkingLotID;
    ChargesStrategy chargesStrategy;
    @Override
    public int getId() {
        return vehicleID;
    }

    @Override
    public void setId(int id) {
        vehicleID = id;
    }

    @Override
    public int getParkingCharge() {
        return 100;
    }

    @Override
    public int getParkingLot() {
        return parkingLotID;
    }

    @Override
    public void setParkingLot(int parkingLot) {
        parkingLotID = parkingLot;
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
