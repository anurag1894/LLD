package CarRentalService.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    int userId;
    String firstName;
    String lastName;
    String email;
    List<Booking> bookings;

    public User(int userId, String firstName, String lastName, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        bookings = new ArrayList<>();
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void deleteBooking(Booking booking) {
        bookings.remove(booking);
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public int getUserId() {
        return userId;
    }
}
