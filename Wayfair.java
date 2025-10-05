import java.util.*;

// ------------------ STRATEGY ----------------------
interface ChargeStrategy {
    double calculateTransport(double volume);
    double calculateService(double weight, double distance);
}

class StandardChargeStrategy implements ChargeStrategy {
    public double calculateTransport(double volume) { return 0.5 * volume; }
    public double calculateService(double weight, double distance) { return 0.5 * weight + 0.5 * distance; }
}

class HazardousChargeStrategy implements ChargeStrategy {
    public double calculateTransport(double volume) { return 0.75 * volume; }
    public double calculateService(double weight, double distance) { return 0.75 * weight + 0.75 * distance; }
}

class FragileChargeStrategy implements ChargeStrategy {
    public double calculateTransport(double volume) { return 0.625 * volume; }
    public double calculateService(double weight, double distance) { return 0.625 * weight + 0.625 * distance; }
}

// ------------------ FACTORY ----------------------
class ChargeStrategyFactory {
    public static ChargeStrategy getStrategy(String type) {
        switch (type.toLowerCase()) {
            case "standard": return new StandardChargeStrategy();
            case "hazardous": return new HazardousChargeStrategy();
            case "fragile":   return new FragileChargeStrategy();
            default: throw new IllegalArgumentException("Unknown package type: " + type);
        }
    }
}

// ------------------ INTERFACES ----------------------
interface IPackage {
    double calculateTransportCharge();
    double calculateServiceCharge();
}

interface IShipment {
    void insert(IPackage pkg);
    void remove(int id);
    Map<String, Double> getTotalCosts();
    List<IPackage> getPackages();
}

// ------------------ PACKAGE IMPLEMENTATION ----------------------
class Package implements IPackage {
    private int id;
    private String type;
    private double weight, height, width, length, distance;
    private ChargeStrategy strategy;

    public Package(int id, String type, double weight, double height, double width, double length, double distance) {
        this.id = id;
        this.type = type;
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.length = length;
        this.distance = distance;
        this.strategy = ChargeStrategyFactory.getStrategy(type);
    }

    private double getVolume() { return height * width * length; }


    @Override
    public double calculateTransportCharge() {
        return strategy.calculateTransport(getVolume());
    }

    @Override
    public double calculateServiceCharge() {
        return strategy.calculateService(weight, distance);
    }
}

// ------------------ CARGO IMPLEMENTATION ----------------------
class Cargo implements IShipment {
    private List<IPackage> packages = new ArrayList<>();

    @Override
    public void insert(IPackage pkg) { packages.add(pkg); }

    @Override
    public void remove(int id) { packages.removeIf(pkg -> pkg.getId() == id); }

    @Override
    public Map<String, Double> getTotalCosts() {
        double totalTransport = 0, totalService = 0;
        for (IPackage pkg : packages) {
            totalTransport += pkg.calculateTransportCharge();
            totalService += pkg.calculateServiceCharge();
        }
        Map<String, Double> totals = new HashMap<>();
        totals.put("TotalTransportCharges", totalTransport);
        totals.put("TotalServiceCharges", totalService);
        return totals;
    }

    @Override
    public List<IPackage> getPackages() { return packages; }
}

// ------------------ DEMO ----------------------
public class ShipmentDemo {
    public static void main(String[] args) {
        Cargo cargo = new Cargo();

        IPackage p1 = new Package(1, "Standard", 10, 2, 3, 4, 100);
        IPackage p2 = new Package(2, "Hazardous", 20, 3, 3, 3, 150);
        IPackage p3 = new Package(3, "Fragile", 5, 1, 2, 2, 50);

        cargo.insert(p1);
        cargo.insert(p2);
        cargo.insert(p3);

        // Print packages
        for (IPackage pkg : cargo.getPackages()) {
            System.out.println(pkg);
        }

        // Print totals
        System.out.println("Total Costs: " + cargo.getTotalCosts());
    }
}












