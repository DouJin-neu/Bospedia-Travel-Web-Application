package com.djin.pojo;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component("favorite")
public class Favorite {

    private int productID;
    private User user;
    private Ticket ticket;
    private Restaurant restaurant;
    private Date collectedDate;

    private int ticketID;
    private int restaurantID;
    private int userID;

    public Favorite() {
    }

    public Favorite(int productID, User user, Ticket ticket, Restaurant restaurant, Date collectedDate, int ticketID, int restaurantID, int userID) {
        this.productID = productID;
        this.user = user;
        this.ticket = ticket;
        this.restaurant = restaurant;
        this.collectedDate = collectedDate;
        this.ticketID = ticketID;
        this.restaurantID = restaurantID;
        this.userID = userID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Date getCollectedDate() {
        return collectedDate;
    }

    public void setCollectedDate(Date collectedDate) {
        this.collectedDate = collectedDate;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
