package NullObjectPattern;

public class VehicleNullClass implements Vehicle {
    @Override
    public int getMaxSpeed(){
        return  0;
    }

    public int getMaxTank(){
        return  0;
    }
}
