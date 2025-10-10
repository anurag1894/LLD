package ES.state;

import ES.enums.Direction;
import ES.enums.RequestType;
import ES.service.Elevator;
import ES.service.Request;

public class DirectionDOWNState implements ElevatorState{

    @Override
    public Direction getDirection() {
        return Direction.DOWN;
    }

    @Override
    public void move(Elevator elevator) {
        if (elevator.getDownRequests().isEmpty()) {
            elevator.setState(new IdleState());
            return;
        }

        Integer nextFloor = elevator.getDownRequests().first();
        elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);

        if (elevator.getCurrentFloor() == nextFloor) {
            System.out.println("Elevator " + elevator.getId() + " stopped at floor down" + nextFloor);
            elevator.getDownRequests().pollFirst();
        }

        if (elevator.getDownRequests().isEmpty()) {
            elevator.setState(new IdleState());
        }
    }

    @Override
    public void addRequest(Request request, Elevator elevator) {
        if (request.getType() == RequestType.INTERNAL) {
            if (request.getFloor() > elevator.getCurrentFloor()) {
                elevator.getUpRequests().add(request.getFloor());
            } else {
                elevator.getDownRequests().add(request.getFloor());
            }
            return;
        }

        // External requests
        if (request.getDirection() == Direction.DOWN && request.getFloor() <= elevator.getCurrentFloor()) {
            elevator.getDownRequests().add(request.getFloor());
        } else if (request.getDirection() == Direction.UP) {
            elevator.getUpRequests().add(request.getFloor());
        }
    }
}
