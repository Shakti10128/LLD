package TomatoFoodDelivery.Code.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import TomatoFoodDelivery.Code.models.Restaurant;

public class RestaurantManager {
    List<Restaurant> restaurants = new ArrayList<>();
    private static RestaurantManager instance = null;

    private RestaurantManager(){
        // private constructor
    }

    public static RestaurantManager getInstance(){
        if(instance == null){
            instance = new RestaurantManager();
        }
        return instance;
    }

    public void addRestaurant(Restaurant restaurant){
        this.restaurants.add(restaurant);
    }

    public void deleteRestaurant(Restaurant restaurant){
        this.restaurants.remove(restaurant);
    }

    public List<Restaurant> searchByLocation(String address){
        List<Restaurant> nearByRestaurants = this.restaurants.stream().
                                             filter((restaurants)-> restaurants.getAddress()
                                            .equals(address))
                                            .collect(Collectors.toList());

        return nearByRestaurants;
    }
}
