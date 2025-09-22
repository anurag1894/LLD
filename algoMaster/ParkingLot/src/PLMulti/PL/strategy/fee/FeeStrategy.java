package PLMulti.PL.strategy.fee;

import PLMulti.PL.entities.Ticket;
import PLMulti.PL.enums.VehicleType;

import java.util.Map;

public interface FeeStrategy {
    public double calculateFee(Ticket ticket);
}


class FixedFeeStrategy implements FeeStrategy {
    private static final Map<VehicleType, Double> HOURLY_RATES = Map.of(
            VehicleType.SMALL, 10.0,
            VehicleType.MEDIUM, 20.0,
            VehicleType.LARGE, 30.0
    );

    @Override
    public double calculateFee(Ticket ticket) {
        long hour = ticket.getParkingDuration()/(1000*60*60)+1;
        return hour * HOURLY_RATES.get(ticket.getVehicle().getType());
    }
}