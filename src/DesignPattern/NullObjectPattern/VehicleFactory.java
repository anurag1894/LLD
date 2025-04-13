package NullObjectPattern;

public class VehicleFactory {
    public static Vehicle  getVehicle(String vehicleType){
        if(vehicleType.equals("CAR")){
            return new Car();
        }
        return new VehicleNullClass();
    }
}
