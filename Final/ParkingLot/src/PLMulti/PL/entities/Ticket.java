package PLMulti.PL.entities;

import java.util.Date;
import java.util.UUID;

public class Ticket {
    private String  uuid;
    private Vehicle vehicle;
    long entryTime;
    long exitTime;
    Spot spot;
    public Ticket(Vehicle vehicle, Spot spot) {
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = new Date().getTime();
        this.uuid = UUID.randomUUID().toString();
    }

    public String getUuid() {
        return uuid;
    }
    public  void setExitTime() {
        this.exitTime =new Date().getTime();
    }
    public long getParkingDuration() {
        return exitTime-entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Spot getSpot() {
        return spot;
    }
}
