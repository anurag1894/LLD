package CarRentalService.factory;

import CarRentalService.enums.CarType;

public class CarFactory {
    public static Car createVehicle(CarType type) {
        switch (type) {
            case SEDAN:
                return new Sedan();
            case SUV:
                return new Suv();
            default:
                throw new IllegalArgumentException("Invalid Vehicle Type: " + type);
        }
    }
}
