package VehicleBrandFactory;

public class Honda implements car{
    @Override
    public void assemble() {
        System.out.println("Honda car is assembling");
    }
}
