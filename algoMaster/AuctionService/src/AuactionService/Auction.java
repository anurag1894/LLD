package AuactionService;

import java.util.ArrayList;
import java.util.List;

public class Auction implements AuctionSubject{

    User seller;
    Item item;
    List<Bid> bids;
    User buyer;
    AuctionState auctionState;
    List<AuctionObserver> auctionObservers;

    public Auction(Item item, User seller) {
        bids = new ArrayList<Bid>();
        auctionObservers = new ArrayList();
        auctionState = AuctionState.IDLE;
        this.item = item;
        this.seller = seller;
    }


    @Override
    public void registerObserver(AuctionObserver observer) {
        auctionObservers.add(observer);
    }

    @Override
    public void removeObserver(AuctionObserver observer) {
        auctionObservers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (AuctionObserver observer : auctionObservers) {
            observer.update();
        }
    }

    public void addBid(Bid bid) {
        bids.add(bid);
        registerObserver(bid.user);
        notifyObservers();
    }

    public User winner(){
        int price = item.getStartingPrice();
        for (Bid bid : bids) {
            if(bid.getBidPrice() >= price){
                price = bid.getBidPrice();
                buyer = bid.getUser();
            }
        }
        this.auctionState = AuctionState.COMPLETED;
        return buyer;
    }

    public void setState(AuctionState auctionState) {
        this.auctionState = auctionState;
    }


}
