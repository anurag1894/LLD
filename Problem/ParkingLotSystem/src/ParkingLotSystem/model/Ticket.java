package ParkingLotSystem.model;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Ticket {

    public int ticketId;
    public int vehicleId;
    public int slotId;
    public int entryTimestamp;
    public int exitTimestamp;

    public Ticket(int ticketId, int vehicleId,int slotId) {
        this.ticketId = ticketId;
        this.vehicleId = vehicleId;
        this.slotId = slotId;
        this.entryTimestamp = Math.toIntExact(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
    }



    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setEntryTimestamp(int entryTimestamp) {
        this.entryTimestamp = entryTimestamp;
    }

    public void setExitTimestamp(int exitTimestamp) {
        this.exitTimestamp = exitTimestamp;
    }

    public int getTicketId() {
        return ticketId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public int getEntryTimestamp() {
        return entryTimestamp;
    }

    public int getExitTimestamp() {
        return exitTimestamp;
    }
}
