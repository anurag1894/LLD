package PLMulti.PL.strategy.parking;

import PLMulti.PL.entities.Floor;
import PLMulti.PL.entities.Spot;
import PLMulti.PL.entities.Vehicle;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Thread-safe parking strategy that uses read-write locks for better concurrency
 * Allows multiple readers (spot searches) but exclusive writers (spot allocation)
 */
public class ConcurrentFirstFitStrategy implements ParkingStrategy {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    
    @Override
    public Optional<Spot> findSpot(Vehicle vehicle, List<Floor> floors) {
        // Use read lock for searching - allows multiple threads to search simultaneously
        lock.readLock().lock();
        try {
            return floors.parallelStream()
                    .map(floor -> floor.getSpot(vehicle))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .findFirst();
        } finally {
            lock.readLock().unlock();
        }
    }
}