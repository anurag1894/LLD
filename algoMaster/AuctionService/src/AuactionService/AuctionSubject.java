package AuactionService;

public interface AuctionSubject {
    public void registerObserver(AuctionObserver observer);
    public void removeObserver(AuctionObserver observer);
    public void notifyObservers();
}
