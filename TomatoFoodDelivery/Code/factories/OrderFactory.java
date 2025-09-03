package TomatoFoodDelivery.Code.factories;

import java.util.List;

import TomatoFoodDelivery.Code.models.Cart;
import TomatoFoodDelivery.Code.models.MenuItem;
import TomatoFoodDelivery.Code.models.Order;
import TomatoFoodDelivery.Code.models.Restaurant;
import TomatoFoodDelivery.Code.models.User;
import TomatoFoodDelivery.Code.strategies.PaymentStrategy;


// you might think why createOrder taking lot of parameter's
// it depends on your use case, 
// i don't want to be let to create order to know everything about the user, like what user have
// so that's why passing individually to create order, you might have diff strategy

public interface OrderFactory {
    Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems,
                      PaymentStrategy paymentStrategy, int totalCost, String orderType);
}