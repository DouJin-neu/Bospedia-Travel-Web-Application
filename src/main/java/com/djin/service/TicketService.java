package com.djin.service;

import com.djin.pojo.Restaurant;
import com.djin.pojo.Ticket;

import java.util.Date;
import java.util.List;

public interface TicketService {

    public void addTicket(Ticket ticket);

    public void deleteTicket(int ticketID);

    public void updateFlag(int ticketID, String flag);

    public void updateSellingDate(int ticketID, Date sellingDate);

    public List<Ticket> findTicketByName(String ticketName);

    public List<Ticket>  findTicketByKeyword(String keyword);

    public List<Ticket> getAllTicket();

    public Ticket getTicket(int ticketID);

    public List<Ticket> findTopCollection();

    public List<Ticket> sortTicket(String sortMethod);

    public List<Ticket> findTicketByFilter(int minPrice, int maxPrice);

    public List<Ticket> findAllTrips();

    public List<Ticket> sortTrips(String sortMethod);

    public List<Ticket> getAvailTicket();
}
