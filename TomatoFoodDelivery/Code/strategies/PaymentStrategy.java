package TomatoFoodDelivery.Code.strategies;


// assume we're using 3rd party payment service
public interface PaymentStrategy {
    void pay(int amount);
}