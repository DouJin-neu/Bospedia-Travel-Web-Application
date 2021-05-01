package com.djin.service.Impl;

import com.djin.DAO.ManagementDAO;
import com.djin.pojo.Ticket;
import com.djin.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("managementService")
public class ManagementServiceImpl implements ManagementService {

    @Autowired
    ManagementDAO managementDAO;

    @Override
    public void createProduct(Ticket product) {
        managementDAO.createProduct(product);
    }

    @Override
    public void deleteProduct(Ticket product) {
        managementDAO.deleteProduct(product);
    }

    @Override
    public void updateOrderStatus(String status, int orderID) {
        managementDAO.updateOrderStatus(status, orderID);
    }

    @Override
    public void updateProductAva(String availability, int productID) {
        managementDAO.updateProductAva(availability, productID);
    }

    @Override
    public void updateProductInfo(String tIntroduce, int productID) {
        managementDAO.updateProductInfo(tIntroduce, productID);
    }

    @Override
    public void updateProductPrice(double price, int productID) {
        managementDAO.updateProductPrice(price,productID);
    }

    @Override
    public List<Ticket> priceNameFilter(String productName, String minPrice, String maxPrice) {

        return managementDAO.priceNameFilter(productName,minPrice,maxPrice);

    }

    @Override
    public List<Ticket> idFilter(String productID) {
        return managementDAO.idFilter(productID);
    }

    @Override
    public List<Ticket> categoryFilter(String categoryID) {
        return managementDAO.categoryFilter(categoryID);
    }


}
