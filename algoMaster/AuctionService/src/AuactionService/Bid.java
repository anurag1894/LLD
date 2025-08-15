package AuactionService;

public class Bid {

    User user;
    int bidPrice;
    long time;

    public Bid(User user, int bidPrice, long time) {

        this.user = user;
        this.bidPrice = bidPrice;
        this.time = time;

    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(int bidPrice) {
        this.bidPrice = bidPrice;
    }

    public long getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
