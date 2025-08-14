package model;

import enums.Cash;

import java.util.HashMap;
import java.util.Map;

public class ATMInventory {
    private static ATMInventory atmInventory;
    Map<Cash, Integer> inventory;
    private ATMInventory() {
        inventory = new HashMap<>();
        inventory.put(Cash.TENS,100);
        inventory.put(Cash.HUNDRED,50);
        inventory.put(Cash.THOUSAND,10);
        inventory.put(Cash.FIVE_HUNDRED,25);
    }

    public synchronized static ATMInventory getInstance() {
        if(atmInventory == null)
             atmInventory = new ATMInventory();
        return atmInventory;
    }

    public void addCash(Cash cash, int amount) {
        inventory.put(cash, amount);
    }
    public Map<Cash, Integer> withdrawCash(int amount) {
        Map<Cash, Integer> dispensedCash = new HashMap<>();
        if(amount >1000){
            if(amount/1000 >0){
                dispensedCash.put(Cash.THOUSAND, amount/1000);
            }
            inventory.put(Cash.THOUSAND, inventory.get(Cash.THOUSAND)-amount%1000);
            amount = amount- (amount/1000)*1000;  // 1800 / 500 = 3 , 300 , 300/200 = 1, 100
        }
        if(amount > 500){
            if(amount/500 >0){
                dispensedCash.put(Cash.FIVE_HUNDRED, amount/500);
            }
            inventory.put(Cash.FIVE_HUNDRED, inventory.get(Cash.FIVE_HUNDRED)-amount%500);
            amount = amount-(amount/500)*500;
        }
        if(amount > 100) {
            if(amount/100 >0){
                dispensedCash.put(Cash.HUNDRED, amount/100);
            }
            inventory.put(Cash.HUNDRED, inventory.get(Cash.HUNDRED) - amount % 100);
            amount = amount - (amount / 100)*100;
        }
        if(amount > 10) {
            if(amount/10 >0){
                dispensedCash.put(Cash.TENS, amount/10);
            }
            inventory.put(Cash.TENS, inventory.get(Cash.TENS) - amount % 10);
            amount = amount - (amount /10)*10;
        }
        if(amount > 0) {
            // Rollback the transaction
            for (Map.Entry<Cash, Integer> entry : dispensedCash.entrySet()) {
                inventory.put(entry.getKey(),
                        inventory.get(entry.getKey()) + entry.getValue());
            }
            return null;
        }
        return dispensedCash;
    }

    public boolean hasSufficientCash(int amount) {
        return inventory.entrySet().stream().mapToInt(e -> e.getValue() *e.getKey().amount).sum() >= amount;
    }
}
