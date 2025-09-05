package FDS.Resturant;

public class NonVeg extends item{
    public NonVeg(int id,String name, int price) {
        super(id,name,price);
    }

    @Override
    public boolean isVeg() {
        return false;
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
