package AMS.model;

public class Seat {
    int seatID;
    boolean isAvailable;
    int amount;

    public Seat(int seatID, int amount) {
        this.seatID = seatID;
        this.amount = amount;
        this.isAvailable = true;
    }
    public int getSeatID() {
        return seatID;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public int getAmount() {
        return amount;
    }

    public void setAvailable(){
        isAvailable = false;
    }
}
