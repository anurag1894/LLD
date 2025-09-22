package PL.entities;

import PL.enums.VehicleType;

public class Spot {
    private VehicleType vehicleType;
    private boolean isOccupied;
    private Vehicle parkVehicle;

    public Spot(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
        this.isOccupied = false;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.parkVehicle = vehicle;
        this.isOccupied = true;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void unparkVehicle() {
        this.isOccupied = false;
        this.parkVehicle = null;
    }

    public int getSize(){
        return this.vehicleType.ordinal();
    }
    public boolean canFit(Vehicle vehicle) {
        if(isOccupied)
            return false;
        switch (vehicle.getType()) {
            case SMALL:
                return vehicleType == VehicleType.SMALL;
            case MEDIUM:
                return this.vehicleType == VehicleType.MEDIUM || this.vehicleType == VehicleType.LARGE;
           case LARGE:
               return this.vehicleType == VehicleType.LARGE;
           default:
               return false;
        }
    }
    public synchronized boolean isAvailable() {
        return !isOccupied;
    }
}
