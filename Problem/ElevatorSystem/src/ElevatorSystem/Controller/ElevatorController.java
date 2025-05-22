package ElevatorSystem.Controller;

import ElevatorSystem.Strategy.schedulingStrategy;
import ElevatorSystem.command.ElevatorRequest;
import ElevatorSystem.model.Direction;
import ElevatorSystem.model.Elevator;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    private List<Elevator> elevatorList;
    private List<Integer> floorList;
    private schedulingStrategy schedulingStrategy;

    public ElevatorController(int floorCount, int elevatorCount) {
        elevatorList = new ArrayList<>(elevatorCount);
        floorList = new ArrayList<>(floorCount);
        for (int i = 0; i < elevatorCount; i++) {
            elevatorList.add(new Elevator(i));
        }
        for (int i = 0; i < floorCount; i++) {
            floorList.add(i);
        }

    }

    public void setSchedulingStrategy(schedulingStrategy schedulingStrategy) {
        this.schedulingStrategy = schedulingStrategy;
    }

    public void requestElevator(int floorNumber, int elevatorId, Direction direction) {
        System.out.println(
                "External request: Floor " + floorNumber + ", Direction " + direction);
        // Find the elevator by its ID
        Elevator selectedElevator = getElevatorById(elevatorId);
        if (selectedElevator != null) {
            // Add the request to the selected elevator
            selectedElevator.addRequest(
                    new ElevatorRequest(this,elevatorId, floorNumber,false, direction));
            System.out.println("Assigned elevator " + selectedElevator.getId()
                    + " to floor " + floorNumber);
        } else {
            // If no suitable elevator is found
            System.out.println("No elevator available for floor " + floorNumber);
        }

    }

    public void requestFloor(int floorNumber, int elevatorId) {

        Elevator elevator = getElevatorById(elevatorId);
        System.out.println("Internal request: Elevator " + elevator.getId()
                + " to floor " + floorNumber);
        // Determine the direction of the request
        Direction direction = floorNumber > elevator.getCurrentFloor()
                ? Direction.UP
                : Direction.DOWN;
        // Add the request to the elevator
        elevator.addRequest(
                new ElevatorRequest(this,elevatorId, floorNumber, true, direction));
    }

    public void step() {
        // Iterate through all elevators
        for (Elevator elevator : elevatorList) {
            // Only process elevators with pending requests
            if (!elevator.getRequestsQueue().isEmpty()) {
                // Use the scheduling strategy to find the next stop
                int nextStop = schedulingStrategy.scheduling(elevator);
                System.out.println(nextStop);
                // Move the elevator to the next stop if needed
                if (elevator.getCurrentFloor() != nextStop)
                    elevator.moveToNextStop(nextStop);
            }
        }
    }




    private Elevator getElevatorById(int elevatorId) {
        for (Elevator elevator : elevatorList) {
            if (elevator.getId() == elevatorId) {
                return elevator;
            }
        }
        return null;
    }

    public List<Elevator> getElevatorList() {
        return elevatorList;
    }
}
