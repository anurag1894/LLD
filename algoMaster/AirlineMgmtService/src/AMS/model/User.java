package AMS.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    int userID;
    String userName;
    List<Booking> bookings;

    public User(int userID, String userName) {
        this.userID = userID;
        this.userName = userName;
        bookings = new ArrayList<Booking>();
    }

    public int getUserID() {
        return userID;
    }

    public List<Booking> getBookings() {
        return bookings;
    }
    public void addBooking(Booking booking) {
        bookings.add(booking);
    }
}
