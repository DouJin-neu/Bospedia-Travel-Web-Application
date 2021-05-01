package com.djin.controller;

import com.djin.pojo.Favorite;
import com.djin.pojo.Restaurant;
import com.djin.pojo.Ticket;
import com.djin.pojo.User;
import com.djin.service.FavoriteService;
import com.djin.service.RestaurantService;
import com.djin.service.TicketService;
import com.djin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class FavoriteController {

    @Autowired
    FavoriteService favoriteService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;

    @RequestMapping(value="/toMyFavorite")
    public ModelAndView toMyFavorite(HttpServletRequest request, HttpServletResponse response) throws Exception{

        User currentUser = (User)request.getSession().getAttribute("currentUser");
        int userID =  currentUser.getUserID();

        List<Favorite> favoriteList = favoriteService.findFavoriteByUserID(userID);

        for(int i = 0; i < favoriteList.size(); i++) {
            if (favoriteList.get(i).getRestaurantID() == 0) {
                Ticket ticket = ticketService.getTicket(favoriteList.get(i).getTicketID());
                favoriteList.get(i).setTicket(ticket);
            } else if (favoriteList.get(i).getTicketID() == 0) {
                Restaurant restaurant = restaurantService.getRestaurant(favoriteList.get(i).getRestaurantID());
                favoriteList.get(i).setRestaurant(restaurant);
            }
        }

        HttpSession session = request.getSession();
        session.setAttribute("favoriteList",favoriteList);

        return new ModelAndView("customer/myFavorite","favoriteList",favoriteList);
    }

    @ResponseBody
    @RequestMapping(value = "/addToFavorite")
    public String addToFavorite(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String ajaxResponse = "";
        Favorite favorite = new Favorite();
        String category = request.getParameter("category");
        System.out.println(category);
        String userID = request.getParameter("userID");
        User currentUser = userService.getUser(Integer.parseInt(userID));
        favorite.setUser(currentUser);


        if(category.equals("restaurant")){

            String restaurantID = request.getParameter("restaurantID");

            Restaurant restaurant = restaurantService.getRestaurant(Integer.parseInt(restaurantID));
            favorite.setRestaurant(restaurant);

            favorite.setRestaurantID(Integer.parseInt(restaurantID));
            favorite.setUserID(Integer.parseInt(userID));
            favorite.setCollectedDate(new Date());
            favorite.setTicketID(0);

            favoriteService.addFavorite(favorite);

            favoriteService.updateCollection("0",restaurantID);

            request.setAttribute("status",true);

            ajaxResponse = "Restaurant Saved";
        }else if(category.equals("ticket")){
            String ticketID = request.getParameter("ticketID");

            Ticket ticket = ticketService.getTicket(Integer.parseInt(ticketID));

            favorite.setTicketID(Integer.parseInt(ticketID));
            favorite.setUserID(Integer.parseInt(userID));
            favorite.setCollectedDate(new Date());
            favorite.setRestaurantID(0);

            favorite.setTicket(ticket);
            System.out.println(ticket.getTicketName());

            favoriteService.addFavorite(favorite);

            favoriteService.updateCollection(ticketID,"0");

            request.setAttribute("status",true);

            ajaxResponse = "Ticket Saved";
        }

        return ajaxResponse;
    }

    @ResponseBody
    @RequestMapping(value="/cancelFavorite")
    public String cancelFavorite(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String status = "";
            String userID= request.getParameter("userID");
            String ticketID = request.getParameter("ticketID");
            String restaurantID = request.getParameter("restaurantID");
            int uid = Integer.parseInt(userID);

            Favorite favorite = null;
            try{
                if(ticketID == null){
                    //it's restaurant
                    int rid = Integer.parseInt(restaurantID);
                    favorite = favoriteService.findFavoriteByUserIDAndRestaurantID(uid,rid);
                    status="deleted"+favorite.getRestaurantID();

                }else if(restaurantID == null){
                    //it's ticket

                    int tid = Integer.parseInt(ticketID);
                    favorite = favoriteService.findFavoriteByUserIDAndTicketID(uid,tid);
                    status="deleted "+favorite.getTicketID();
                }

                favoriteService.deleteFavorite(favorite);

            }catch(Exception e){
                e.printStackTrace();
            }

            request.setAttribute("status",false);

            return status;
    }

    @RequestMapping(value = "/filterFavorite")
    public ModelAndView addFilter(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String favorite_search_keyword = request.getParameter("favorite_search_keyword");
        String minPrice = request.getParameter("minPrice");
        String maxPrice = request.getParameter("maxPrice");
        String userID = request.getParameter("userID");
        int id = Integer.parseInt(userID);


        List<Favorite> favoriteList = favoriteService.findFavoriteByFilter(favorite_search_keyword,minPrice,maxPrice,id);

        for(Favorite favorite : favoriteList){
            if (favorite.getRestaurantID() == 0) {
                Ticket ticket = ticketService.getTicket(favorite.getTicketID());
                favorite.setTicket(ticket);
            } else if (favorite.getTicketID() == 0) {
                Restaurant restaurant = restaurantService.getRestaurant(favorite.getRestaurantID());
                favorite.setRestaurant(restaurant);
            }
        }


        return new ModelAndView("customer/myFavorite","favoriteList",favoriteList);
    }

    @RequestMapping(value = "/sortFavorite")
    public ModelAndView sortFavorite(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String sortMethod = request.getParameter("sortMethod");
        String userID = request.getParameter("userID");
        int id = Integer.parseInt(userID);

        List<Favorite> favoriteList = favoriteService.sortFavorite(sortMethod,id);

        for(Favorite favorite : favoriteList){
            if (favorite.getRestaurantID() == 0) {
                Ticket ticket = ticketService.getTicket(favorite.getTicketID());
                favorite.setTicket(ticket);
            } else if (favorite.getTicketID() == 0) {
                Restaurant restaurant = restaurantService.getRestaurant(favorite.getRestaurantID());
                favorite.setRestaurant(restaurant);
            }
        }
        request.setAttribute("sortMethod",sortMethod);
        return new ModelAndView("customer/myFavorite","favoriteList",favoriteList);

    }
}
