package AMS.command;

import AMS.model.Booking;

import java.util.ArrayList;
import java.util.List;

public class ProcessInvoker {
    List<Booking> bookingList;
    public ProcessInvoker() {
        List<Booking> bookingList = new ArrayList<Booking>();
    }

    public void processBooking(Booking booking, FlightCommand flightCommand) {
        flightCommand.execute(booking);
        bookingList.add(booking);
    }
}
