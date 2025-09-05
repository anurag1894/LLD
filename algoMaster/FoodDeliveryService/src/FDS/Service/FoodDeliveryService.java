package FDS.Service;

import FDS.DeliveryPerson.DeliveryPerson;
import FDS.Resturant.Menu;
import FDS.Resturant.Restaurant;
import FDS.Resturant.item;
import FDS.User.User;
import FDS.constants.DeliveryStatus;
import FDS.paymentStrategy.paymentStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodDeliveryService {
    Map<Integer, User> usersMap;
    Map<Integer, Restaurant> restaurantsMap;
    Map<Integer, DeliveryPerson> deliveryPersonsMap;
    User currentUser;
    int orderId;

    private static final FoodDeliveryService INSTANCE = new FoodDeliveryService();

    private FoodDeliveryService() {
        usersMap = new HashMap<Integer, User>(); // need concurrent  map
        restaurantsMap = new HashMap<>(); // need concurrent  map
        deliveryPersonsMap = new HashMap<>(); // need concurrent  map
        currentUser = null;
        orderId=0;
    }

    public static FoodDeliveryService getInstance() {
        return INSTANCE;
    }

    public void add(int userId, String name){
        User user = new User(userId, name);
        usersMap.put(userId, user);
    }

    public void addRestaurant(int id, String name){
        Restaurant restaurant = new Restaurant(name,id, new Menu());
        restaurantsMap.put(restaurant.getId(), restaurant);
    }

    public void addDeliveryPerson(int id, String name){
        DeliveryPerson deliveryPerson = new DeliveryPerson(id,name);
        deliveryPersonsMap.put(id, deliveryPerson);
    }

    public void setCurrentUser(int userId) {
        currentUser = usersMap.get(userId);
    }

    public void showAllRestaurants(){
        for(Restaurant restaurant : restaurantsMap.values()){
            System.out.println(restaurant.getId() +" "+ restaurant.getName());
        }
    }

    public void pickRestaurantId(int id) {
        currentUser.setRestaurant(id);
    }

    public void addItemInMenu(int restaurantId,item item){
        restaurantsMap.get(restaurantId).addItem(item);
    }
    public void removeItemInMenu(int restaurantId,item item){
        restaurantsMap.get(restaurantId).removeItem(item);
    }

    public void showAllMenu(){
        Menu menu = restaurantsMap.get(currentUser.getRestaurantID()).getMenu();
        for(item item : menu.getItems()){
            System.out.println(item.getId() + " "+item.getName() +" "+item.getPrice());
        }
    }

    public void addItem(int id,int quantity) {
        item item = restaurantsMap
                .get(currentUser.getRestaurantID())
                .getMenu()
                .getItems()
                .stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElse(null);
        currentUser.addItem(item,quantity);
    }

    public void removeItem(int id, int quantity) {
        item item = restaurantsMap
                .get(currentUser.getRestaurantID())
                .getMenu()
                .getItems()
                .stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElse(null);
        currentUser.removeItem(item,quantity);
    }

    public void placeOrder() {
       Order order = new Order(orderId++,currentUser.getCart(), currentUser.getUserID());

       currentUser.addOrder(order);
       currentUser.setCurrentOrder(order);
       System.out.println("Order Created, make payment");

    }
    public void askPaymentStrategy(paymentStrategy paymentStrategy) {
        currentUser.getCurrentOrder().setPaymentStrategy(paymentStrategy);
    }
    public void makePayment() {
        Order order = currentUser.getCurrentOrder();
        order.makePayment();
        restaurantsMap.get(currentUser.getRestaurantID()).addOrder(order);

        for(DeliveryPerson deliveryPerson : deliveryPersonsMap.values()){
            if(deliveryPerson.getDeliveryStatus().equals(DeliveryStatus.AVAILABLE)){
                deliveryPerson.assignOrder(order);
                break;
            }
        }
        System.out.println("Order Placed, check Status");
    }

    public void pickOrder() { // can send deliveryId
        int deliveryGuyId = currentUser.getCurrentOrder().getDeliveryId();
        DeliveryPerson deliveryPerson = deliveryPersonsMap.get(deliveryGuyId);
        deliveryPerson.pickOrder();
        System.out.println("Order Picked !!");
    }

    public void delivered(){ // can send deliveryId
        int deliveryGuyId = currentUser.getCurrentOrder().getDeliveryId();
        DeliveryPerson deliveryPerson = deliveryPersonsMap.get(deliveryGuyId);
        deliveryPerson.delivered();
    }

    public void getOrderStatus(){
        if(currentUser.getCurrentOrder()!=null)
            System.out.println("Order Status :" + currentUser.getCurrentOrder().getStatus());
        else
            System.out.println("No Order has been placed");
    }
}
