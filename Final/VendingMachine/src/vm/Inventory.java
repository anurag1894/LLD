package vm;

import vm.model.Product;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    static Inventory inventory;
    Map<Product, Integer> item;
    Map<Integer, Product> productMap;
    public static Inventory getInstance() {
        if(inventory == null) {
            inventory = new Inventory();
        }
        return inventory;
    }

    private Inventory() {
        item = new HashMap<>();
        productMap = new HashMap<>();
    }

    public boolean isItemAvailable(int productCode) {
      return item.get(productMap.get(productCode))!=0;
    }

    public boolean addItem(int productCode, int quantity, String itemName, int price) {
        Product product = new Product(productCode,itemName,price,true);
        productMap.put(productCode, product);
        item.put(product,item.getOrDefault(product,0)+quantity);
        return true;
    }

    public void showItems(){
        for(Map.Entry<Product, Integer> entry : item.entrySet()) {
            if(entry.getKey().isAvailable()) {
                System.out.println(entry.getKey().getName() + " " + entry.getKey().getId() + " " + entry.getKey().getPrice());
            } else {
                System.out.println(entry.getKey().getName() + " " + entry.getKey().getId() + " " + entry.getKey().getPrice()+ " but not available");
            }
        }
    }

    public Product getItem(int productCode) {
        return productMap.get(productCode);
    }
    public void dispenseItem(int productID){
        Product product = productMap.get(productID);
        item.put(product,item.getOrDefault(product,0)-1);
        if(item.get(product) == 0)
            product.setAvailable(false);
    }


}
