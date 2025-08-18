package AMS.service;

import AMS.constant.BookingStatus;
import AMS.model.Booking;
import AMS.model.Flight;
import AMS.model.Seat;
import AMS.model.User;
import AMS.strategy.PaymentStrategy;

import java.util.HashMap;
import java.util.Map;


public class AirlineMgmtService {
    Map<Integer,User> userMap;
    Map<Integer, Flight> flightMap;
    Map<Integer,Booking> bookingMap;
    User currentUser;
    Flight currentFlight;
    int bookingID;
    Booking currentBooking;

    public static AirlineMgmtService airlineMgmtService = new AirlineMgmtService();

    public static AirlineMgmtService getInstance() {
        return airlineMgmtService;
    }

    private AirlineMgmtService() {
        userMap = new HashMap<Integer,User>();
        flightMap = new HashMap<Integer, Flight>();
        currentUser = null;
        currentFlight = null;
        bookingID = 0;
        currentBooking = null;
    }

    public void addUser(int userId,String userName){
        User user = new User(userId,userName);
        userMap.put(userId,user);
    }

    public void addFlight(int flightId,int userId,String departure,String arrival, String flightName){
        Flight flight = new Flight(arrival,flightId,flightName,departure,1000,1500);
        flightMap.put(flightId,flight);
    }
    public void addFlight(Flight flight){
        flightMap.put(flight.getFlightID(), flight);
    }

    public void showFlights(int userId){ // Can add departure and arrival, also extend can be for searching Strategy like based on time and price
        currentUser = userMap.get(userId);
        for(Flight flight : flightMap.values()){
          System.out.println("flight Id: " + flight.getFlightID() + " will go from "+ flight.getDepartureAirport() + " to "+ flight.getArrivalAirport());
        }
    }

    public void pickFlight(int flightId){
        Flight flight = flightMap.get(flightId);
        currentFlight = flight;
    }

    public void showSeats(){
        for(Seat seat : currentFlight.getSeats()){
            if(seat.isAvailable()){
                System.out.println("seat Id: " + seat.getSeatID() + " is available");
            }
        }
    }
    public boolean pickAndAddSeat(int seatId){
        seatId--;
        Seat seat = currentFlight.getSeats().get(seatId);
        if(seat.isAvailable()){
            seat.setAvailable();
            currentBooking.addSeat(seatId);
            return true;
        } else{
            System.out.println("Seat "+seatId+" is not available, Please choose another seat");
            return false;
        }
    }

    public void processBooking(){
        Booking booking = new Booking(currentFlight,currentUser, bookingID++, null);
        currentUser.addBooking(booking);
        currentBooking = booking;
        booking.setStatus(BookingStatus.IN_PROGRESS);
    }

    public void processPayment(PaymentStrategy paymentStrategy){
        currentBooking.setStatus(BookingStatus.PAYMENT_MODE);
        currentBooking.setPaymentProcessor(paymentStrategy);
        System.out.println("Total amount need to pay : "+ currentBooking.getTotalAmount());
        currentBooking.makePayment();;
    }

    public void completeBooking(){
        currentBooking.setStatus(BookingStatus.BOOKED);
        System.out.println("Booking completed for flight "+ currentFlight.getFlightID());
    }

    public void cancelBooking(int bookingId){
        // Future using command
    }

    public void reset(){
        currentBooking = null;
        currentFlight = null;
        currentUser = null;
    }
}
