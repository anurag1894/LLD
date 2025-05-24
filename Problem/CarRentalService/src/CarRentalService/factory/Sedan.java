package CarRentalService.factory;

import CarRentalService.enums.CarType;

public class Sedan implements Car{
    int carId;
    boolean isBooked;


    @Override
    public boolean isBooked() {
        return isBooked;
    }

    @Override
    public int rent() {
        return 700;
    }

    @Override
    public CarType getCarType() {
        return CarType.SEDAN;
    }

    @Override
    public int getCarId(){
        return carId;
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
        this.carId = carId;
    }

}
