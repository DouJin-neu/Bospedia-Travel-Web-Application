package com.djin.pojo;

import com.djin.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("order1")
public class Order {

    private int orderID;
    private int itemID; //restaurantID/ticketID
    private int orderCategory;
    private int userID;
    private String selectedDate;
    private String selectedTime;
    private int itemAmount;
    private int party;//for restaurant
    private double totalPrice;
    private String contact;//for restaurant
    private Date orderDate;
    private Date modifyDate;
    private String orderStatus;

    private Ticket ticket;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Autowired
    TicketService ticketService;

    public Order() {
    }

    public Order(int orderID, int itemID, int orderCategory, int userID, String selectedDate, String selectedTime, int itemAmount, int party, double totalPrice, String contact, Date orderDate, Date modifyDate, String orderStatus) {
        this.orderID = orderID;
        this.itemID = itemID;
        this.orderCategory = orderCategory;
        this.userID = userID;
        this.selectedDate = selectedDate;
        this.selectedTime = selectedTime;
        this.itemAmount = itemAmount;
        this.party = party;
        this.totalPrice = totalPrice;
        this.contact = contact;
        this.orderDate = orderDate;
        this.modifyDate = modifyDate;
        this.orderStatus = orderStatus;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(String selectedDate) {
        this.selectedDate = selectedDate;
    }

    public String getSelectedTime() {
        return selectedTime;
    }

    public void setSelectedTime(String selectedTime) {
        this.selectedTime = selectedTime;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getOrderCategory() {
        return orderCategory;
    }

    public void setOrderCategory(int orderCategory) {
        this.orderCategory = orderCategory;
    }

    public int getParty() {
        return party;
    }

    public void setParty(int party) {
        this.party = party;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Ticket getTicket() {
        ticket = ticketService.getTicket(itemID);
        return ticket;
    }

    @Override
    public String toString(){
        return "Order{" +
                "orderID= "+orderID+
                "userID= "+userID+
                "itemID= "+itemID+
                "orderCategory= "+orderCategory+
                "selectedDate= "+selectedDate+
                "selectedTime= "+selectedTime+
                "itemAmount= "+itemAmount+
                "totalPrice= "+totalPrice+
                "orderDate= "+orderDate+
                "modifyDate= "+modifyDate+
                "orderStatus= "+orderStatus+
                "}";
    }
}
