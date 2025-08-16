package HMS.model;

public enum RoomType {
    DELUX,
    PREMIUM,
    SUITE;
    public static RoomType getRoomType(String roomType) {
        switch (roomType) {
            case "DELUX":
                return DELUX;
            case "PREMIUM":
                return PREMIUM;
            case "SUITE":
                return SUITE;
            default:
                return null;
        }
    }
}
