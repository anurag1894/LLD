package ES.strategy;

import ES.service.Elevator;
import ES.service.Request;

import java.util.List;
import java.util.Optional;

public interface ElevatorPickStrategy {
     Optional<Elevator> pickElevator(List<Elevator> elevators, Request request);
}
