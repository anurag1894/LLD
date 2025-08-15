package AuactionService;

public class Item {
    int itemId;
    int startingPrice;
    String itemName;

    public Item(int itemId, int startingPrice, String itemName) {
        this.itemId = itemId;
        this.startingPrice = startingPrice;
        this.itemName = itemName;
    }

    public int getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(int startingPrice) {
        this.startingPrice = startingPrice;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

}
