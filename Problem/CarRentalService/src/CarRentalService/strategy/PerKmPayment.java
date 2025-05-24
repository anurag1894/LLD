package CarRentalService.strategy;

public class PerKmPayment implements PaymentStrategy{
    @Override
    public int getCost(int distance) {
        return 10*distance;
    }
}
