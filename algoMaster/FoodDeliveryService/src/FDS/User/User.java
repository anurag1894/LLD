package FDS.User;

import FDS.Resturant.item;
import FDS.Service.Cart;
import FDS.Service.Order;

import java.util.ArrayList;
import java.util.List;

public class User {
    int userID;
    String userName;
    List<Order> orders;
    Cart cart;
    Order currentOrder;

    public User(int userID, String userName) {
        this.userID = userID;
        this.userName = userName;
        this.orders = new ArrayList<>();
        this.cart = new Cart(userID);
        this.currentOrder = null;
    }

    public int getUserID() {
        return userID;
    }
    public List<Order> getOrders() {
        return orders;
    }
    public void addOrder(Order order) {
        orders.add(order);
    }

    public void addItem(item items, int quantity) {
        cart.addItem(items,quantity);
    }
    public void removeItem(item items, int quantity) {
        cart.removeItem(items,quantity);
    }

    public void resetCart() {
        cart.clearCart();
    }

    public void setRestaurant(int restaurantID) {
        cart.setRestaurantId(restaurantID);
    }

    public int getRestaurantID() {
        return cart.getRestaurantId();
    }
    public Cart getCart() {
        return cart;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }
    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }
}
