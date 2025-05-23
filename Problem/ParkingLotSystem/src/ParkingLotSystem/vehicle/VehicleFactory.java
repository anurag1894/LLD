package ParkingLotSystem.vehicle;

import ParkingLotSystem.enums.VehicleType;

public class VehicleFactory {
    public static vehicle createVehicle(VehicleType type) {
        switch (type) {
            case CAR:
                return new Car();
            case BUS:
                return new BUS();
            default:
                throw new IllegalArgumentException("Invalid Vehicle Type: " + type);
        }
    }
}
