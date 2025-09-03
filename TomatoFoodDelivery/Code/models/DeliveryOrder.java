package TomatoFoodDelivery.Code.models;

public class DeliveryOrder extends Order {
    private String userAddress;

    public DeliveryOrder() {
        this.userAddress = "";
    }

    @Override
    public String getType() {
        return "Delivery";
    }

    public void setUserAddress(String address) {
        this.userAddress = address;
    }

    public String getUserAddress() {
        return this.userAddress;
    }
}