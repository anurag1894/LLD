package HMS;

import HMS.model.RoomType;
import HMS.room.Room;
import HMS.room.RoomFactory;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingManager {
    List<Booking> bookingList;
    List<User> userList;
    List<Room> roomList;
    Map<User, Room> userRoomMap;
    Map<User, Booking> userBookingMap;
    User currentUser;

    private static BookingManager instance = new BookingManager();
    public static BookingManager getInstance() {
        return instance;
    }
    private BookingManager() {
        this.bookingList = new ArrayList<>();
        this.userList = new ArrayList<>();
        this.roomList = new ArrayList<>();
        userRoomMap = new HashMap<>();
        userBookingMap = new HashMap<>();
    }

    public void addRoom(RoomType roomType) {
        Room room = RoomFactory.createRoom(roomType);
        if(room != null) {
            roomList.add(room);
        } else {
            System.out.println("Room can't be null");
        }
    }

    public void showRoom() {
        for (Room room : roomList) {
            if(room.isAvailable()){
                System.out.println(room.getRoomNumber() + " of  " + room.getType()+ " is available");
            }
        }
    }

    public boolean pickRoom(User user,int roomNumber, RoomType roomType) {
        userList.add(user);
        for (Room room : roomList) {
            if(room.getRoomNumber()== roomNumber && room.getType().equals(roomType) && room.isAvailable()){
                room.available = false;
                userRoomMap.put(user, room);
                return true;
            }
        }
        return false;
    }

    public void bookRoom(User user, int startDate,int endDate) {
        Room room = userRoomMap.get(user);
        Booking booking = new Booking(room,startDate,endDate,user);
        bookingList.add(booking);
        userBookingMap.put(user, booking);
        System.out.println("user please pay amount " + booking.getAmount(0));
    }

    public boolean confirmBooking(User user) {
        Booking booking = userBookingMap.get(user);
        int bookingID =booking.bookRoom();
        System.out.println(bookingID + "  room has been booked with room id "+ booking.room.getRoomNumber() + " of type "+ booking.room.getType());
        return true;
    }

    public void cancelBooking(User user) {
       Booking booking = userBookingMap.get(user);
       userBookingMap.remove(user);
       booking.cancelBooking();
    }

    public void reset(){
        currentUser = null;
    }

    public void chekoutBooking(int userID) {
        for(User user : userList) {
            if(user.getUserID() == userID){
                currentUser = user;
            }
        }
        if(currentUser != null){
            Booking booking = userBookingMap.get(currentUser);
            System.out.println(currentUser.getUserName() + " has been checkOut from "+ booking.room.getRoomNumber());
            reset();
            booking.checkout();
        } else{
            System.out.println("No booking found");
        }

    }
}
