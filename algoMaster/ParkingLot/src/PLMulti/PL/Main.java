package PLMulti.PL;

import PLMulti.PL.entities.Floor;
import PLMulti.PL.entities.Spot;
import PLMulti.PL.entities.Ticket;
import PLMulti.PL.entities.Vehicle;
import PLMulti.PL.enums.VehicleType;
import PLMulti.PL.strategy.fee.HourlyFeeStrategy;
import PLMulti.PL.strategy.parking.FirstFitStrategy;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        ParkingLotSystem parkingLotSystem = ParkingLotSystem.getInstance();

        Floor floor = new Floor(1);
        Floor floor2 = new Floor(2);

        Spot s1F1 = new Spot(VehicleType.SMALL);
        Spot s2F1 = new Spot(VehicleType.SMALL);
        Spot s3F1 = new Spot(VehicleType.MEDIUM);
        Spot s4F1 = new Spot(VehicleType.LARGE);
        floor.addSpot(s1F1);
        floor.addSpot(s2F1);
        floor.addSpot(s3F1);
        floor.addSpot(s4F1);

        Spot s1F2 = new Spot(VehicleType.MEDIUM);
        Spot s2F2 = new Spot(VehicleType.LARGE);
        Spot s3F2 = new Spot(VehicleType.LARGE);
        Spot s4F2 = new Spot(VehicleType.SMALL);
        floor.addSpot(s1F2);
        floor.addSpot(s2F2);
        floor.addSpot(s3F2);

        parkingLotSystem.add(floor);
        parkingLotSystem.add(floor2);

        Vehicle vehicle = new Vehicle(123, VehicleType.SMALL);
        Vehicle vehicle2 = new Vehicle(1234, VehicleType.MEDIUM);
        Vehicle vehicle3 = new Vehicle(5678, VehicleType.LARGE);
        parkingLotSystem.setParkingStrategy(new FirstFitStrategy());
        parkingLotSystem.setFeeStrategy(new HourlyFeeStrategy());

        Optional<Ticket> ticket1 = parkingLotSystem.parkVehicle(vehicle);
        Optional<Ticket> ticket2 = parkingLotSystem.parkVehicle(vehicle2);
        if(ticket2.isPresent() ) {
            Optional<Double> fee2 = parkingLotSystem.unparkVehicle(ticket2.get());
            System.out.println("Ticket 2: " + ticket1.get() + " fee: " + fee2.get());
        }

        Optional<Ticket> ticket3 = parkingLotSystem.parkVehicle(vehicle3);

        if(ticket3.isPresent() ) {
            Optional<Double> fee3 = parkingLotSystem.unparkVehicle(ticket3.get());
            System.out.println("Ticket 3: " + ticket3.get() + " fee: " + fee3.get());
        }
        if(ticket1.isPresent() ) {
            Optional<Double> fee1 = parkingLotSystem.unparkVehicle(ticket1.get());
            System.out.println("Ticket 1: " + ticket1.get() + " fee: " + fee1.get());
        }

    }
}
