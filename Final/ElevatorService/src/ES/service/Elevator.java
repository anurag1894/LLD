package ES.service;

import ES.enums.Direction;
import ES.state.ElevatorState;
import ES.state.IdleState;

import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class Elevator implements Runnable{
    int id;
    ElevatorState state;
    boolean isRunning;
    AtomicInteger currentFloor;
    TreeSet<Integer> upRequests;
    TreeSet<Integer> downRequests;

    public Elevator(int id) {
        this.id = id;
        currentFloor = new AtomicInteger(0);
        upRequests = new TreeSet<Integer>();
        downRequests = new TreeSet<Integer>();
        isRunning = true; // Start the elevator thread
        state = new IdleState();
    }

    public void addRequest(Request request) {
        state.addRequest(request, this);
    }

    public Direction getDirection() {
        return state.getDirection();
    }

    public void move(){
        state.move(this);
    }

    public TreeSet<Integer> getUpRequests() { return upRequests; }
    public TreeSet<Integer> getDownRequests() { return downRequests; }
    public boolean isRunning() { return isRunning; }
    public void stopElevator() { this.isRunning = false; }
    public void setState(ElevatorState state) { this.state = state; }

    public int getCurrentFloor() { return currentFloor.get(); }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor.set(currentFloor);
    }

    public int getId() {
        return id;
    }

    @Override
    public void run() {
        while (isRunning) {
            move();
            try {
                Thread.sleep(1000); // Simulate movement time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                isRunning = false;
            }
        }
    }
}
