package TomatoFoodDelivery.Code.factories;

import java.util.List;

import TomatoFoodDelivery.Code.models.Cart;
import TomatoFoodDelivery.Code.models.DeliveryOrder;
import TomatoFoodDelivery.Code.models.MenuItem;
import TomatoFoodDelivery.Code.models.Order;
import TomatoFoodDelivery.Code.models.PickupOrder;
import TomatoFoodDelivery.Code.models.Restaurant;
import TomatoFoodDelivery.Code.models.User;
import TomatoFoodDelivery.Code.strategies.PaymentStrategy;

public class ScheduledOrderFactory implements OrderFactory {
    private String scheduleTime;

    public ScheduledOrderFactory(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    @Override
    public Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems,
                             PaymentStrategy paymentStrategy, int totalCost, String orderType) {
        Order order = null;

        if (orderType.equals("Delivery")) {
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setUserAddress(user.getAddress());
            order = deliveryOrder;
        } else {
            PickupOrder pickupOrder = new PickupOrder();
            pickupOrder.setRestaurantAddress(restaurant.getAddress());
            order = pickupOrder;
        }

        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setItems(menuItems);
        order.setPaymentStrategy(paymentStrategy);
        order.setScheduled(scheduleTime);
        order.setTotal(totalCost);
        return order;
    }
}
