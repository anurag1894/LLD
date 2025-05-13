package VehicleFactory;

public class car implements Vehicle{

    @Override
    public void start() {
        System.out.println("car is starting");
    }

    @Override
    public void stop() {
        System.out.println("car is stopping");
    }
}
