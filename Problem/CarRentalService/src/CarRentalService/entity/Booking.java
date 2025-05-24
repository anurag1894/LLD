package CarRentalService.entity;

import CarRentalService.enums.BookingState;
import CarRentalService.factory.Car;
import CarRentalService.strategy.PaymentStrategy;
import CarRentalService.strategy.PerKmPayment;

public class Booking {

    int bookingId;
    User user;
    Car car;
    PaymentStrategy paymentStrategy;
    BookingState state;
    int cost;
    int startDate;
    int endDate;
    int totalDistance;

    public Booking(int bookingId, User user, Car car, PaymentStrategy paymentStrategy, int startDate, int endDate, int totalDistance) {
        this.bookingId = bookingId;
        this.user = user;
        this.car = car;
        this.paymentStrategy = paymentStrategy;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalDistance = totalDistance;
        this.cost = car.rent() ;
        if(paymentStrategy instanceof PerKmPayment){
            cost += paymentStrategy.getCost(totalDistance);
        }else{
            cost += paymentStrategy.getCost(endDate - startDate);
        }
    }

    public void confirmReservation() {
        if (state == BookingState.PENDING) {
            state = BookingState.CONFIRMED;
            car.setBooked();
        }
    }

    public void cancelBooking() {
        if (state == BookingState.PENDING
                || state == BookingState.CONFIRMED) {

            state = BookingState.CANCELLED;
            car.free();

        }
    }

    public void startRental(){
        if(state == BookingState.CONFIRMED){
            state = BookingState.INPROGRESS;
        }
    }

    public void completeRental(){
        if(state == BookingState.INPROGRESS){
            state = BookingState.COMPLETED;
            car.free();
        }
    }



    public int getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public Car getCar() {
        return car;
    }

    public int getCost() {
        return cost;
    }

    public BookingState getState() {
        return state;
    }
}
