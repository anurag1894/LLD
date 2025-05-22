package ElevatorSystem.command;

import ElevatorSystem.Controller.ElevatorController;
import ElevatorSystem.model.Direction;
import ElevatorSystem.model.Elevator;

public class ElevatorRequest implements ICommand{
    private ElevatorController elevatorController;
    private int elevatorID;
    private int floorId;
    private boolean isInternal;
    private Direction direction;

    public ElevatorRequest(ElevatorController elevatorController,int elevatorID, int floorId, boolean isInternal, Direction direction) {
        this.elevatorController = elevatorController;
        this.elevatorID = elevatorID;
        this.floorId = floorId;
        this.isInternal = isInternal;
        this.direction = direction;
    }

    @Override
    public void execute() {
        if (isInternal) {
            elevatorController.requestElevator(floorId,elevatorID,direction);
        }else{
            elevatorController.requestFloor(floorId,elevatorID);
        }
    }

    public int getElevatorID() {
        return elevatorID;
    }
    public int getFloorId() {
        return floorId;
    }

    public boolean isInternal() {
        return isInternal;
    }
}
