package com.djin.controller;

import com.djin.pojo.Restaurant;
import com.djin.pojo.Ticket;
import com.djin.service.RestaurantService;
import com.djin.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class AjaxController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private RestaurantService restaurantService;

    @ResponseBody
    @RequestMapping(value = "/findEventsAjax")
    public String findEventsAjax(HttpServletRequest request,HttpServletResponse response) throws Exception{

        String keyword = request.getParameter("keyword");
        List<Ticket> ticketList = ticketService.findTicketByKeyword(keyword);
        List<Restaurant> restaurantList = restaurantService.findRestaurantByKeyword(keyword);
        String res = "";
        if(ticketList.size() > 8){
            for(int i = 0; i < 8;i++){
                if(i>0){
                    res += ","+ticketList.get(i).getTicketName();
                }else{
                    res += ticketList.get(i).getTicketName();
                }
            }
        }else{
            for(int i = 0; i < ticketList.size();i++){
                if(i>0){
                    res += ","+ticketList.get(i).getTicketName();
                }else{
                    res += ticketList.get(i).getTicketName();
                }
            }
        }

        for(int i = 0; i < restaurantList.size();i++){

            res += ","+restaurantList.get(i).getRestaurantName();

        }
        if(res.equals("")){
            res ="No Result Found";
        }
        return res;

    }
}
