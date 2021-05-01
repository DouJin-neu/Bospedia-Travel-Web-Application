package com.djin.DAO.Impl;

import com.djin.DAO.ManagementDAO;
import com.djin.pojo.Order;
import com.djin.pojo.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository("managementDAO")
public class ManagementDAOImpl implements ManagementDAO {
    @Override
    public void createProduct(Ticket ticket) {
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            session.save(ticket);

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(Ticket ticket) {
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            session.delete(ticket);

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrderStatus(String status, int orderID) {

        Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        String sql = "update order_info set orderStatus =:statusParam where orderID =:orderIDParam";
        String sql1 = "update order_info set modifyDate =:modifyDateParam where orderID =:orderIDParam";
        Query query = session.createSQLQuery(sql).addEntity(Order.class);
        query.setParameter("statusParam", status);
        query.setParameter("orderIDParam", orderID);
        Query query1 = session.createSQLQuery(sql1).addEntity(Order.class);
        query1.setParameter("modifyDateParam",new Date());
        query1.setParameter("orderIDParam",orderID);
        query.executeUpdate();
        query1.executeUpdate();

        tx.commit();
        session.close();
    }

    @Override
    public void updateProductAva(String availability, int productID) {

        Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        String sql = "update ticket_info set tFlag =:tFlagParam where ticketID =:ticketIDParam";
        Query query = session.createSQLQuery(sql).addEntity(Ticket.class);
        query.setParameter("tFlagParam", availability);
        query.setParameter("ticketIDParam", productID);
        query.executeUpdate();

        tx.commit();
        session.close();
    }

    @Override
    public void updateProductInfo(String tIntroduce, int productID) {

        Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        String sql = "update ticket_info set tIntroduce =:tIntroduceParam where ticketID =:ticketIDParam";
        Query query = session.createSQLQuery(sql).addEntity(Ticket.class);
        query.setParameter("tIntroduceParam", tIntroduce);
        query.setParameter("ticketIDParam", productID);
        query.executeUpdate();

        tx.commit();
        session.close();
    }

    @Override
    public void updateProductPrice(double price, int productID) {

        Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        String sql = "update ticket_info set price =:priceParam where ticketID =:ticketIDParam";
        Query query = session.createSQLQuery(sql).addEntity(Ticket.class);
        query.setParameter("priceParam", price);
        query.setParameter("ticketIDParam", productID);
        query.executeUpdate();

        tx.commit();
        session.close();
    }

    @Override
    public List<Ticket> priceNameFilter(String productName, String minPrice, String maxPrice) {
        List<Ticket> productList = new ArrayList<>();

        System.out.println(productName+minPrice+maxPrice);
        Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        int minP = 0;
        int maxP = 999;

        if(!minPrice.isEmpty()) {
            minP = Integer.parseInt(minPrice);
        }

        if(!maxPrice.isEmpty()){
            maxP = Integer.parseInt(maxPrice);
        }

        String sql = "select * from ticket_info where ticketName like:nameParam and price >:minPrice and price <:maxPrice";
        Query query = session.createSQLQuery(sql).addEntity(Ticket.class);
        query.setParameter("nameParam","%"+productName+"%");
        query.setParameter("minPrice",minP);
        query.setParameter("maxPrice",maxP);

        List list = query.list();

        for(int i = 0; i < list.size();i++){
            Ticket ticket = (Ticket) list.get(i);
            productList.add(ticket);

        }
        tx.commit();
        session.close();
        return productList;
    }

    @Override
    public List<Ticket> idFilter(String productID) {
        List<Ticket> productList = new ArrayList<>();
        System.out.println(productID);

        Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        int id = Integer.parseInt(productID);

        String sql = "select * from ticket_info where ticketID =:idParam";
        Query query = session.createSQLQuery(sql).addEntity(Ticket.class);
        query.setParameter("idParam",id);

        List list = query.list();

        for(int i = 0; i < list.size();i++){
            Ticket ticket = (Ticket) list.get(i);
            productList.add(ticket);

        }
        tx.commit();
        session.close();
        return productList;
    }

    @Override
    public List<Ticket> categoryFilter(String categoryID) {
        List<Ticket> productList = new ArrayList<>();

        System.out.println(categoryID);
        Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        String sql = "select * from ticket_info where categoryID =:categoryParam";
        Query query = session.createSQLQuery(sql).addEntity(Ticket.class);
        query.setParameter("categoryParam",Integer.parseInt(categoryID));


        List list = query.list();

        for(int i = 0; i < list.size();i++){
            Ticket ticket = (Ticket) list.get(i);
            productList.add(ticket);

        }
        tx.commit();
        session.close();
        return productList;
    }

}
