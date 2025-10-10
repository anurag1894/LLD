package ES.state;

import ES.enums.Direction;
import ES.service.Elevator;
import ES.service.Request;

public interface ElevatorState {
    public Direction getDirection();
    public void move(Elevator elevator);
    public void addRequest(Request request, Elevator elevator);
}
