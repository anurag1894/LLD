package FDS.Resturant;


import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<item> items;
    public Menu() {
        this.items = new ArrayList<item>();
    }

    public void addItem(item item) {
        items.add(item);
    }
    public List<item> getItems() {
        return items;
    }

    public void removeItem(item item) {
        items.remove(item);
    }
}
