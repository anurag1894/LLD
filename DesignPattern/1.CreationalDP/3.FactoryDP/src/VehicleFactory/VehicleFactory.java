package VehicleFactory;

public class VehicleFactory {
    public static Vehicle getVehicle(String vehicleType){
        if(vehicleType.equals("car"))
            return new car();
        else if (vehicleType.equals("Bus"))
            return  new Bus();
        else if (vehicleType.equals("Bike"))
            return new Bike();
        else
            throw new IllegalArgumentException("Unknown vehicle type");
    }
}
