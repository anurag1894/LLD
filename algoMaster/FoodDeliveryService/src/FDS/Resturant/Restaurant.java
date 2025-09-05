package FDS.Resturant;

import FDS.Service.Order;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private int id;
    Menu menu;
    List<Order> orders;
    public Restaurant(String name, int id, Menu menu) {
        this.name = name;
        this.id = id;
        this.menu = menu;
        this.orders = new ArrayList<>();
    }

    public void addItem(item item) {
        menu.addItem(item);
    }
    public void removeItem(item item) {
        menu.removeItem(item);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    public Menu getMenu() {
        return menu;
    }
    public List<Order> getOrders() {
        return orders;
    }
    public void addOrder(Order order) {
        orders.add(order);
    }
}
