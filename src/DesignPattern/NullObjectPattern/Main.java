package NullObjectPattern;

public class Main {
    public static void main(String args[]) {
        Vehicle vehicle = VehicleFactory.getVehicle("CAR");
        printVehicleDetails(vehicle);

        System.out.println("This is if the null object provided");
        Vehicle vehicleNext = VehicleFactory.getVehicle("BIKE");
        printVehicleDetails(vehicleNext);
    }

    private static void  printVehicleDetails(Vehicle vehicle){
      // if(vehicle!=null)  // Not required as we have defined Nullable class to handle null ptr exception using Null Object design.
        System.out.println("The Max speed is : " + vehicle.getMaxSpeed());
        System.out.println("The Max Tank is : " + vehicle.getMaxTank());
    }
}
