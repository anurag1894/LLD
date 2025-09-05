package FDS.Service;

import FDS.Resturant.item;
import FDS.constants.OrderStatus;
import FDS.paymentStrategy.paymentStrategy;

import java.util.ArrayList;
import java.util.List;

public class Order {
    int OrderId;
    int userId;
    int deliveryId;
    int restaurantId;
    List<item> itemList;
    int amount;
    OrderStatus status;
    paymentStrategy paymentMethod;

    public Order(int id,Cart cart,int userId) {
        this.OrderId = id;
        this.userId = userId;
        itemList = cart.getItemList().keySet().stream().toList(); // we are ignoring quantity here
        restaurantId = cart.getRestaurantId();
        amount = cart.getTotalAmount();
        status = OrderStatus.CREATED;
    }

    public void setPaymentStrategy(paymentStrategy paymentStrategy) {
        if (status.equals(OrderStatus.CREATED) || status.equals(OrderStatus.IN_PAYMENT_MODE)) {
            this.paymentMethod = paymentStrategy;
        }
        this.status = OrderStatus.IN_PAYMENT_MODE;
    }

    public void makePayment() {
        if(status.equals(OrderStatus.IN_PAYMENT_MODE)) {
            System.out.println("Total amount has been paid: " + amount);
            paymentMethod.pay();
            status = OrderStatus.ORDERED;
            // notify the restaurant, once he will complete the order he will notify the order.
        }else{
             System.out.println("Order status is " + status +" and payment can not be made");
        }
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }
    public int getDeliveryId() {
        return deliveryId;
    }

}
