package PL.strategy.fee;

import PL.entities.Ticket;

public class HourlyFeeStrategy implements FeeStrategy {
    private static final double RATE_PER_HOUR = 10.0;
    @Override
    public double calculateFee(Ticket ticket) {
        long totalHour = ticket.getParkingDuration()/(1000 * 60 * 60)+1;
        return totalHour * RATE_PER_HOUR;
    }
}