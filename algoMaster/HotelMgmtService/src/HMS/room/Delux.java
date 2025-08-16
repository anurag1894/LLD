package HMS.room;

import HMS.model.RoomType;

public class Delux extends Room {
    public Delux(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public int getPrice() {
        return 1000;
    }

    @Override
    public int getRoomNumber() {
        return this.roomNumber;
    }

    @Override
    public RoomType getType() {
        return RoomType.DELUX;
    }
    @Override
    public boolean isAvailable() {
        return this.available;
    }
}
