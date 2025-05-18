package PizzaTopping;

public class cheseetopping extends PizzaDecorator{
    cheseetopping(BasePizza pizza) {
        super(pizza);
    }
    @Override
    public void cooking(){

    }

    @Override
    public int getCost(){
        return this.pizza.getCost()+25;
    }

}
