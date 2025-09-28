package PLMulti.PL;

import PLMulti.PL.entities.Floor;
import PLMulti.PL.entities.Spot;
import PLMulti.PL.entities.Ticket;
import PLMulti.PL.entities.Vehicle;
import PLMulti.PL.strategy.fee.FeeStrategy;
import PLMulti.PL.strategy.parking.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ParkingLotSystem {
    private List<Floor> floors;
    private final Map<String, Ticket> ticketMap;
    private ParkingStrategy parkingStrategy;
    private FeeStrategy feeStrategy;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private ParkingLotSystem() {
        this.floors = new ArrayList<>();
        this.ticketMap = new ConcurrentHashMap<>();
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

    public synchronized Optional<Ticket> parkVehicle(Vehicle vehicle) {
        lock.writeLock().lock();
        try {
            Optional<Spot> spot = parkingStrategy.findSpot(vehicle, floors);
            Optional<Ticket> ticket = Optional.empty();
            if (spot.isPresent()) {
                Spot sp = spot.get();
                // Double-check that spot is still available (race condition prevention)
                if (sp.isAvailable() && sp.canFit(vehicle)) {
                    if (sp.parkVehicle(vehicle)) {
                        ticket = Optional.of(new Ticket(vehicle, sp));
                        ticketMap.put(ticket.get().getUuid(), ticket.get());
                        System.out.println(ticket.get().getUuid() + " has been assigned to " + sp.getSize() + "  for vehicle " + vehicle.getVehicleID());
                        return ticket;
                    } else {
                        System.out.println("Spot became unavailable during assignment");
                        return Optional.empty();
                    }
                } else {
                    System.out.println("Spot became unavailable during assignment");
                    return Optional.empty();
                }
            } else {
                System.out.println("No free spot");
                return ticket;
            }
        } finally {
            lock.writeLock().unlock();
        }
    }


    public synchronized Optional<Double> unparkVehicle(Ticket ticket) {
        lock.writeLock().lock();
        try {
            if (ticketMap.containsKey(ticket.getUuid())) {
                ticket.setExitTime();
                double fee = feeStrategy.calculateFee(ticket);
                ticket.getSpot().unparkVehicle();
                ticketMap.remove(ticket.getUuid());
                System.out.println(ticket.getUuid() + " has been unparked please pay " + fee);
                return Optional.of(fee);
            }
            System.out.println("No ticket exist or vehicle parked");
            return Optional.empty();
        } finally {
            lock.writeLock().unlock();
        }
    }
}
