package CarRentalService.factory;

import CarRentalService.enums.CarType;

public class Suv implements Car{
    int carID;
    boolean isBooked;

    @Override
    public boolean isBooked() {
        return isBooked;
    }

    @Override
    public int rent() {
        return 1000;
    }

    @Override
    public CarType getCarType() {
        return CarType.SUV;
    }

    @Override
    public int getCarId() {
        return carID;
    }
    @Override
    public void setBooked(){
        isBooked = true;
    }

    @Override
    public void free(){
        isBooked = false;
    }

    @Override
    public void setCarId(int carId){
        this.carID = carId;
    }
}
