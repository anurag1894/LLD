package PizzaTopping;

public class PizzaShopMain {
    public static void main(String[] args) {
        BasePizza farmhouseWithExtraChesee = new cheseetopping(new Farmhouse());
        System.out.println(farmhouseWithExtraChesee.getCost() + " Cost of farmhouse With Extra Chesee ");

        BasePizza VeggieWithExtraChesee = new cheseetopping(new Veggie());
        System.out.println(VeggieWithExtraChesee.getCost() + " Cost of veggie With Extra Chesee ");

        BasePizza VeggieWithExtraveggie = new VeggieTopping(new Veggie());
        System.out.println(VeggieWithExtraveggie.getCost() + " Cost of veggie With Extra veggie ");

        BasePizza farmhouseWithExtraVeg = new VeggieTopping(new Farmhouse());
        System.out.println(farmhouseWithExtraVeg.getCost() + " Cost of farmhouse With Extra veggie ");


        BasePizza farmhouseWithExtraVegAndExtraChesse = new cheseetopping(new VeggieTopping(new Farmhouse()));
        System.out.println(farmhouseWithExtraVegAndExtraChesse.getCost() + " Cost of farmhouse With Extra veggie and chesee ");

    }
}
