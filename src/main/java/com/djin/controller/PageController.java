package com.djin.controller;

import com.djin.pojo.Restaurant;
import com.djin.pojo.Ticket;
import com.djin.service.RestaurantService;
import com.djin.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

//Go to different pages
@Controller
public class PageController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping(value="/ticketDetail")
    public ModelAndView viewTicketDetail(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String ticketID = request.getParameter("ticketID");
        int id = Integer.parseInt(ticketID);
        Ticket ticket = ticketService.getTicket(id);

        return new ModelAndView("customer/ticketDetail","ticket",ticket);
    }


    @RequestMapping(value="/restaurantDetail")
    public ModelAndView viewRestaurantDetail(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String restaurantID = request.getParameter("restaurantID");
        int id = Integer.parseInt(restaurantID);
        Restaurant restaurant = restaurantService.getRestaurant(id);

        return new ModelAndView("customer/restaurantDetail","restaurant",restaurant);
    }

    @RequestMapping(value="/keywordSearch",method = RequestMethod.POST)
    public ModelAndView searchByKeyword(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String keyword = request.getParameter("keyword_search");
        System.out.println(keyword);

       List<Ticket> ticketSearch_result = ticketService.findTicketByKeyword(keyword);
       List<Restaurant> restaurantSearch_result = restaurantService.findRestaurantByKeyword(keyword);
       request.setAttribute("keyword",keyword);
       request.setAttribute("restaurantSearch_result",restaurantSearch_result);

        return new ModelAndView("customer/ticketSearch_result","ticketSearch_result",ticketSearch_result);
    }

    @RequestMapping(value="/toCenter")
    public String toCenter() {
        return "customer/user_info";
    }

    @RequestMapping(value = "/toLogin")
    public String toLogin(){
        return "customer/login";
    }

    @RequestMapping(value="/toSignup")
    public String toRegister() {
        return "customer/signup";
    }

    @RequestMapping(value = "toLogout")
        public ModelAndView Logout(HttpServletRequest request,HttpServletResponse response) throws Exception{

        HttpSession session = request.getSession();
        session.removeAttribute("currentUser");

        return new ModelAndView("customer/login");

        }


    @RequestMapping(value="/toHome")
    public ModelAndView toHome(HttpServletRequest request,HttpServletResponse response) throws Exception {

        request.setAttribute("currentPage","home");
        return new ModelAndView("../../index","currentPage","home");
    }

    @RequestMapping(value = "/toTickets")
    public ModelAndView browseAllTickets(HttpServletRequest request,HttpServletResponse response) throws Exception{
        List<Ticket> allTickets = ticketService.getAvailTicket();
        request.setAttribute("currentPage","tickets");

        return new ModelAndView("customer/allTickets","allTickets",allTickets);
    }

    @RequestMapping(value = "/sortTickets")
    public ModelAndView sortTickets(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String sortMethod = request.getParameter("sortMethod");
        List<Ticket> allTickets = ticketService.sortTicket(sortMethod);
        request.setAttribute("sortMethod",sortMethod);

        return new ModelAndView("customer/allTickets","allTickets",allTickets);

    }

    @RequestMapping(value="/toRestaurants")
    public ModelAndView toRestaurants(HttpServletRequest request,HttpServletResponse response) throws Exception{
        List<Restaurant> allRestaurants = restaurantService.getAllRestaurant();
        request.setAttribute("currentPage","restaurants");
        return new ModelAndView("customer/allRestaurants","allRestaurants",allRestaurants);
    }

    @RequestMapping(value = "/sortRestaurants")
    public ModelAndView sortRestaurants(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String sortMethod = request.getParameter("sortMethod");
        List<Restaurant> allRestaurants = restaurantService.sortRestaurant(sortMethod);
        request.setAttribute("sortMethod",sortMethod);

        return new ModelAndView("customer/allRestaurants","allRestaurants",allRestaurants);

    }

    @RequestMapping(value="/toTrends")
    public ModelAndView toTrends(HttpServletRequest request,HttpServletResponse response) throws Exception{
        List<Restaurant> topRestaurants = restaurantService.findTopCollection();
        List<Ticket> topSellers = ticketService.findTopCollection();
        Map<String,Object> trends = new HashMap<String,Object>();
        trends.put("topRestaurants",topRestaurants);
        trends.put("topSellers",topSellers);
        request.setAttribute("currentPage","trends");
        return new ModelAndView("customer/trends","trends",trends);
    }

    @RequestMapping(value="/toTrips")
    public ModelAndView toTrips(HttpServletRequest request,HttpServletResponse response) throws Exception{

        List<Ticket> tripList = ticketService.findAllTrips();

        return new ModelAndView("customer/allTrips","tripList",tripList);
    }

    @RequestMapping(value = "/sortTrips")
    public ModelAndView sortTrips(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String sortMethod = request.getParameter("sortMethod");
        List<Ticket> allTickets = ticketService.sortTicket(sortMethod);
        request.setAttribute("sortMethod",sortMethod);

        return new ModelAndView("customer/allTickets","allTickets",allTickets);

    }

    @RequestMapping(value = "/filter")
    public ModelAndView addFilter(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String minPrice = request.getParameter("minPrice");
        String maxPrice = request.getParameter("maxPrice");

        int min_price = 0 ;
        int max_price = 999;

        if(minPrice != null){
            min_price = Integer.parseInt(minPrice);
        }
        if(maxPrice != null){
            max_price = Integer.parseInt(maxPrice);
        }

        if(request.getParameter("category").equals("restaurant")){
            List<Restaurant> allRestaurants = restaurantService.findRestaurantByFilter(min_price,max_price);
            request.setAttribute("minPrice",min_price);
            request.setAttribute("maxPrice",max_price);
            return new ModelAndView("customer/allRestaurants","allRestaurants",allRestaurants);
        }else{
            List<Ticket> allTickets = ticketService.findTicketByFilter(min_price,max_price);
            request.setAttribute("minPrice",min_price);
            request.setAttribute("maxPrice",max_price);
            return new ModelAndView("customer/allTickets","allTickets",allTickets);
        }

    }

    @RequestMapping(value="/tripDetail")
    public ModelAndView tripDetail(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String ticketID = request.getParameter("ticketID");
        int id = Integer.parseInt(ticketID);
        Ticket ticket = ticketService.getTicket(id);

        return new ModelAndView("customer/tripDetail","ticket",ticket);
    }


}
