package com.djin.service.Impl;

import com.djin.DAO.RestaurantDAO;
import com.djin.pojo.Restaurant;
import com.djin.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("restaurantService")
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantDAO restaurantDAO;

    public void setRestaurantDAO(RestaurantDAO restaurantDAO){
        this.restaurantDAO = restaurantDAO;
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        restaurantDAO.addRestaurant(restaurant);
    }

    @Override
    public void deleteRestaurant(int restaurantID) {

        restaurantDAO.deleteRestaurant(restaurantID);
    }

    @Override
    public void updateInfo(int restaurantID, String rIntroduce) {
        restaurantDAO.updateInfo(restaurantID, rIntroduce);
    }

    @Override
    public List<Restaurant> findRestaurantByCategory(String rCategory) {
        return restaurantDAO.findRestaurantByCategory(rCategory);
    }

    @Override
    public List<Restaurant> findRestaurantByName(String name) {
        return restaurantDAO.findRestaurantByName(name);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantDAO.getAllRestaurant();
    }

    @Override
    public Restaurant getRestaurant(int restaurantID) {
        return restaurantDAO.getRestaurant(restaurantID);
    }

    @Override
    public List<Restaurant> findTopCollection() {
        return restaurantDAO.findTopCollection();
    }

    @Override
    public List<Restaurant> findRestaurantByKeyword(String keyword) {
        return restaurantDAO.findRestaurantByKeyword(keyword);
    }

    @Override
    public List<Restaurant> sortRestaurant(String sortMethod) {
        return restaurantDAO.sortRestaurant(sortMethod);
    }

    @Override
    public List<Restaurant> findRestaurantByFilter(int minPrice, int maxPrice) {
        return restaurantDAO.findRestaurantByFilter(minPrice, maxPrice);
    }
}
