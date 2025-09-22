package PL;

import PL.entities.Floor;
import PL.entities.Spot;
import PL.entities.Ticket;
import PL.entities.Vehicle;
import PL.strategy.fee.FeeStrategy;
import PL.strategy.parking.ParkingStrategy;

import java.util.*;

public class ParkingLotSystem {
    private List<Floor> floors;
    Map<String, Ticket> ticketMap;
    ParkingStrategy parkingStrategy;
    FeeStrategy feeStrategy;

    private ParkingLotSystem() {
        this.floors = new ArrayList<>();
        this.ticketMap = new HashMap<>();
    }

    private static ParkingLotSystem instance;
    public static synchronized ParkingLotSystem getInstance() {
        if (instance == null) {
            instance = new ParkingLotSystem();
        }
        return instance;
    }

    public void add(Floor floor) {
        this.floors.add(floor);
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }
    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public Optional<Ticket> parkVehicle(Vehicle vehicle) {
        Optional<Spot> spot = parkingStrategy.findSpot(vehicle,floors);
        Optional<Ticket> ticket = Optional.empty();
        if (spot.isPresent()) {
            Spot sp = spot.get();
            sp.parkVehicle(vehicle);
            ticket = Optional.of(new Ticket(vehicle, sp));
            ticketMap.put(ticket.get().getUuid(), ticket.get());
            System.out.println(ticket.get().getUuid() + " has been assigned to " + sp.getSize()+"  for vehicle "+ vehicle.getVehicleID());
            return ticket;
        } else {
            System.out.println("No free spot");
            return ticket;
        }
    }


    public Optional<Double> unparkVehicle(Ticket ticket) {
        if(ticketMap.containsKey(ticket.getUuid())) {
            ticket.setExitTime();
            double fee = feeStrategy.calculateFee(ticket);
            ticket.getSpot().unparkVehicle();
            ticketMap.remove(ticket.getUuid());
            System.out.println(ticket.getUuid() + " has been unparked please pay "+fee);
            return Optional.of(fee);

        }
        System.out.println("No ticket exist or vehicle parked");
        return Optional.empty();
    }
}
