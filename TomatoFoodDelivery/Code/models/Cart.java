package TomatoFoodDelivery.Code.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Restaurant restaurant;
    private List<MenuItem> items = new ArrayList<>();

    public Cart(){
        this.restaurant = null;
    }

    public void addItem(MenuItem item) {
        if(restaurant == null) {
            System.out.println("Cart: set a restaurant before adding items");
        }

        this.items.add(item);
    }

    public int getTotalCost(){
        int totalPrice = 0;
        for(MenuItem item: this.items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public boolean isEmpty(){
        return (this.restaurant == null || this.items.isEmpty());
    }

    public void clear(){
        this.items.clear();
        this.restaurant = null;
    }

    // Getter and Setter
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant(){
        return this.restaurant;
    }

    public List<MenuItem> getItems(){
        return this.items;
    }
}
