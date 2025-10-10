package ES.strategy;

import ES.enums.Direction;
import ES.service.Elevator;
import ES.service.Request;

import java.util.List;
import java.util.Optional;

public class NearestElevator implements    ElevatorPickStrategy{

    @Override
    public Optional<Elevator> pickElevator(List<Elevator> elevators, Request request) {
        Elevator bestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            if (isSuitable(elevator, request)) {
                int distance = Math.abs(elevator.getCurrentFloor() - request.getFloor());
                if (distance < minDistance) {
                    minDistance = distance;
                    bestElevator = elevator;
                }
            }
        }
        return Optional.ofNullable(bestElevator);
    }

    private boolean isSuitable(Elevator elevator, Request request) {
        if (elevator.getDirection() == Direction.IDLE)
            return true;
        if (elevator.getDirection() == request.getDirection()) {
            if (request.getDirection() == Direction.UP && elevator.getCurrentFloor() <= request.getFloor())
                return true;
            if (request.getDirection() == Direction.DOWN && elevator.getCurrentFloor() >= request.getFloor())
                return true;
        }
        return false;
    }
}
