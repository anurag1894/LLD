package PLMulti.PL.entities;

import PLMulti.PL.enums.VehicleType;

import java.util.concurrent.atomic.AtomicBoolean;

public class Spot {
    private final VehicleType vehicleType;
    private final AtomicBoolean isOccupied;
    private volatile Vehicle parkVehicle;

    public Spot(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
        this.isOccupied = new AtomicBoolean(false);
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        if (isOccupied.compareAndSet(false, true)) {
            this.parkVehicle = vehicle;
            return true;
        }
        return false; // Spot was already occupied
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public synchronized void unparkVehicle() {
        this.isOccupied.set(false);
        this.parkVehicle = null;
    }

    public int getSize(){
        return this.vehicleType.ordinal();
    }
    
    public boolean canFit(Vehicle vehicle) {
        if(isOccupied.get())
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
        return !isOccupied.get();
    }
}
