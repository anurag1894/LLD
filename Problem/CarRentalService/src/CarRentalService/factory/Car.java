package CarRentalService.factory;

import CarRentalService.enums.CarType;

public interface Car {
    public boolean isBooked();
    public int rent();
    public CarType getCarType();
    public int getCarId();
    public void setBooked();
    public void free();
    public void setCarId(int carId);
}
