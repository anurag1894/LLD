package ES;

import ES.enums.Direction;
import ES.service.ElevatorController;

public class ESDemo {
    public static void main(String[] args) {
        System.out.println("=== Elevator Service Demo ===\n");
        
        // Initialize elevator controller with 3 elevators
        ElevatorController controller = ElevatorController.getInstance(2);
        
        // Start the elevator service
        System.out.println("Starting elevator service with 3 elevators...");
        controller.start();
        
        try {
            // Give some time for elevators to initialize
            Thread.sleep(1000);
            
            System.out.println("\n--- Demo Scenario 1: External Requests ---");
            
            // Simulate external requests (people calling elevators)
            System.out.println("Person at floor 5 wants to go UP:");
            controller.requestLift(5, Direction.UP);
            Thread.sleep(500);

            System.out.println("Person in elevator 0 selects floor 10:");
            controller.selectFloor(0, 10);
            Thread.sleep(500);


            System.out.println("\nPerson at floor 8 wants to go DOWN:");
            controller.requestLift(8, Direction.DOWN);
            Thread.sleep(500);

            System.out.println("Person in elevator 1 selects floor 2:");
            controller.selectFloor(1, 2);
            Thread.sleep(500);
            
            System.out.println("\nPerson at floor 3 wants to go UP:");
            controller.requestLift(3, Direction.UP);
            Thread.sleep(500);
            
            System.out.println("\n--- Demo Scenario 2: Internal Requests ---");
            
            // Simulate internal requests (people selecting floors inside elevators)


            
            System.out.println("Person in elevator 2 selects floor 7:");
            controller.selectFloor(0, 7);
            Thread.sleep(500);
            
//            System.out.println("\n--- Demo Scenario 3: Multiple Requests ---");
//
//            // Simulate rush hour with multiple requests
//            System.out.println("Rush hour simulation - multiple requests:");
//            controller.requestLift(1, Direction.UP);
//            Thread.sleep(200);
//            controller.requestLift(9, Direction.DOWN);
//           Thread.sleep(200);
//            controller.selectFloor(0, 15);
//            Thread.sleep(200);
//            controller.requestLift(6, Direction.UP);
//            Thread.sleep(200);
//            controller.selectFloor(1, 4);
//
            // Let the elevators process requests for a while
            System.out.println("\nLetting elevators process requests...");
            Thread.sleep(30000);
            
            System.out.println("\n--- Demo Scenario 4: Edge Cases ---");
            
            // Test invalid elevator ID
            System.out.println("Testing invalid elevator ID (99):");
            controller.selectFloor(99, 5);
            
            Thread.sleep(1000);
            
        } catch (InterruptedException e) {
            System.err.println("Demo interrupted: " + e.getMessage());
        } finally {
            // Clean shutdown
            System.out.println("\n=== Demo Complete ===");
            System.out.println("Shutting down elevator service...");
            controller.stop();
            System.out.println("Elevator service stopped.");
        }
    }
}
