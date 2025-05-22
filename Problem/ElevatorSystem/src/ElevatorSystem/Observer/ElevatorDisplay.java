package ElevatorSystem.Observer;

import ElevatorSystem.model.Elevator;
import ElevatorSystem.model.ElevatorState;

import java.util.Observable;
import java.util.Observer;

public class ElevatorDisplay implements ElevatorObserver {


    @Override
    public void onElevatorStateChange(Elevator elevator, ElevatorState state) {
        System.out.println("Elevator " + elevator.getId() + " is "+ state.toString() + " on " + elevator.getCurrentFloor());
    }

    @Override
    public void onElevatorFloorChange(Elevator elevator, int floor) {
        System.out.println("Elevator " + elevator.getId() + " at " + floor);
    }
}
