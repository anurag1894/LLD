package CarRentalService;

import CarRentalService.Controller.RentalSystem;
import CarRentalService.entity.Booking;
import CarRentalService.entity.RentalStore;
import CarRentalService.entity.User;
import CarRentalService.factory.Car;
import CarRentalService.factory.Sedan;
import CarRentalService.factory.Suv;
import CarRentalService.strategy.PaymentStrategy;
import CarRentalService.strategy.PerDayPayment;
import CarRentalService.strategy.PerKmPayment;

public class Main {
    public static void main(String[] args) {
        PaymentStrategy kmBasedPayment =  new PerKmPayment();
        PaymentStrategy dayWisePayment =  new PerDayPayment();

        RentalSystem rentalSystem = RentalSystem.getInstance();

        RentalStore rentalStore = rentalSystem.getStores();
        // since we are using single store we will be fetching via rentalSystem if we have multi store we can add
        // store into this rental system via list. for more details check RentalSystem class

        Car sedan1 = new Sedan();
        sedan1.setCarId(1);
        sedan1.free();

        Car sedan2 = new Sedan();
        sedan2.setCarId(2);
        sedan2.free();

        // WE should use abstract class instead of interface so we can create this object using factory
        //

        Car suv1 = new Suv();
        suv1.setCarId(3);
        suv1.free();
        Car suv2 = new Suv();
        suv2.setCarId(4);
        suv2.free();
        Car suv3 = new Suv();
        suv3.setCarId(5);
        suv3.free();

        rentalStore.addVehicle(sedan1);
        rentalStore.addVehicle(sedan2);
        rentalStore.addVehicle(suv1);
        rentalStore.addVehicle(suv2);
        rentalStore.addVehicle(suv3);

        User user = rentalSystem.createUser(1,"Anurag", "Jha", "anurag@gmail.com");

        Booking booking = rentalSystem.createBooking(user.getUserId(),3,23,45,dayWisePayment,100);
        //System.out.println(booking.getBookingId() + booking.getCar().getCarId() + booking.getCost());
        rentalSystem.startRental(booking.getBookingId());
        rentalSystem.completeRental(booking.getBookingId());
        rentalSystem.makePayment(booking.getBookingId());


        User user1 = rentalSystem.createUser(2,"Monika", "Upadhyay", "anurag@gmail.com");

        Booking booking1 = rentalSystem.createBooking(user1.getUserId(),1,23,45,kmBasedPayment,100);
        rentalSystem.cancelReservation(booking1.getBookingId());
        rentalSystem.startRental(booking1.getBookingId());
        rentalSystem.completeRental(booking1.getBookingId());

        rentalSystem.makePayment(booking1.getBookingId());

    }
}
