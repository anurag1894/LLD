package FDS.DeliveryPerson;

import FDS.Service.Order;
import FDS.constants.DeliveryStatus;
import FDS.constants.OrderStatus;

import java.util.ArrayList;
import java.util.List;

public class DeliveryPerson {
    int id;
    String name;
    List<Order> orderList;
    int totalEarning;
    Order currentOrder;
    DeliveryStatus deliveryStatus;
    public DeliveryPerson(int id, String name) {
        this.id = id;
        this.name = name;
        this.orderList = new ArrayList<>();
        totalEarning = 0;
        this.currentOrder = null;
        deliveryStatus = DeliveryStatus.AVAILABLE;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void assignOrder(Order order) {
        orderList.add(order);
        order.setDeliveryId(this.id);
        deliveryStatus = DeliveryStatus.MOVING_TO_PICK;
        currentOrder = order;
    }
    public void pickOrder() {
        currentOrder.setStatus(OrderStatus.OUT_FOR_DELIVERY);
        totalEarning += 10;
        deliveryStatus = DeliveryStatus.DELIVERING;
    }

    public void delivered() {
        currentOrder.setStatus(OrderStatus.DELIVERED);
        deliveryStatus = DeliveryStatus.AVAILABLE;
        currentOrder = null;

    }
}
