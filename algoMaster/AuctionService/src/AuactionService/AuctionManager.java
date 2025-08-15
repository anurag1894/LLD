package AuactionService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuctionManager {
    List<User> users;
    List<Item> items;
    List<Auction> auctionList;
    Map<Item, Auction> auctionMap;
    Map<Integer,User> userMap;
    Auction currentAuction;
    Map<Integer,Item> itemMap;
    public static AuctionManager auctionManager;


    public static AuctionManager getInstance() {
        if(auctionManager == null){
            auctionManager = new AuctionManager();
        }
        return auctionManager;
    }

    private AuctionManager() {
        users = new ArrayList<User>();
        items = new ArrayList<>();
        auctionList = new ArrayList<>();
        auctionMap = new HashMap<Item, Auction>();
        itemMap = new HashMap<>();
        userMap = new HashMap<>();
        currentAuction = null;
    }

    public void addUser(User user) {
        users.add(user);
        userMap.put(user.getId(), user);
    }
    public void addItem(Item item, User user) {
        items.add(item);
        itemMap.put(item.itemId, item);
        addAuction(item, user);
    }
    private void addAuction(Item item, User user) {
        if(!auctionMap.containsKey(item)) {
            Auction auction = new Auction(item, user);
            auctionMap.put(item, auction);
            auctionList.add(auction);

        }

    }

    public boolean startAuction(int itemId) {
        Item item = itemMap.get(itemId);
       if(!auctionMap.get(item).auctionState.equals(AuctionState.IDLE)) {
            System.out.println(" NOT in IDLE state , state is "+ auctionMap.get(item).auctionState );
            return false;
        }
        currentAuction = auctionMap.get(item);
        System.out.println("Starting the auction for item "+ currentAuction.item.itemName +  " with id "+ currentAuction.item.itemId + " with price "+ item.startingPrice);
        currentAuction.setState(AuctionState.IN_PROGRESS);
        return true;
    }

    public void addBid(int userId,int price){
        User user = userMap.get(userId);
        Bid bid = new Bid(user,price, System.currentTimeMillis());
        currentAuction.addBid(bid);
    }

    public User getWinner(){
       User user = currentAuction.winner();
       currentAuction = null;
       return user;
    }

    public void showItem(){
        for(Item item : items){
            System.out.println(item.getItemId() + "  of name " + item.itemName + " with starting price "+ item.startingPrice);
        }
    }
}
