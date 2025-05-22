package ElevatorSystem;

import ElevatorSystem.Controller.ElevatorController;
import ElevatorSystem.Observer.ElevatorDisplay;
import ElevatorSystem.Strategy.FIFOStrategy;
import ElevatorSystem.Strategy.ScanStrategy;
import ElevatorSystem.model.Building;
import ElevatorSystem.model.Direction;
import ElevatorSystem.model.Elevator;

public class Main {
    public static void main(String[] args) {

        Building building = new Building("Office Tower", 10, 3);
        ElevatorController controller = building.getElevatorController();
        // Create an ElevatorDisplay to observe and display elevator events
        ElevatorDisplay display = new ElevatorDisplay();
        for (Elevator elevator : controller.getElevatorList()) {
            elevator.addObserver(display); // Add the display as an observer for all elevators
        }


        int floorNum = 5;

        Direction dir =  Direction.UP;
        controller.requestElevator(floorNum,2,dir);



        System.out.print("Enter elevator ID: \n");
        int elevatorId = 2;
        System.out.print("Enter destination floor: \n");
        int destFloor = 8;
        controller.requestFloor(destFloor, elevatorId);

        System.out.println("Select strategy:\n");
        System.out.println("1. SCAN Algorithm\n");
        System.out.println("2. FCFS Algorithm\n");
        System.out.println("3. Look Algorithm\n");
        int strategyChoice = 1;
        // We can sue factory here
        if (strategyChoice == 1) {
            controller.setSchedulingStrategy(new ScanStrategy());
            System.out.println("Strategy set to SCAN Algorithm");
        } else {
            controller.setSchedulingStrategy(new FIFOStrategy());
            System.out.println("Strategy set to FIFO Algorithm\n");
        }
        controller.step();
    }
}
