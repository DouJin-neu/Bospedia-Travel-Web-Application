package com.djin.service;

import com.djin.pojo.Favorite;

import java.util.List;

public interface FavoriteService {

    public void addFavorite(Favorite favorite);

    public void deleteFavorite(Favorite favorite);

    public void updateCollection(String ticketID, String restaurantID);

    public List<Favorite> findFavoriteByUserID(int userID);

    public List<Favorite> findFavoriteByFilter(String keyword,String minPrice, String maxPrice, int userID);

    public Favorite findFavoriteByUserIDAndTicketID(int userID, int ticketID);

    public Favorite findFavoriteByUserIDAndRestaurantID(int userID, int restaurantID);

    public List<Favorite> sortFavorite(String sortMethod, int userID);
}
