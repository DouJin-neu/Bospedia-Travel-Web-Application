package com.djin.DAO;

import com.djin.pojo.Ticket;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface TicketDAO {

    public void addTicket(Ticket ticket);

    public void deleteTicket(int ticketID);

    public void updateFlag(int ticketID, String flag);

    public void updateSellingDate(int ticketID, Date sellingDate);

    public List<Ticket>  findTicketByName(String ticketName);

    public List<Ticket>  findTicketByKeyword(String keyword);

    public List<Ticket> getAllTicket();

    public List<Ticket> getAvailTicket();

    public Ticket getTicket(int ticketID);

    public List<Ticket> findTopCollection();

    public List<Ticket> sortTicket(String sortMethod);

    public List<Ticket> sortTrips(String sortMethod);

    public List<Ticket> findTicketByFilter(int minPrice, int maxPrice);

    public List<Ticket> findAllTrips();



}
