package FDS.Resturant;

public abstract class item {
    int id;
    String name;
    int price;
    public item(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public abstract boolean isVeg();
    public abstract int getPrice();
    public abstract String getName();
    public abstract int getId();
}
