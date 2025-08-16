package HMS;

import HMS.room.Room;

import java.util.Random;

public class Booking {
    Room room;
    int startDate;
    int endDate;
    int amount;
    User user;
    boolean booked;
    int bookingID;

    public Booking(Room room, int startDate, int endDate, User user) {
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
        this.bookingID = Random.from(new Random()).nextInt();
    }
    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }

    public int getAmount(int offInPercentage) {
        this.amount = this.room.getPrice()*(this.endDate-this.startDate) *(100 - offInPercentage)/100;
        return this.amount;
    }
    public int bookRoom() {
        this.booked = true;
        this.room.available = false;
        return this.bookingID;
    }
    public void checkout(){
        this.room.available = true;
    }
    public  void cancelBooking(){
        this.booked = false;
    }
}