2. Coupon Category Problem

import java.time.LocalDate;
import java.util.*;

// --- Coupon class ---

class Coupon {
    private final String id;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public Coupon(String id, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public boolean isValidOn(LocalDate date) {
        return (date.isAfter(startDate) || date.isEqual(startDate)) &&
               (date.isBefore(endDate) || date.isEqual(endDate));
    }
}

// --- Core service ---

class CouponCategoryService {
    private final Map<String, String> parent = new HashMap<>();                // child → parent
    private final Map<String, List<Coupon>> couponsByCategory = new HashMap<>(); // category → coupons

    // Set parent for a child category
    public void addCategory(String parentCategory, String childCategory) {
        parent.put(childCategory, parentCategory);
    }

    // Add coupon to a specific category
    public void addCoupon(String category, Coupon coupon) {
        couponsByCategory.computeIfAbsent(category, k -> new ArrayList<>()).add(coupon);
    }

    // Get coupons valid for a category (include parent categories)
    public List<Coupon> getCoupons(String category, LocalDate queryDate) {
        List<Coupon> result = new ArrayList<>();
        String current = category;

        // Walk up to the root
        while (current != null) {
            List<Coupon> list = couponsByCategory.get(current);
            if (list != null) {
                for (Coupon c : list) {
                    if (c.isValidOn(queryDate)) {
                        result.add(c);
                    }
                }
            }
            current = parent.get(current); // move to parent
        }
        return result;
    }
}

// --- Demo / Main ---

public class CouponCategoryDemo {
    public static void main(String[] args) {
        CouponCategoryService service = new CouponCategoryService();

        // Build category tree (child → parent links)
        service.addCategory("Electronics", "Laptops");
        service.addCategory("Electronics", "Phones");
        service.addCategory("Phones", "Android");
        service.addCategory("Phones", "iOS");

        // Add coupons
        service.addCoupon("Electronics",
            new Coupon("C1", LocalDate.of(2025,1,1), LocalDate.of(2025,12,31)));
        service.addCoupon("Laptops",
            new Coupon("C2", LocalDate.of(2025,1,1), LocalDate.of(2025,3,31)));
        service.addCoupon("Phones",
            new Coupon("C3", LocalDate.of(2025,6,1), LocalDate.of(2025,9,30)));
        service.addCoupon("iOS",
            new Coupon("C4", LocalDate.of(2025,1,1), LocalDate.of(2025,12,31)));

        // Query: coupons valid for "iOS" on 2025-08-20
        List<Coupon> result = service.getCoupons("iOS", LocalDate.of(2025,8,20));

        System.out.println("Coupons valid for iOS on 2025-08-20:");
        for (Coupon c : result) {
            System.out.println(c.getId());
        }
    }
}


--------------------------------------------------







3. Coupon Category Problem down ward

import java.time.LocalDate;
import java.util.*;

// --- Coupon class ---
class Coupon {
    private final String id;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public Coupon(String id, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public boolean isValidOn(LocalDate date) {
        return (date.isAfter(startDate) || date.isEqual(startDate)) &&
               (date.isBefore(endDate) || date.isEqual(endDate));
    }
}

// --- Core service ---
class CouponCategoryService {
    private final Map<String, List<String>> categoryTree = new HashMap<>();   // parent → children
    private final Map<String, List<Coupon>> couponsByCategory = new HashMap<>(); // category → coupons

    public void addCategory(String parent, String child) {
        if (!categoryTree.containsKey(parent)) {
            categoryTree.put(parent, new ArrayList<>());
        }
        categoryTree.get(parent).add(child);
    }

    public void addCoupon(String category, Coupon coupon) {
        if (!couponsByCategory.containsKey(category)) {
            couponsByCategory.put(category, new ArrayList<>());
        }
        couponsByCategory.get(category).add(coupon);
    }

