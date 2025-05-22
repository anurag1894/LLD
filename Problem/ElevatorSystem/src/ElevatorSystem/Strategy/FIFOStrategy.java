package ElevatorSystem.Strategy;

import ElevatorSystem.model.Elevator;

public class FIFOStrategy implements schedulingStrategy {
    @Override
    public int scheduling(Elevator elevator) {
        System.out.println(elevator.getId() + " scheduled for FIFO");
        return  5;
    }
}
