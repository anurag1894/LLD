package ES.service;

import ES.enums.Direction;
import ES.enums.RequestType;

import java.util.UUID;

public class Request {
    String id;
    RequestType type;
    int floor;
    private final Direction direction;
    public Request(RequestType type, int floor, Direction direction) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.floor = floor;
        this.direction = direction;
    }

    public String getId() {
        return id;
    }

    public RequestType getType() {
        return type;
    }

    public int getFloor() {
        return floor;
    }
    public Direction getDirection() {
        return direction;
    }
}