    public List<Coupon> getCoupons(String category, LocalDate queryDate) {
        // 1. Collect all categories under this node
        Set<String> allCategories = new HashSet<>();
        dfs(category, allCategories);

        // 2. Collect all valid coupons
        List<Coupon> result = new ArrayList<>();
        for (String cat : allCategories) {
            if (couponsByCategory.containsKey(cat)) {
                List<Coupon> couponList = couponsByCategory.get(cat);
                for (Coupon c : couponList) {
                    if (c.isValidOn(queryDate)) {
                        result.add(c);
                    }
                }
            }
        }
        return result;
    }

    private void dfs(String category, Set<String> visited) {
        visited.add(category);
        if (!categoryTree.containsKey(category)) return;
        for (String child : categoryTree.get(category)) {
            if (!visited.contains(child)) {
                dfs(child, visited);
            }
        }
    }
}

// --- Demo / Main ---
public class CouponCategoryDemo {
    public static void main(String[] args) {
        CouponCategoryService service = new CouponCategoryService();

        // Build category tree
        service.addCategory("Electronics", "Laptops");
        service.addCategory("Electronics", "Phones");
        service.addCategory("Phones", "Android");
        service.addCategory("Phones", "iOS");

        // Add coupons
        service.addCoupon("Electronics",
            new Coupon("C1", LocalDate.of(2025,1,1), LocalDate.of(2025,12,31)));
        service.addCoupon("Laptops",
            new Coupon("C2", LocalDate.of(2025,1,1), LocalDate.of(2025,3,31)));
        service.addCoupon("Phones",
            new Coupon("C3", LocalDate.of(2025,6,1), LocalDate.of(2025,9,30)));
        service.addCoupon("iOS",
            new Coupon("C4", LocalDate.of(2025,1,1), LocalDate.of(2025,12,31)));

        // Query: coupons valid for "Phones" on 2025-08-20
        List<Coupon> result = service.getCoupons("Phones", LocalDate.of(2025,8,20));

        System.out.println("Coupons valid for Phones on 2025-08-20:");
        for (Coupon c : result) {
            System.out.println(c.getId());
        }
    }
}







4. Order Bill with different discount strategies


import java.util.*;

// Abstract Class
abstract class Order {
    private final int amount;
    public Order(int amount) {
        this.amount = amount;
    }
    
    public int getAmount() {
        this.display(amount);
        return this.amount;
    }
    
    abstract void display(int amount);
    abstract double getDiscountedPrice();  // 👈 each subclass implements this
}

// Concrete Classes
class LowCostOrder extends Order {
    public LowCostOrder(int amount) { super(amount); }
    @Override
    public void display(int amount) {
        System.out.println("low cost bill: " + amount);
    }
    @Override
    public double getDiscountedPrice() {
        return 20; // flat discount logic
    }
}

class MediumCostOrder extends Order {
    public MediumCostOrder(int amount) { super(amount); }
    @Override
    public void display(int amount) {
        System.out.println("medium cost bill: " + amount);
    }
    @Override
    public double getDiscountedPrice() {
        return getAmount() * 0.8; // 20% discount
    }
}

class HighCostOrder extends Order {
    public HighCostOrder(int amount) { super(amount); }
    @Override
    public void display(int amount) {
        System.out.println("high cost bill: " + amount);
    }
    @Override
    public double getDiscountedPrice() {
        return getAmount() * 0.7; // 30% discount
    }
}

// Factory
class OrderFactory {
    public static Order getOrder(int amount) {
        if(amount < 40) return new LowCostOrder(amount);
        else if(amount < 100) return new MediumCostOrder(amount);
        else return new HighCostOrder(amount);
    }
}

// OrderBill
class OrderBill {
    private List<Order> orders = new ArrayList<>();
    public void addOrder(Order order) { orders.add(order); }
    public double getBill() {
        double amount = 0;
        for (Order order : orders) {
            amount += order.getDiscountedPrice();
        }
        return amount;
    }
}

// Demo
public class Main {
    public static void main(String[] args) {
        OrderBill bill = new OrderBill();
        bill.addOrder(OrderFactory.getOrder(35));
        bill.addOrder(OrderFactory.getOrder(75));
        bill.addOrder(OrderFactory.getOrder(150));
        
        System.out.println("Final Bill: " + bill.getBill());
    }
}








5. Shopping Cart with different discount strategies

------------

import java.util.*;

class Product {
    private final String id;
    private final String name;
    private final double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}

class CartItem {
    private final Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getItemTotal() { return product.getPrice() * quantity; }
}

interface DiscountStrategy {
    double applyDiscount(double total);
}

class PercentageDiscount implements DiscountStrategy {
    private final double percent;
    public PercentageDiscount(double percent) { this.percent = percent; }
    public double applyDiscount(double total) {
        return total * (1 - percent/100.0);
    }
}

class Cart {
    private final Map<String, CartItem> items = new HashMap<>();
    private DiscountStrategy discount;

