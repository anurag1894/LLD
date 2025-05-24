package CarRentalService.Controller;

import CarRentalService.entity.Admin;
import CarRentalService.entity.Booking;
import CarRentalService.entity.RentalStore;
import CarRentalService.entity.User;
import CarRentalService.enums.BookingState;
import CarRentalService.factory.Car;
import CarRentalService.factory.CarFactory;
import CarRentalService.strategy.PaymentStrategy;

import java.util.HashMap;
import java.util.Map;

public class RentalSystem {
    private static RentalSystem instance = new RentalSystem();
    Admin admin;                         // We can have list of admin
    RentalStore rentalStore;             // We can have list of rental store
    private CarFactory carFactory;
    private Map<Integer, User> users;
    int nextUserId;

    private RentalSystem(){
        this.rentalStore = new RentalStore(1, "Rental Store");
        this.carFactory = new CarFactory();
        this.admin = new Admin();
        this.users = new HashMap<>();
        this.nextUserId = 1;

    }


    public static synchronized RentalSystem getInstance() {
        if (instance == null) {
            instance = new RentalSystem();
        }
        return instance;
    }

    public void setRentalStore(RentalStore rentalStore) {
        this.rentalStore = rentalStore;
    }

    public RentalStore getStores() {
        return rentalStore;
    }


    public User getUser(int userId) {
        return users.get(userId);
    }

    public void startRental(int bookingId) {
        admin.startRental(bookingId);
    }

    public void completeRental(int bookingId) {
        admin.endRental(bookingId);
    }

    public void cancelReservation(int bookingId) {
        admin.cancelBooking(bookingId);
    }

    public Booking createBooking(int userId,
                                 int carId,
                                 int startDate,
                                 int endDate,
                                 PaymentStrategy paymentStrategy,
                                 int distance) {
        User user = getUser(userId);
        Car car = rentalStore.getVehicle(carId);
        int bookingId = admin.createBooking(user,car, paymentStrategy,startDate,endDate,distance);
        return  admin.getBooking(bookingId);
    }

    public boolean makePayment(int bookingId){
        Booking booking = admin.getBooking(bookingId);
        if(booking.getState().equals(BookingState.COMPLETED)) {
            admin.endRental(bookingId);
            int totalCost = booking.getCost(); // We can improve here for how we are using paymentStrategy
            System.out.println("Total cost: paying to " + totalCost);
            return true;
        } else {
            System.out.println("Booking not completed");
            return false;
        }
    }

    public User createUser(int id,String firstName, String lastName, String email) {
        User user = new User(id,firstName,lastName,email);
        users.put(id, user);
        return user;
    }

}
