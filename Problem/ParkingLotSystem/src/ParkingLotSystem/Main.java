package ParkingLotSystem;

import ParkingLotSystem.Manager.ParkingLotManager;
import ParkingLotSystem.enums.VehicleType;
import ParkingLotSystem.strategy.charges.ChargesStrategy;
import ParkingLotSystem.strategy.charges.FixedCharges;
import ParkingLotSystem.strategy.charges.HourlyCharges;
import ParkingLotSystem.strategy.payment.Card;
import ParkingLotSystem.strategy.payment.Cash;
import ParkingLotSystem.strategy.payment.UPI;
import ParkingLotSystem.strategy.payment.paymentStrategy;
import Payment.Upi;

public class Main {
    public static void main(String[] args) {
        ChargesStrategy fixedCharges = new FixedCharges();
        ChargesStrategy hourlyCharges = new HourlyCharges();

        paymentStrategy Card = new Card();
        paymentStrategy upi = new UPI();
        paymentStrategy cash = new Cash();

        ParkingLotManager parkingLotManager = ParkingLotManager.getInstance();

        int ticketIdBus = parkingLotManager.newVehicleEntry(VehicleType.BUS,121,fixedCharges);
        // We should use this ticket to  exit but for time being we will use vehicle Id.

        int ticketIdCar = parkingLotManager.newVehicleEntry(VehicleType.CAR,1212,hourlyCharges);
        parkingLotManager.makePayment(121,cash);

        parkingLotManager.makePayment(1212,Card);
        // It will pay only credit card as time is very less.
        // also you can add log as well.

    }
}
