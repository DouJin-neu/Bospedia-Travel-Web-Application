package com.djin.DAO;

import com.djin.pojo.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RestaurantDAO {

    public void addRestaurant(Restaurant restaurant);

    public void deleteRestaurant(int restaurantID);

    public void updateInfo(int restaurantID, String rIntroduce);

    public List<Restaurant> findRestaurantByCategory(String rCategory);

    public List<Restaurant> findRestaurantByName(String name);

    public List<Restaurant> findRestaurantByKeyword(String keyword);

    public List<Restaurant> getAllRestaurant();

    public Restaurant getRestaurant(int restaurantID);

    public List<Restaurant> findTopCollection();

    public List<Restaurant> sortRestaurant(String sortMethod);

    public List<Restaurant> findRestaurantByFilter(int minPrice, int maxPrice);
}
