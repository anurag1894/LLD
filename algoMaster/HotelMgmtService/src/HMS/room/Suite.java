package HMS.room;

import HMS.model.RoomType;

public class Suite extends Room {
    public Suite(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public int getPrice() {
        return 1500;
    }

    @Override
    public int getRoomNumber() {
        return this.roomNumber;
    }

    @Override
    public RoomType getType() {
        return RoomType.SUITE;
    }

    @Override
    public boolean isAvailable() {
        return this.available;
    }
}
