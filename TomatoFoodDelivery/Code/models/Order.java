package TomatoFoodDelivery.Code.models;

import java.util.List;

import TomatoFoodDelivery.Code.strategies.PaymentStrategy;

public abstract class Order {
    private static int nextOrderId;
    private int orderId;
    private User user;
    private Restaurant restaurant;
    private List<MenuItem> items;
    private PaymentStrategy paymentStrategy;
    private int totalPrice;
    private String scheduled;

    public Order() {
        this.user = null;
        this.restaurant = null;
        this.paymentStrategy = null;
        this.totalPrice = 0;
        this.scheduled = "";
        this.orderId = ++nextOrderId;
    }

    // payment method
    public boolean processPayment() {
        if (paymentStrategy != null) {
            paymentStrategy.pay(this.totalPrice);
            return true;
        } else {
            System.out.println("Please choose a payment mode first");
            return false;
        }
    }

    public abstract String getType();


    public int getOrderId(){
        return this.orderId;
    }

    public void setUser(User user){
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }

    public void setRestaurant(Restaurant restaurant){
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant(){
        return this.restaurant;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
        totalPrice = 0;
        for(MenuItem item: this.items) {
            totalPrice += item.getPrice();
        }
    }

    public List<MenuItem> getItems(){
        return this.items;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void setScheduled(String s) {
        this.scheduled = s;
    }

    public String getScheduled(){
        return this.scheduled;
    }

    public void setTotal(int total){
        this.totalPrice = total;
    }

    public int getTotal(){
        return this.totalPrice;
    }
}
