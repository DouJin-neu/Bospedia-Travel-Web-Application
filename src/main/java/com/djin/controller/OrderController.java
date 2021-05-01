package com.djin.controller;

import com.djin.pojo.*;
import com.djin.service.OrderService;
import com.djin.service.RestaurantService;
import com.djin.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Set;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    TicketService ticketService;

    @RequestMapping(value ="/placeOrder", method = RequestMethod.POST)
    public ModelAndView placeOrder(HttpServletRequest request, HttpServletResponse response) throws Exception{

        String ticketID = request.getParameter("ticketID");
        String restaurantID = request.getParameter("restaurantID");
        String userID = request.getParameter("userID");
        String selectedDate = request.getParameter("selectedDate");
        String selectedTime = request.getParameter("selectedTime");
        String amount = request.getParameter("number");
        String totalPrice = request.getParameter("totalPrice");
        String category = request.getParameter("orderCategory");
        int categoryID = Integer.parseInt(category);
        String party = request.getParameter("number");
        String contact = request.getParameter("contact");
        Date orderDate = new Date();
        System.out.println(amount);

        Order order = new Order();
        User user = (User) request.getSession().getAttribute("currentUser");
        order.setUser(user);
        if(categoryID == 1){ //restaurant
            order.setItemID(Integer.parseInt(restaurantID));
            order.setUserID(Integer.parseInt(userID));
            order.setSelectedDate(selectedDate);
            order.setSelectedTime(selectedTime);
            order.setParty(Integer.parseInt(party));
            order.setContact(contact);
            order.setOrderDate(orderDate);
            order.setModifyDate(orderDate);
            order.setOrderStatus("pending");
            order.setOrderCategory(categoryID);
            user.getOrderSet().add(order);

        }else if(categoryID == 2){
            order.setItemID(Integer.parseInt(ticketID));
            order.setUserID(Integer.parseInt(userID));
            order.setSelectedDate(selectedDate);
            order.setSelectedTime(selectedTime);
            order.setItemAmount(Integer.parseInt(amount));
            order.setTotalPrice(Double.parseDouble(totalPrice));
            order.setOrderDate(orderDate);
            order.setModifyDate(orderDate);
            order.setOrderStatus("pending");
            order.setOrderCategory(categoryID);
            user.getOrderSet().add(order);
        }

        orderService.addOrder(order);

        return new ModelAndView("customer/placeOrder_success","order",order);
    }

    @RequestMapping(value ="/toOrderHistory", method = RequestMethod.GET)
    public ModelAndView toOrderHistory(HttpServletRequest request, HttpServletResponse response) throws Exception{

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("currentUser");
        Set<Order> orderHistory =  user.getOrderSet();

        return new ModelAndView("customer/orderHistory","orderHistory",orderHistory);

    }

    @ResponseBody
    @RequestMapping(value = "/getOrderDetail",method = RequestMethod.GET)
    public ModelAndView getOrderDetail(HttpServletRequest request, HttpServletResponse response) throws Exception{

        String category = request.getParameter("category");
        if(category.equals("1")){
            //restaurant booking
            String restaurantID = request.getParameter("itemID");
            String orderID = request.getParameter("orderID");
            Restaurant restaurant = restaurantService.getRestaurant(Integer.parseInt(restaurantID));
            Order order = orderService.getOrder(Integer.parseInt(orderID));
            request.setAttribute("order",order);
            return new ModelAndView("customer/orderDetail","restaurant",restaurant);
        }else if(category.equals("2")){
            //tickets booking
            String ticketID = request.getParameter("itemID");
            String orderID = request.getParameter("orderID");
            Ticket ticket = ticketService.getTicket(Integer.parseInt(ticketID));
            Order order = orderService.getOrder(Integer.parseInt(orderID));
            request.setAttribute("order",order);
            return new ModelAndView("customer/orderDetail","ticket",ticket);
        }
       return new ModelAndView("customer/orderHistory");
    }



}
