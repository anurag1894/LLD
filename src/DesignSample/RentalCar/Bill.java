package RentalCar;

public class Bill {
    private double billAmount;
    public
    Reservation reservation;

    Boolean isBillPaid;



    public Bill(Reservation reservation, double bill) {
        this.reservation = reservation;
        billAmount = this.calculateBill(bill);
        isBillPaid =false;
    }

    double calculateBill(double bill){
        return bill + 5.0; // 5 rupee is tax
    }

}
