package PL.strategy.parking;

import AMS.model.Flight;
import PL.entities.Floor;
import PL.entities.Spot;
import PL.entities.Vehicle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {
    public Optional<Spot> findSpot(Vehicle vehicle, List<Floor> floors);
}

class BestFirstStrategy implements ParkingStrategy {
    @Override
    public Optional<Spot> findSpot(Vehicle vehicle, List<Floor> floors) {
        Optional<Spot> spot = Optional.empty();
        for(Floor floor : floors) {
            Optional<Spot> currSpot = floor.getSpot(vehicle);
            if(currSpot.isPresent()) {
                if(spot.isEmpty() || (spot.get().getSize() > currSpot.get().getSize()))
                          spot = currSpot;
            }
        }
        return spot;
    }
}


class FurthestStrategy implements ParkingStrategy {

    @Override
    public Optional<Spot> findSpot(Vehicle vehicle, List<Floor> floors) {
        List<Floor> reverseFloors = new ArrayList<>(floors);
        Collections.reverse(reverseFloors);
        for(Floor floor : reverseFloors) {
            Optional<Spot> currSpot = floor.getSpot(vehicle);
            if(currSpot.isPresent()) {
                return Optional.of(currSpot.get());
            }
        }
        return Optional.empty();
    }
}
