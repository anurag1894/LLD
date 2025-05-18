package PizzaTopping;

public class VeggieTopping extends PizzaDecorator{

    VeggieTopping(BasePizza pizza) {
        super(pizza);
    }
    @Override
    public void cooking(){

    }
    @Override
    public int getCost(){
      return this.pizza.getCost()+40;
    }
}
