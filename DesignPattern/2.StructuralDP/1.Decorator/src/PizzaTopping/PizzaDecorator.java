package PizzaTopping;

public class PizzaDecorator implements BasePizza{
    BasePizza pizza;
    PizzaDecorator(BasePizza pizza){
        this.pizza=pizza;
    }

    @Override
    public void cooking() {
        this.cooking();
    }

    @Override
    public int getCost() {
        return this.pizza.getCost();
    }
}
