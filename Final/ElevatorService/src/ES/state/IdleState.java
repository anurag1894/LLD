package ES.state;

import ES.enums.Direction;
import ES.service.Elevator;
import ES.service.Request;

public class IdleState implements ElevatorState{
    @Override
    public Direction getDirection() {
        return Direction.IDLE;
    }

    @Override
    public void move(Elevator elevator) {
        if (!elevator.getUpRequests().isEmpty()) {
            elevator.setState(new DirectionUPState());
        } else if (!elevator.getDownRequests().isEmpty()) {
            elevator.setState(new DirectionDOWNState());
        }
    }

    @Override
    public void addRequest(Request request, Elevator elevator) {
        if (request.getFloor() > elevator.getCurrentFloor()) {
            elevator.getUpRequests().add(request.getFloor());
        } else if (request.getFloor() < elevator.getCurrentFloor()) {
            elevator.getDownRequests().add(request.getFloor());
        }
    }
}
