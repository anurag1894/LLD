package HMS.room;

import HMS.model.RoomType;

public  class Premium extends Room {
    public Premium(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public int getPrice() {
        return 2000;
    }

    @Override
    public int getRoomNumber() {
        return this.roomNumber;
    }

    @Override
    public RoomType getType() {
        return RoomType.PREMIUM;
    }

    @Override
    public boolean isAvailable() {
        return this.available;
    }

}
