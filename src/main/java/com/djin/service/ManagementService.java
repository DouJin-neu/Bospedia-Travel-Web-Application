package com.djin.service;

import com.djin.pojo.Ticket;

import java.util.List;

public interface ManagementService {

    public void createProduct(Ticket ticket);

    public void deleteProduct(Ticket ticket);

    public void updateOrderStatus(String status, int orderID); //order status

    public void updateProductAva(String availability, int productID);

    public void updateProductInfo(String tIntroduce, int productID);

    public void updateProductPrice(double price, int productID);

    public List<Ticket> priceNameFilter( String productName,String minPrice, String maxPrice);

    public List<Ticket> idFilter(String productID);

    public List<Ticket> categoryFilter(String categoryID);
}
