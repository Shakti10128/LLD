package TomatoFoodDelivery.Code.models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static int nextRestaurantId;
    private int restaurantId;
    private String name;
    private String address;
    private List<MenuItem> menu = new ArrayList<>();

    public Restaurant(String name,String address) {
        this.name = name;
        this.address = address;
        this.restaurantId = ++nextRestaurantId;
    }

    public int getRestaurantId(){
        return this.restaurantId;
    }

    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public String getAddress(){
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addMenuItem(MenuItem item){
        this.menu.add(item);
    }

    public List<MenuItem> getMenu(){
        return this.menu;
    }
}
