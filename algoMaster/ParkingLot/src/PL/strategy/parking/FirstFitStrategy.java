package PL.strategy.parking;


import PL.entities.Floor;
import PL.entities.Spot;
import PL.entities.Vehicle;

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