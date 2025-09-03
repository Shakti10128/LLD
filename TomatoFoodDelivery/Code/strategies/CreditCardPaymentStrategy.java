package TomatoFoodDelivery.Code.strategies;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPaymentStrategy(String card) {
        this.cardNumber = card;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid RS:" + amount + " using Credit Card (" + cardNumber + ")");
    }
}