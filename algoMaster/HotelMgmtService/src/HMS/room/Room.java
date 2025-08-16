package HMS.room;

import HMS.model.RoomType;

public abstract class Room {
    protected int price;
    protected int roomNumber;
    public boolean available;
    Room(int roomNumber){
        this.roomNumber = roomNumber;
        this.available = true;
    }


    public abstract int getPrice();
    public abstract int getRoomNumber();
    public abstract RoomType getType();
    public abstract boolean isAvailable();
}
