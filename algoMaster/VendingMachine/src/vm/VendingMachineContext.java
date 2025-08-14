package vm;

import vm.model.Coin;
import vm.model.Product;
import vm.state.DispenseState;
import vm.state.HasCashVendingState;
import vm.state.IdleMachineState;
import vm.state.VendingMachineState;


import java.util.HashMap;

import java.util.Map;

public class VendingMachineContext {
    static VendingMachineContext vendingMachineContext;
    Inventory inventory;
    VendingMachineState currentState;
    Map<Coin, Integer> coins;
    Product currentProduct;

    private VendingMachineContext(){
        inventory = Inventory.getInstance();
        currentState = new IdleMachineState();
        coins = new HashMap<>();
        currentProduct = null;
    }

    // Singleton
    public static VendingMachineContext getInstance(){
        if(vendingMachineContext == null){
            vendingMachineContext = new VendingMachineContext();
        }
        return vendingMachineContext;
    }

    public void addInInventory(int productCode, int quantity, String itemName, int price){
        inventory.addItem(productCode, quantity, itemName, price);
    }


    public void showInventory(){
       inventory.showItems();
    }

    public boolean pickItem(int productCode){
        if(currentState instanceof IdleMachineState){
            if(inventory.isItemAvailable(productCode)) {

                currentProduct = inventory.getItem(productCode);

                System.out.println(currentProduct.getName() + " has been picked.");
                System.out.println(currentProduct.getName() + " has price " + currentProduct.getPrice());
                System.out.println("Please pay!!");

                updateState();

                return true;
            } else{
                updateState();
                System.out.println("No item available");
                return false;
            }
        }   else{
            System.out.println(currentState.toString() + " is not IdleMachineState");
            return false;
        }
    }

    public void addCoin(Coin coin, int quantity){
        if(currentState instanceof HasCashVendingState) {
            coins.put(coin, coins.getOrDefault(coin, 0) + quantity);
            System.out.println(coin.toString() + " has been added to the cash "+ quantity);
            if(currentProduct.getPrice() <= getTotalCash()){
                updateState();
                System.out.println("Total payment completed " + getTotalCash());
                return ;
            }
            System.out.println("Total cash is now " + getTotalCash());
        } else {
           System.out.println(currentState.toString() + " is not HasCashVendingState");
        }
    }

    public boolean paymentComplete(){
        if(currentState instanceof HasCashVendingState){
            int totalCash = getTotalCash();
            if(totalCash < currentProduct.getPrice()){
                System.out.println("Please pay more $" + (currentProduct.getPrice() -totalCash));
                return false;
            } else {
                updateState();
                return true;
            }
        } else if(currentState instanceof DispenseState) {
            System.out.println("Already paid for " + currentProduct.getName());
            return true;
        } else {
            System.out.println(currentState.toString() + " is not HasCashVendingState");
            return false;
        }
    }

    public boolean dispenseItem(){
        if(currentState instanceof DispenseState){

            System.out.println(currentProduct.getName() + " has been dispensed.");
            inventory.dispenseItem(currentProduct.getId());
            reset();
            return true;

        } else {
            System.out.println(currentState.toString() + " is not HasCashVendingState");
            return false;
        }
    }

    private int getTotalCash(){
        int totalCash = 0;
        for(Coin coin : coins.keySet()){
            totalCash += coins.get(coin)*coin.getValue();
        }
        return totalCash;
    }

   private void updateState(){
        currentState.next(this);
   }

   public void reset(){
        currentState = new IdleMachineState();
        coins.clear();
        currentProduct = null;
   }

    public Product getCurrentProduct(){
        return currentProduct;
    }

    public void setCurrentState(VendingMachineState currentState){
        this.currentState =  currentState;
    }
}
