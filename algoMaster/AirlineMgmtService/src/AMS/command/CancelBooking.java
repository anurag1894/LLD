package AMS.command;

import AMS.constant.BookingStatus;
import AMS.model.Booking;
import AMS.model.Seat;

public class CancelBooking implements FlightCommand{

    @Override
    public void execute(Booking booking) {
        for(Seat seat : booking.getSeats()) {
            booking.removeSeat(seat.getSeatID());
        }
        booking.setStatus(BookingStatus.CANCELLED);
        System.out.println("Booking cancelled");
    }
}
