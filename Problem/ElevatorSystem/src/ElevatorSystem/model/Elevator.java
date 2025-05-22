package ElevatorSystem.model;

import ElevatorSystem.Observer.ElevatorObserver;
import ElevatorSystem.command.ElevatorRequest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Elevator {
    int id;
    int currentFloor;
    Direction direction;
    ElevatorState state;
    Queue<ElevatorRequest> requests;



    List<ElevatorObserver> observers;

    public Elevator(int id){
        this.id = id;
        this.currentFloor = 1;
        this.direction = Direction.UP;
        this.state = ElevatorState.IDLE;
        this.requests = new LinkedList<>();
        this.observers = new ArrayList<>();
    }



    public void addRequest(ElevatorRequest request){
        if(!requests.contains(request)){
            requests.add(request);
        }
        if(this.state == ElevatorState.IDLE){
            if(request.getFloorId() > this.currentFloor){
                this.direction = Direction.UP;
            }else {
                this.direction = Direction.DOWN;

            }
            setState(ElevatorState.MOVING);
        }
    }

    public void moveToNextStop(int nextStop) {
        // Only move if the elevator is currently in the MOVING state
        if (state != ElevatorState.MOVING)
            return;
        while (currentFloor != nextStop) {
            // Update floor based on direction
            if (direction == Direction.UP) {
                currentFloor++;
            } else {
                currentFloor--;
            }
            // Notify observers about the floor change
            notifyFloorChange(currentFloor);
            // Complete arrival once the target floor is reached
            if (currentFloor == nextStop) {
                completeArrival();
                return;
            }
        }
    }


    private void completeArrival() {
        // Stop the elevator and notify observers
        setState(ElevatorState.STOPPED);
        // Remove the current floor from the requests queue

        requests.removeIf(request -> (request.getFloorId() == currentFloor));
        // If no more requests, set state to IDLE
        if (requests.isEmpty()) {
            direction = Direction.IDLE;
            setState(ElevatorState.IDLE);
        } else {
            // Otherwise, continue moving after a brief stop
            setState(ElevatorState.MOVING);
        }
    }



    public Queue<ElevatorRequest> getRequestsQueue() {
        return requests;
    }

    public ElevatorState getState() {
        return state;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getId() {
        return id;
    }

    public void setState(ElevatorState state) {
        this.state = state;
        notifyStateChange(state);
    }





    public void addObserver(ElevatorObserver observer) {
        observers.add(observer);
    }

    // Remove an observer
    public void removeObserver(ElevatorObserver observer) {
        observers.remove(observer);
    }

    // Notify all observers about a state change
    private void notifyStateChange(ElevatorState state) {
        for (ElevatorObserver observer : observers) {
            observer.onElevatorStateChange(this, state);
        }
    }

    // Notify all observers about a floor change
    private void notifyFloorChange(int floor) {
        for (ElevatorObserver observer : observers) {
            observer.onElevatorFloorChange(this, floor);
        }
    }
}
