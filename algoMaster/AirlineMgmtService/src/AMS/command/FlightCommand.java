package AMS.command;

import AMS.model.Booking;

public interface FlightCommand {
    public void execute(Booking booking);
}
