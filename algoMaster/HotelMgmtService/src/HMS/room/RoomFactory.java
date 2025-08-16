package HMS.room;

import HMS.model.RoomType;

public class RoomFactory {
    public static int deluxRoom = 0;
    public static int premiumRoom = 0;
    public static int suiteRoom = 0;
    public static Room createRoom(RoomType roomType) {

        switch (roomType) {
            case RoomType.DELUX:
                deluxRoom++;
                return deluxRoom < 10 ? new Delux(deluxRoom): null;
            case RoomType.PREMIUM:
                premiumRoom++;
                return premiumRoom<5 ?  new Premium(premiumRoom) : null;
            case RoomType.SUITE:
                suiteRoom++;
                return suiteRoom < 8?  new Suite(suiteRoom) : null;
            default: return null;
        }
    }

}
