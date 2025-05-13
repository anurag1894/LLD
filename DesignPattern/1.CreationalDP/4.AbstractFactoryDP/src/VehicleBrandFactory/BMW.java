package VehicleBrandFactory;

public class BMW implements car{

    @Override
    public void assemble() {
        System.out.println("BMW car is assembling");
    }
}
