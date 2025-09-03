package TomatoFoodDelivery.Code.models;

public class PickupOrder extends Order {
    private String restaurantAddress;

    public PickupOrder() {
        this.restaurantAddress = "";
    }

    @Override
    public String getType() {
        return "Pickup";
    }

    public void setRestaurantAddress(String address) {
        this.restaurantAddress = address;
    }

    public String getRestaurantAddress() {
        return this.restaurantAddress;
    }

}