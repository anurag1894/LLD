package AMS;

import AMS.model.Flight;
import AMS.service.AirlineMgmtService;
import AMS.strategy.CreditCardPayment;
import AMS.strategy.DebitCardPayment;
import AMS.strategy.UpiPayment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Airline Mgmt Service");
        AirlineMgmtService service = AirlineMgmtService.getInstance();

        Flight flight = new Flight("GOP",1,"BGL_GOP","BGL",4000,7000);
        Flight flight1 = new Flight("BGL",2,"GOP_BGL","GOP",4000,7000);
        Flight flight2 = new Flight("BGL",3,"6e-3456","GOP",3000,8000);
        Flight flight24 = new Flight("GOP",4,"6e-3459","GOP",3500,5000);
        service.addFlight(flight);
        service.addFlight(flight1);
        service.addFlight(flight2);
        service.addFlight(flight24);
        service.addUser(1,"Anurag");
        service.addUser(2,"Monika");
        service.addUser(3,"Bob");
        service.addUser(4,"Adarsh");

        while(true){
            System.out.println("Please enter the user ID");
            Scanner scanner = new Scanner(System.in);
            int userID = scanner.nextInt();
            service.showFlights(userID);
            System.out.println("Select a flight from the list");
            int input = scanner.nextInt();
            service.pickFlight(input);
            service.processBooking();
            while(true){
                System.out.println("Please entry s to select seat or type anything for exist");
                scanner.nextLine();
                String flag = scanner.nextLine();
                if(flag.equals("s")){
                    System.out.println("Please enter the seat ID");
                    service.showSeats();
                    int seatID = scanner.nextInt();
                    service.pickAndAddSeat(seatID);
                }else{
                    break;
                }
            }
            System.out.println("Please type yes for confirm the booking");
            String confirm = scanner.nextLine();
            if(confirm.equals("yes")){
                System.out.println("Please select the payment method 1. credit, 2. Debit card, 3. Upi ");
                int payment = scanner.nextInt();
                if(payment == 1){
                    service.processPayment(new CreditCardPayment());
                } else if(payment == 2){
                    service.processPayment(new DebitCardPayment());
                } else if(payment == 3){
                    service.processPayment(new UpiPayment());
                }
                service.completeBooking();
            }

        }

    }
}
