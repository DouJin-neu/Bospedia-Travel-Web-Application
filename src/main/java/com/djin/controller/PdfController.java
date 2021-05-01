package com.djin.controller;

import com.djin.pojo.Order;
import com.djin.pojo.PdfView;
import com.djin.pojo.Ticket;
import com.djin.service.OrderService;
import com.djin.service.RestaurantService;
import com.djin.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PdfController {

    @Autowired
    TicketService ticketService;

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    OrderService orderService;

    @RequestMapping(value="/report",method= RequestMethod.GET)
    protected View handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String ticketID = request.getParameter("itemID");
        String orderID = request.getParameter("orderID");

        int id = Integer.parseInt(ticketID);
        Ticket ticket = ticketService.getTicket(id);

        Order order = orderService.getOrder(Integer.parseInt(orderID));

        View view = new PdfView(order,ticket);

        return view;

    }
}