    public void addItem(Product product, int qty) {
        if (qty <= 0) {
            throw new IllegalArgumentException("Quantity must be > 0");
        }
        String productId = product.getId();
        CartItem item = items.get(productId);
        if (item == null) {
            items.put(productId, new CartItem(product, qty));
        } else {
            item.setQuantity(item.getQuantity() + qty);
        }
    }

    public void removeItem(String productId) {
        items.remove(productId);
    }

    public void updateItemQuantity(String productId, int qty) {
        if (items.containsKey(productId))
            items.get(productId).setQuantity(qty);
    }

    public void applyDiscount(DiscountStrategy discount) {
        this.discount = discount;
    }

    public double calculateTotal() {
        double subtotal = items.values()
                               .stream()
                               .mapToDouble(CartItem::getItemTotal)
                               .sum();
        return discount != null ? discount.applyDiscount(subtotal) : subtotal;
    }

    public Collection<CartItem> getItems() { return items.values(); }
}

class Order {
    private static int idCounter = 1;
    private final int orderId;
    private final List<CartItem> items;
    private final double finalAmount;

    public Order(Collection<CartItem> items, double finalAmount) {
        this.orderId = idCounter++;
        this.items = new ArrayList<>(items);
        this.finalAmount = finalAmount;
    }

    public void printBill() {
        System.out.println("Order ID: " + orderId);
        items.forEach(item -> 
            System.out.println(item.getProduct().getName() + " x" + item.getQuantity() 
            + " = " + item.getItemTotal())
        );
        System.out.println("Final Amount: " + finalAmount);
    }
}

public class ShoppingCartDemo {
    public static void main(String[] args) {
        Product laptop = new Product("P1", "Laptop", 50000);
        Product mouse = new Product("P2", "Mouse", 500);

        Cart cart = new Cart();
        cart.addItem(laptop, 2);
        cart.addItem(mouse, 1);
        cart.updateItemQuantity("P1", 1);  // update quantity

        cart.applyDiscount(new PercentageDiscount(20)); // 20% off entire cart
        double total = cart.calculateTotal();

        Order order = new Order(cart.getItems(), total);
        order.printBill();
    }
}



-----------------------

1. Transportaion problem

Package - L , B, H , W -> dist 
   Standard  -> 0.5 * volume , 0.5 * weight + 0.5 * distance
   Fragile -> 0.625 * volume , 0.625 * weight + 0.625 * distance
   Hazardous -> 0.75 * volume , 0.75 * weight + 0.75 * distance

   Cargo -> List of packages  Calculate transportation charge and service charge

Solution 

IProduct  -> calculateTransportCharge() , calculateServiceCharge()
IShipment -> insert(IPackage pkg) , remove(int id) , getTotalCosts() , getPackages()

Product. -> Iproduct 
Cargo -> IShipment
