package HMS;

import HMS.model.RoomType;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the  Anurag & Monika's Hotel Mgmt Service");
        BookingManager bookingManager = BookingManager.getInstance();
        bookingManager.addRoom(RoomType.DELUX);
        bookingManager.addRoom(RoomType.DELUX);
        bookingManager.addRoom(RoomType.DELUX);
        bookingManager.addRoom(RoomType.SUITE);
        bookingManager.addRoom(RoomType.SUITE);
        bookingManager.addRoom(RoomType.PREMIUM);
        Scanner scanner = new Scanner(System.in);
        int userID = 1;
        while(true) {
            System.out.println("Please select operation for booking or checkout");
            System.out.println("1. Checkout Room");
            System.out.println("2. Booking Room");
            int operation = scanner.nextInt();
            scanner.nextLine();
            if(operation == 1) {
                System.out.println("Please enter user ID");
                userID = scanner.nextInt();
                scanner.nextLine();
                bookingManager.chekoutBooking(userID);
                continue;
            }
            System.out.println("Please enter name : ");
            String name = scanner.nextLine();
            User user = new User(userID++, name);
            bookingManager.showRoom();
            System.out.println("Please enter your room number:  and room type: ");
            String roomType = scanner.nextLine();
            int roomNumber = scanner.nextInt();
            scanner.nextLine();
            bookingManager.pickRoom(user, roomNumber,RoomType.getRoomType(roomType));
            System.out.println("Enter start date and end date: ");
            int startDate = scanner.nextInt();
            int endDate = scanner.nextInt();
            scanner.nextLine();
            bookingManager.bookRoom(user, startDate, endDate);
            System.out.println("Please enter yes or no for confirm booking: ");

            String confirmBooking = scanner.nextLine();
            if(confirmBooking.equals("yes")) {
                bookingManager.confirmBooking(user);
            } else {
                bookingManager.cancelBooking(user);
            }
        }
    }
}
