package TomatoFoodDelivery.Code.strategies;

public class UpiPaymentStrategy implements PaymentStrategy {
    private String mobile;

    public UpiPaymentStrategy(String mob) {
        this.mobile = mob;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid RS:" + amount + " using UPI (" + mobile + ")");
    }
}