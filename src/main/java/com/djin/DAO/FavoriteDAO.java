package com.djin.DAO;

import com.djin.pojo.Favorite;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FavoriteDAO {

    public void addFavorite(Favorite favorite);

    public void deleteFavorite(Favorite favorite);

    public void updateCollection(String ticketID, String restaurantID);

    public List<Favorite> findFavoriteByUserID(int userID);

    public List<Favorite> findFavoriteByFilter(String keyword,String minPrice, String maxPrice, int userID);

    public List<Favorite> sortFavorite(String sortMethod, int userID);

    public Favorite findFavoriteByUserIDAndTicketID(int userID, int ticketID);

    public Favorite findFavoriteByUserIDAndRestaurantID(int userID, int restaurantID);

}
