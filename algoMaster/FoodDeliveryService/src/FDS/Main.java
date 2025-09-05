package FDS;



import FDS.Resturant.NonVeg;
import FDS.Resturant.Veg;
import FDS.Resturant.item;
import FDS.Service.FoodDeliveryService;
import FDS.paymentStrategy.Card;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FoodDeliveryService service = FoodDeliveryService.getInstance();

        // Add dummy users
        service.add(1, "Alice");
        service.add(2, "Bob");

        // Add dummy delivery persons
        service.addDeliveryPerson(1, "John");
        service.addDeliveryPerson(2, "Mike");

        // Add Restaurants
        service.addRestaurant(100, "GreenLeaf");
        service.addRestaurant(101, "SpicyMeat");

        // Add items to GreenLeaf
        service.addItemInMenu(100, new Veg(1, "Paneer Butter Masala", 200));
        service.addItemInMenu(100, new Veg(2, "Veg Biryani", 180));
        service.addItemInMenu(100, new Veg(3, "Aloo Gobi", 150));
        service.addItemInMenu(100, new NonVeg(4, "Chicken Curry", 250));
        service.addItemInMenu(100, new NonVeg(5, "Mutton Rogan Josh", 300));
        service.addItemInMenu(100, new NonVeg(6, "Fish Fry", 220));

        // Add items to SpicyMeat
        service.addItemInMenu(101, new Veg(7, "Veg Korma", 170));
        service.addItemInMenu(101, new Veg(8, "Mushroom Masala", 190));
        service.addItemInMenu(101, new Veg(9, "Dal Tadka", 130));
        service.addItemInMenu(101, new NonVeg(10, "Butter Chicken", 260));
        service.addItemInMenu(101, new NonVeg(11, "Lamb Chops", 320));
        service.addItemInMenu(101, new NonVeg(12, "Prawn Masala", 280));

        // Start CLI
        while (true) {
            System.out.println("\n========= FOOD DELIVERY MENU =========");
            System.out.println("1. Set Current User");
            System.out.println("2. Show All Restaurants");
            System.out.println("3. Pick Restaurant by ID");
            System.out.println("4. Show Menu");
            System.out.println("5. Add Item to Cart");
            System.out.println("6. Remove Item from Cart");
            System.out.println("7. Place Order");
            System.out.println("8. Make Payment");
            System.out.println("9. Pick Order");
            System.out.println("10. Deliver Order");
            System.out.println("11. Show Order Status");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            System.out.println();
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID (1 for Alice, 2 for Bob): ");
                    int userId = sc.nextInt();
                    service.setCurrentUser(userId);
                    break;

                case 2:
                    service.showAllRestaurants();
                    break;

                case 3:
                    System.out.print("Enter Restaurant ID to pick: ");
                    int restId = sc.nextInt();
                    service.pickRestaurantId(restId);
                    break;

                case 4:
                    service.showAllMenu();
                    break;

                case 5:
                    System.out.print("Enter Item ID to add: ");
                    int addId = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int addQty = sc.nextInt();
                    service.addItem(addId, addQty);
                    break;

                case 6:
                    System.out.print("Enter Item ID to remove: ");
                    int remId = sc.nextInt();
                    System.out.print("Enter Quantity to remove: ");
                    int remQty = sc.nextInt();
                    service.removeItem(remId, remQty);
                    break;

                case 7:
                    service.placeOrder();
                    break;

                case 8:
                    // Dummy strategy object (you must implement a paymentStrategy interface with concrete classes)
                    service.askPaymentStrategy(new Card());
                    service.makePayment();
                    break;

                case 9:
                    service.pickOrder();
                    break;

                case 10:
                    service.delivered();
                    break;

                case 11:
                    service.getOrderStatus();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }
}
