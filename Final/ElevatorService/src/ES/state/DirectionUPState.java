package ES.state;

import ES.enums.Direction;
import ES.enums.RequestType;
import ES.service.Elevator;
import ES.service.Request;

public class DirectionUPState implements ElevatorState{

    @Override
    public Direction getDirection() {
        return Direction.UP;
    }

    @Override
    public void move(Elevator elevator) {
        if (elevator.getUpRequests().isEmpty()) {
            elevator.setState(new IdleState());
            return;
        }

        Integer nextFloor = elevator.getUpRequests().first();
        elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);

        if (elevator.getCurrentFloor() == nextFloor) {
            System.out.println("Elevator " + elevator.getId() + " stopped at floor up" + nextFloor);
            elevator.getUpRequests().pollFirst();
        }

        if (elevator.getUpRequests().isEmpty()) {
            elevator.setState(new IdleState());
        }
    }

    @Override
    public void addRequest(Request request, Elevator elevator) {
        // Internal requests always get added to the appropriate queue
        if (request.getType() == RequestType.INTERNAL) {
            if (request.getFloor() > elevator.getCurrentFloor()) {
                elevator.getUpRequests().add(request.getFloor());
            } else {
                elevator.getDownRequests().add(request.getFloor());
            }
            return;
        }

        // External requests
        if (request.getDirection() == Direction.UP && request.getFloor() >= elevator.getCurrentFloor()) {
            elevator.getUpRequests().add(request.getFloor());
        } else if (request.getDirection() == Direction.DOWN) {
            elevator.getDownRequests().add(request.getFloor());
        }
    }
}
