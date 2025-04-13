package NullObjectPattern;

public class Car implements Vehicle{
    @Override
    public int getMaxSpeed(){
        return 40;
    }

    @Override
    public int getMaxTank(){
        return 50;
    }
}