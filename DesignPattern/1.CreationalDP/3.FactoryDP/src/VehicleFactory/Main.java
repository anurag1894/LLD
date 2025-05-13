package VehicleFactory;

public class Main {
    public static void main(String[] args) {
        // This is a traditional way
        Vehicle car = new car();
        car.start();
        car.stop();

        Vehicle bus = new Bus();
        bus.start();
        bus.stop();

        Vehicle bike = new Bike();
        bike.start();
        bike.stop();
        // end here
        // what if it will be user input.
        String vehicleType = "Bus"; // Imagine this value is dynamic
        Vehicle vehicle;
        if (vehicleType.equals("car")) {
            vehicle = new car();
        } else if (vehicleType.equals("Bus")) {
            vehicle = new Bus();
        } else if (vehicleType.equals("Bike")) {
            vehicle = new Bike();
        } else {
            throw new IllegalArgumentException("Unknown vehicle type");
        }
        vehicle.start();
        vehicle.stop();
        // ends here

        /*
        In above case where we need user or config base we
          don't know the which object needs to create. In that case creating
          object at each place will lead to messing code. Solution is Factory design,
          creating class factory method which will handle "creating" object.
         */
        Vehicle car1 = VehicleFactory.getVehicle("car");
        car1.start();
        car1.stop();

        Vehicle bike1 = VehicleFactory.getVehicle("Bike");
        bike1.start();
        bike1.stop();

        Vehicle bus1 = VehicleFactory.getVehicle("Bus");
        bus1.start();
        bus1.stop();
    }
}
