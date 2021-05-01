package test;

import com.djin.pojo.Restaurant;
import com.djin.pojo.Ticket;
import com.djin.service.RestaurantService;
import com.djin.service.TicketService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class pageTest {

    @Autowired
    TicketService ticketService;

    @Autowired
    RestaurantService restaurantService;

    @Test
    public void searchByKeywords(){


       // List<Ticket> ticketSearch_result = ticketService.findTicketByKeyword("French");
        List<Restaurant> restaurantSearch_result = restaurantService.findRestaurantByKeyword("French");
        for(Restaurant restaurant:restaurantSearch_result){
            System.out.println(restaurant.getRestaurantName());
        }
    }
}
