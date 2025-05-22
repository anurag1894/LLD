package ElevatorSystem.Observer;

import ElevatorSystem.model.Elevator;
import ElevatorSystem.model.ElevatorState;

public interface ElevatorObserver {
    void onElevatorStateChange(Elevator elevator, ElevatorState state);
    void onElevatorFloorChange(Elevator elevator, int floor);
}
