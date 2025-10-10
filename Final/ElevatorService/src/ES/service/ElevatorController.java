package ES.service;

import ES.enums.Direction;
import ES.enums.RequestType;
import ES.strategy.ElevatorPickStrategy;
import ES.strategy.NearestElevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collector;

public class ElevatorController {
    private static ElevatorController instance;
    private Map<Integer, Elevator> elevators;
    public ElevatorPickStrategy elevatorPickStrategy;
    private final ExecutorService executorService;
    private ElevatorController(int numberOfElevators) {
        this.elevatorPickStrategy = new NearestElevator();
        executorService = Executors.newFixedThreadPool(numberOfElevators);
        this.elevators = new HashMap<>();
        for (int i = 0; i < numberOfElevators; i++) {
            Elevator elevator = new Elevator(i);
            elevators.put(i, elevator);
        }
    }

    public static synchronized ElevatorController getInstance(int numElevators) {
        if (instance == null) {
            instance = new ElevatorController(numElevators);
        }
        return instance;
    }

    public  void start(){
        for(int i=0;i<elevators.size();i++){
            executorService.submit(elevators.get(i));
        }
    }

    public void stop(){
        executorService.shutdown();
    }

    public  void requestLift(int floor, Direction direction){
        Request request = new Request(RequestType.EXTERNAL, floor, direction);
        Optional<Elevator> pickedElevator = elevatorPickStrategy.pickElevator(elevators.values().stream().toList(), request);
        if(pickedElevator.isPresent()){
            Elevator elevator = pickedElevator.get();
            System.out.println("Elevator found: " + elevator.getId() + " which is at "+ elevator.getCurrentFloor() + "  need to travel "+ floor);
            elevator.addRequest(request); // Add the external request to the elevator
        } else{
            System.out.println("No elevator found, please try again");
        }
    }

    public void selectFloor(int elevatorId, int destinationFloor){
        Request request = new Request(RequestType.INTERNAL, destinationFloor, Direction.IDLE);
        Elevator elevator = elevators.get(elevatorId);
        if (elevator != null) {
            elevator.addRequest(request);
            System.out.println("Elevator " + elevator.getId() + " selected to " + destinationFloor);
        } else {
            System.err.println("Invalid elevator ID.");
        }
    }

}
