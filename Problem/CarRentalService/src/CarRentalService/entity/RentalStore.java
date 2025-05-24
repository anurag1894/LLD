package CarRentalService.entity;

import CarRentalService.factory.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RentalStore {
    private int id;
    private String name;
    private Map<Integer, Car> cars;

    public RentalStore(int id, String name) {
        this.id = id;
        this.name = name;
        this.cars = new HashMap<>();
    }

    public List<Car> getAvailableVehicles() {
        List<Car> availableVehicles = new ArrayList<>();
        for (Car vehicle : cars.values()) {
            if (!vehicle.isBooked()) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }

    public void addVehicle(Car vehicle) {
        cars.put(vehicle.getCarId(), vehicle);
    }

    public void removeVehicle(Integer registrationNumber) {
        cars.remove(registrationNumber);
    }



    public Car getVehicle(Integer carId) {
        return cars.get(carId);
    }

}
