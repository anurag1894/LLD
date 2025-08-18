package AMS.model;

import AMS.constant.BookingStatus;
import AMS.strategy.PaymentProcess;
import AMS.strategy.PaymentStrategy;


import java.util.ArrayList;
import java.util.List;

public class Booking {

    Flight flight;
    User user;
    List<Seat> seats;
    int amount;
    int bookingId;
    BookingStatus status;
    PaymentProcess paymentProcessor;

    public Booking(Flight flight, User user,int bookingId,PaymentStrategy paymentStrategy) {
        this.flight = flight;
        this.user = user;
        this.seats = new ArrayList<Seat>();
        this.amount = 0;
        this.bookingId = bookingId;
        status = BookingStatus.CREATE;
        this.paymentProcessor = new PaymentProcess(paymentStrategy);
    }

    public boolean addSeat(int seatId) {
        Seat seat = flight.seats.get(seatId);
        seats.add(seat);
        seat.isAvailable = false;
        amount += seat.getAmount();
        return true;
    }

    public boolean removeSeat(int seatId) {
        for (Seat seat : seats) {
            if(seat.getSeatID() == seatId) {
                seat.isAvailable = true;
                amount -= seat.getAmount();
                seats.remove(seat);
                return true;
            }
        }
        System.out.println(seatId + " is not available");
        return false;
    }

    public int getTotalAmount() {
        System.out.println("Total amount "+amount);
        return amount;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public  void setPaymentProcessor(PaymentStrategy paymentStrategy) {
        paymentProcessor.setPaymentStrategy(paymentStrategy);
    }
    public void makePayment() {
        if(paymentProcessor == null) {
            System.out.println("PaymentProcessor is null, Please pick a payment method first");
            return;
        }
        paymentProcessor.processPayment(amount);
    }

    public BookingStatus getStatus() {
        return status;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
