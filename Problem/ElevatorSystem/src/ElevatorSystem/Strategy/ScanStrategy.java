package ElevatorSystem.Strategy;

import ElevatorSystem.model.Elevator;

public class ScanStrategy implements schedulingStrategy{
    @Override
    public int scheduling(Elevator elevator) {
        System.out.println(elevator.getId() + " schedule with scan strategy");
        return 8;
    }
}
