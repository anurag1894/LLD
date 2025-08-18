package AMS.model;

import java.util.ArrayList;
import java.util.List;

public class Flight {
    int flightID;
    String flightName;
    String departureAirport;
    String arrivalAirport;
    List<Seat> seats;

    public Flight(String arrivalAirport, int flightID, String flightName, String departureAirport,int amount, int premiumCost) {
        this.arrivalAirport = arrivalAirport;
        this.flightID = flightID;
        this.flightName = flightName;
        this.departureAirport = departureAirport;
        this.seats = new ArrayList<Seat>();
        for(int i=1;i<=90;i++){
            int seatCost = amount;
            if(i%6==0 || i%6==1)
                seatCost = premiumCost;
            seats.add(new Seat(i,seatCost));
        }
    }

    public int getFlightID() {
        return flightID;
    }

    public String getFlightName() {
        return flightName;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
