package FDS.Resturant;

public class Veg extends item {
    public Veg(int id, String name, int price){
        super(id,name,price);
    }

    @Override
    public boolean isVeg() {
        return true;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public int getId() {
        return this.id;
    }
}
