package CarRentalService.entity;

import CarRentalService.enums.BookingState;
import CarRentalService.factory.Car;
import CarRentalService.strategy.PaymentStrategy;

import java.util.HashMap;
import java.util.Map;

public class Admin {
    private Map<Integer, Booking> bookingMap;
    private int nextReservationId;

    public Admin() {
        this.bookingMap = new HashMap<>();
        this.nextReservationId = 1;
    }

    public Integer createBooking(User user,
                                 Car car,
                                 PaymentStrategy paymentStrategy,
                                 Integer startDate,
                                 Integer endDate,
                                 Integer distance) {
        System.out.println("Creating a booking");
        Booking booking = new Booking(nextReservationId,user,car,paymentStrategy,startDate,endDate,distance);
        System.out.println("Created a booking "+booking.getBookingId());
        bookingMap.put(nextReservationId, booking);
        booking.state = BookingState.PENDING;
        user.addBooking(booking);
        return nextReservationId++;
    }

    public void confirmBooking(Integer bookingId) {
        Booking booking = bookingMap.get(bookingId);
        booking.confirmReservation();

    }

    public void cancelBooking(Integer bookingId) {
        Booking booking = bookingMap.get(bookingId);
        booking.cancelBooking();
    }

    public void startRental(Integer bookingId) {
        Booking booking = bookingMap.get(bookingId);
        booking.startRental();
    }

    public void endRental(Integer bookingId) {
        Booking booking = bookingMap.get(bookingId);
        booking.completeRental();
    }

    public Booking getBooking(Integer bookingId) {
        return bookingMap.get(bookingId);
    }
}
