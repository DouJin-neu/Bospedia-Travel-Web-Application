package com.djin.DAO;

import com.djin.pojo.Ticket;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ManagementDAO {

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
