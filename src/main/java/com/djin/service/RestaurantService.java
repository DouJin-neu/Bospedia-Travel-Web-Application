package com.djin.service;

import com.djin.pojo.Restaurant;
import com.djin.pojo.Ticket;

import java.util.List;

public interface RestaurantService {

    public void addRestaurant(Restaurant restaurant);

    public void deleteRestaurant(int restaurantID);

    public void updateInfo(int restaurantID, String rIntroduce);

    public List<Restaurant> findRestaurantByCategory(String rCategory);

    public List<Restaurant> findRestaurantByName(String name);

    public List<Restaurant> getAllRestaurant();

    public Restaurant getRestaurant(int restaurantID);

    public List<Restaurant> findTopCollection();

    public List<Restaurant> findRestaurantByKeyword(String keyword);

    public List<Restaurant> sortRestaurant(String sortMethod);

    public List<Restaurant> findRestaurantByFilter(int minPrice, int maxPrice);
}
