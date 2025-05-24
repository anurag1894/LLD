package CarRentalService.strategy;

public class PerDayPayment implements PaymentStrategy{
    @Override
    public int getCost(int dayCount) {
        return 1000*dayCount;
    }
}
