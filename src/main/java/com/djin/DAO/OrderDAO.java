package com.djin.DAO;

import com.djin.pojo.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderDAO {

        public void addOrder(Order order);

        public void deleteOrder(int orderID);

        public void updateSelectedDate(int orderID, String selectedDate);

        public void updateSelectedTime(int orderID, String selectedTime);

        public void updateAmount(int orderID, int amount);

        public void updateParty(int orderID, int party);

        public void updateContact(int orderID, String contact);

        public void updateStatus(int orderID, String status);

        public void updatePrice(int orderID, double totalPrice);

        public void updateModifyDate(int orderID);

        public List<Order> findOrderByUserID(int userID);

        public List<Order> getAllOrder();

        public Order getOrder(int orderID);

        public List<Order> categoryFilter(int categoryID);

        public List<Order> statusFilter(String status);

        public List<Order> sortOrder(String sortMethod);





    }

