package com.djin.service.Impl;

import com.djin.DAO.TicketDAO;
import com.djin.pojo.Ticket;
import com.djin.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("ticketService")
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDAO ticketDAO;

    public void setTicketDAO(TicketDAO ticketDAO){
        this.ticketDAO = ticketDAO;
    }

    @Override
    public void addTicket(Ticket ticket) {
        ticketDAO.addTicket(ticket);
    }

    @Override
    public void deleteTicket(int ticketID) {

        ticketDAO.deleteTicket(ticketID);
    }

    @Override
    public void updateFlag(int ticketID, String flag) {

        ticketDAO.updateFlag(ticketID,flag);
    }

    @Override
    public void updateSellingDate(int ticketID, Date sellingDate) {

        ticketDAO.updateSellingDate(ticketID, sellingDate);
    }

    @Override
    public List<Ticket> findTicketByName(String ticketName) {

         return ticketDAO.findTicketByName(ticketName);
    }

    @Override
    public List<Ticket> findTicketByKeyword(String keyword) {
        return ticketDAO.findTicketByKeyword(keyword);
    }

    @Override
    public List<Ticket> getAllTicket() {
        return ticketDAO.getAllTicket();
    }

    @Override
    public Ticket getTicket(int ticketID) {
        return ticketDAO.getTicket(ticketID);
    }

    @Override
    public List<Ticket> findTopCollection() {
        return ticketDAO.findTopCollection();
    }

    @Override
    public List<Ticket> sortTicket(String sortMethod) {
        return ticketDAO.sortTicket(sortMethod);
    }

    @Override
    public List<Ticket> findTicketByFilter(int minPrice, int maxPrice) {
        return ticketDAO.findTicketByFilter(minPrice, maxPrice);
    }

    @Override
    public List<Ticket> findAllTrips() {
        return ticketDAO.findAllTrips();
    }

    @Override
    public List<Ticket> sortTrips(String sortMethod) {
        return ticketDAO.sortTrips(sortMethod);
    }

    @Override
    public List<Ticket> getAvailTicket() {
        return ticketDAO.getAvailTicket();
    }


}
