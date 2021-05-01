package com.djin.service.Impl;

import com.djin.DAO.FavoriteDAO;
import com.djin.pojo.Favorite;
import com.djin.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("favoriteService")
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    FavoriteDAO favoriteDAO;


    @Override
    public void addFavorite(Favorite favorite) {
        favoriteDAO.addFavorite(favorite);
    }

    @Override
    public void deleteFavorite(Favorite favorite) {
        favoriteDAO.deleteFavorite(favorite);
    }

    @Override
    public void updateCollection(String ticketID, String restaurantID) {
        favoriteDAO.updateCollection(ticketID, restaurantID);
    }

    @Override
    public List<Favorite> findFavoriteByUserID(int userID) {
        return favoriteDAO.findFavoriteByUserID(userID);
    }

    @Override
    public List<Favorite> findFavoriteByFilter(String keyword, String minPrice, String maxPrice,int userID) {
        return favoriteDAO.findFavoriteByFilter(keyword, minPrice, maxPrice, userID);
    }

    @Override
    public Favorite findFavoriteByUserIDAndTicketID(int userID, int ticketID) {
        return favoriteDAO.findFavoriteByUserIDAndTicketID(userID, ticketID);
    }

    @Override
    public Favorite findFavoriteByUserIDAndRestaurantID(int userID, int restaurantID) {
        return favoriteDAO.findFavoriteByUserIDAndRestaurantID(userID, restaurantID);
    }

    @Override
    public List<Favorite> sortFavorite(String sortMethod, int userID) {
        return favoriteDAO.sortFavorite(sortMethod, userID);
    }


}
