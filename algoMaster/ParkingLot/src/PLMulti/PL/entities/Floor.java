package PLMulti.PL.entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Floor {
    private int floorId;
    private List<Spot> spots;
    public Floor(int id) {
        this.floorId = id;
        this.spots = new ArrayList<Spot>();
    }

    public void addSpot(Spot spot) {
        this.spots.add(spot);
    }
    public Optional<Spot> getSpot(Vehicle vehicle) {
        return  spots.stream().
                filter(spot -> spot.canFit(vehicle) && spot.isAvailable())
                .sorted(Comparator.comparing(Spot::getVehicleType))
                .findFirst();
    }
}
