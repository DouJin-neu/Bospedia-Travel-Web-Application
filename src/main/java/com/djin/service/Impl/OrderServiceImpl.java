package com.djin.service.Impl;

import com.djin.DAO.OrderDAO;
import com.djin.pojo.Order;
import com.djin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO orderDAO;

    public void setOrderDAO(OrderDAO orderDAO){
        this.orderDAO = orderDAO;
    }

    @Override
    public void addOrder(Order order) {
        orderDAO.addOrder(order);
    }

    @Override
    public void deleteOrder(int orderID) {
        orderDAO.deleteOrder(orderID);
    }

    @Override
    public void updateSelectedDate(int orderID, String selectedDate) {
        orderDAO.updateSelectedDate(orderID, selectedDate);
    }

    @Override
    public void updateSelectedTime(int orderID, String selectedTime) {
        orderDAO.updateSelectedTime(orderID, selectedTime);
    }

    @Override
    public void updateAmount(int orderID, int amount) {

        orderDAO.updateAmount(orderID, amount);
    }

    @Override
    public void updateParty(int orderID, int party) {
        orderDAO.updateParty(orderID, party);
    }

    @Override
    public void updateContact(int orderID, String contact) {

        orderDAO.updateContact(orderID, contact);
    }

    @Override
    public void updateStatus(int orderID, String status) {

        orderDAO.updateStatus(orderID, status);
    }

    @Override
    public void updatePrice(int orderID, double totalPrice) {
        orderDAO.updatePrice(orderID, totalPrice);
    }

    @Override
    public void updateModifyDate(int orderID) {
        orderDAO.updateModifyDate(orderID);
    }

    @Override
    public List<Order> findOrderByUserID(int userID) {
        return orderDAO.findOrderByUserID(userID);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderDAO.getAllOrder();
    }

    @Override
    public Order getOrder(int orderID) {
        return orderDAO.getOrder(orderID);
    }

    @Override
    public List<Order> categoryFilter(int categoryID) {
        return orderDAO.categoryFilter(categoryID);
    }

    @Override
    public List<Order> statusFilter(String status) {
        return orderDAO.statusFilter(status);
    }

    @Override
    public List<Order> sortOrder(String sortMethod) {
        return orderDAO.sortOrder(sortMethod);
    }
}
