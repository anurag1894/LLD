package PL.entities;

import PL.enums.VehicleType;

public class Vehicle {
    private int id;
    private VehicleType type;

    public Vehicle(int vehiclePlateNumber, VehicleType type) {
        this.id = vehiclePlateNumber;
        this.type = type;
    }
    public VehicleType getType() {
        return type;
    }

    public int getVehicleID(){
        return id;
    }
}
