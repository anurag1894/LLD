package FDS.Service;

import FDS.Resturant.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    int userId;
    int restaurantId;
    Map<item,Integer> itemList;
    int totalAmount;

    public Cart(int userId) {
        this.userId = userId;
       this.itemList = new HashMap<>();
       this.totalAmount = 0;
       this.restaurantId = -1;
    }

    public void addItem(item item,int quantity) {
        itemList.put(item, itemList.getOrDefault(item,0) + quantity);
        totalAmount += item.getPrice()*quantity;
    }

    public void removeItem(item item,int quantity) {
        if(itemList.containsKey(item)) {
            if(itemList.get(item)==quantity) {
                itemList.remove(item);
            } else{
                itemList.put(item, itemList.get(item) - quantity);
            }
            totalAmount -= item.getPrice()*quantity;
        }
    }

    public void clearCart() {
        itemList.clear();
        totalAmount = 0;
        restaurantId =  -1;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public Map<item,Integer> getItemList() {
        return itemList;
    }

    public int getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

}
