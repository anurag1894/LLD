package AMS.command;

import AMS.constant.BookingStatus;
import AMS.model.Booking;

public class BookTicket implements FlightCommand{

    @Override
    public void execute(Booking booking) {
        booking.setStatus(BookingStatus.PAYMENT_MODE);
        booking.getTotalAmount();
        System.out.println("Booking Status: " + booking.getStatus());
        booking.makePayment();
        booking.setStatus(BookingStatus.BOOKED);
        System.out.println("Booking Status: " + booking.getStatus());
    }
}
