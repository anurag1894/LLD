package ParkingLotSystem.Manager;

import ParkingLotSystem.enums.VehicleType;
import ParkingLotSystem.model.Ticket;
import ParkingLotSystem.strategy.charges.ChargesStrategy;
import ParkingLotSystem.strategy.charges.FixedCharges;
import ParkingLotSystem.strategy.payment.paymentStrategy;
import ParkingLotSystem.vehicle.BUS;
import ParkingLotSystem.vehicle.Car;
import ParkingLotSystem.vehicle.VehicleFactory;
import ParkingLotSystem.vehicle.vehicle;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ParkingLotSystem.enums.VehicleType.BUS;
import static ParkingLotSystem.enums.VehicleType.CAR;

public class ParkingLotManager {
    private static ParkingLotManager instance = new ParkingLotManager();

    public List<vehicle> vehicles = new ArrayList<vehicle>();
    public List<Ticket> tickets = new ArrayList<>();
    public List<Boolean>  busSlot = new ArrayList<>();
    public List<Boolean> carSlot = new ArrayList<>(10);
    public VehicleFactory vehicleFactory = new VehicleFactory();

    private ParkingLotManager() {
        busSlot = initSlotList(20);
        carSlot = initSlotList(10);
    }

    private List<Boolean> initSlotList(int size) {
        List<Boolean> slots = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            slots.add(false); // all slots initially empty
        }
        return slots;
    }

    public static synchronized ParkingLotManager getInstance() {
        if (instance == null) {
            instance = new ParkingLotManager();
        }
        return instance;
    }




    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public vehicle getVehicle(int id) {
        for (vehicle vehicle : vehicles) {
            if (vehicle.getId() == id) {
                return vehicle;
            }
        }
        return null;
    }


    public int bookSlot(VehicleType vehicleType){
        if(vehicleType.equals(VehicleType.BUS)){
            for(int i=0; i<20;i++){
                if(busSlot.get(i) == false){
                    busSlot.set(i, true);
                    return i;
                }
            }
        }else{
            for(int i=0; i<10;i++){
                if(carSlot.get(i) == false){
                    carSlot.set(i, true);
                    return i;
                }
            }
        }
        return -1;
    }



    public int newVehicleEntry(VehicleType vehicleType, int vehicleID, ChargesStrategy chargesStrategy) {
        vehicle newVehicle = vehicleFactory.createVehicle(vehicleType);
        newVehicle.setId(vehicleID);
        newVehicle.setChargesStrategy(chargesStrategy);
        // if available slot  = -1 we should return exception
        int availableSlot = this.bookSlot(vehicleType);
        Ticket newTicket = new Ticket(1, vehicleID, availableSlot); // will update ticekt id later
        newVehicle.setParkingLot(availableSlot);
        this.addTicket(newTicket);
        this.vehicles.add(newVehicle);
        return newTicket.getTicketId();
    }

    public void freeSlot(int parkingLotID,VehicleType vehicleType ) {
        if(vehicleType.equals(VehicleType.BUS)){
            busSlot.set(parkingLotID, false);
        }else if(vehicleType.equals(VehicleType.CAR)){
            carSlot.set(parkingLotID, false);
        } else {
            System.out.println("Invalid Vehicle Type");
        }

    }

    public Ticket getTicket( int vehicleID) {
        for (Ticket ticket : tickets) {
            if(ticket.getVehicleId() == vehicleID) {
                return ticket;
            }
        }
        return null;
    }

    public vehicle vehicleExit(int vehicleID) {
       // free the spot
        vehicle vehicle = this.getVehicle(vehicleID);
        if(vehicle instanceof Car){
            freeSlot(vehicle.getParkingLot(), CAR);
        }else if (vehicle instanceof BUS){
            freeSlot(vehicle.getParkingLot(),BUS);
        } else{
            System.out.println("Invalid vehicle exit");
        }
        // remove vehicle from list
        this.vehicles.remove(vehicle);
        return vehicle; // We should use ticket Id to get the ticket details , But since it is 1-1 mapping that is fine
    }

    public int makePayment(int vehicleId, paymentStrategy paymentStrategy) {
        vehicle vehicle = this.vehicleExit(vehicleId);
        Ticket ticket = this.getTicket(vehicleId); // We should use ticket ID
        ticket.setExitTimestamp(Math.toIntExact(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)));
        int timeInHour = (ticket.getExitTimestamp() - ticket.getEntryTimestamp())/3600;
        int cost = 0;
        if(vehicle.getChargesStrategy() instanceof FixedCharges){
            cost += vehicle.getParkingCharge();
        } else{
             cost += vehicle.getParkingCharge()*timeInHour;
        }
        cost += paymentStrategy.getCharge();
        paymentStrategy.makePayment(cost);
        this.tickets.remove(ticket);
        return ticket.getTicketId();
    }
}
