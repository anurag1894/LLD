package PLMulti.PL.strategy.parking;


import PLMulti.PL.entities.Floor;
import PLMulti.PL.entities.Spot;
import PLMulti.PL.entities.Vehicle;

import java.util.List;
import java.util.Optional;

public class FirstFitStrategy implements ParkingStrategy {
    @Override
    public Optional<Spot> findSpot(Vehicle vehicle, List<Floor> floors) {

        for(Floor floor : floors) {
            Optional<Spot> currSpot = floor.getSpot(vehicle);
            if(currSpot.isPresent()) {
                return Optional.of(currSpot.get());
            }
        }
        return Optional.empty();
    }
}