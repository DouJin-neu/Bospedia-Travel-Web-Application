package com.djin.DAO.Impl;

import com.djin.DAO.OrderDAO;
import com.djin.pojo.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO {
    @Override
    public void addOrder(Order order) {

        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            session.save(order);

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int orderID) {

        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "delete from order_info where orderID =:orderIDParam";
            Query query = session.createSQLQuery(sql).addEntity(Order.class);

            query.setParameter("orderIDParam",orderID);

            int row = query.executeUpdate();

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateSelectedDate(int orderID, String selectedDate) {

        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "update order_info set selectedDate =:dateParam where orderID =:orderIDParam";
            Query query = session.createSQLQuery(sql).addEntity(Order.class);
            query.setParameter("orderIDParam",orderID);
            query.setParameter("dateParam",selectedDate);
            query.executeUpdate();

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateSelectedTime(int orderID, String selectedTime) {

        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "update order_info set selectedTime =:timeParam where orderID =:orderIDParam";
            Query query = session.createSQLQuery(sql).addEntity(Order.class);
            query.setParameter("orderIDParam",orderID);
            query.setParameter("timeParam",selectedTime);
            query.executeUpdate();

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateAmount(int orderID, int amount) {

        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "update order_info set itemAmount =:amountParam where orderID =:orderIDParam";
            Query query = session.createSQLQuery(sql).addEntity(Order.class);
            query.setParameter("orderIDParam",orderID);
            query.setParameter("amountParam",amount);
            query.executeUpdate();

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateParty(int orderID, int party) {
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "update order_info set party =:partyParam where orderID =:orderIDParam";
            Query query = session.createSQLQuery(sql).addEntity(Order.class);
            query.setParameter("orderIDParam",orderID);
            query.setParameter("partyParam",party);
            query.executeUpdate();

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateContact(int orderID, String contact) {

        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "update order_info set contact =:contactParam where orderID =:orderIDParam";
            Query query = session.createSQLQuery(sql).addEntity(Order.class);
            query.setParameter("orderIDParam",orderID);
            query.setParameter("contactParam",contact);
            query.executeUpdate();

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateStatus(int orderID, String status) {

        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "update order_info set orderStatus =:statusParam where orderID =:orderIDParam";
            Query query = session.createSQLQuery(sql).addEntity(Order.class);
            query.setParameter("orderIDParam",orderID);
            query.setParameter("statusParam",status);
            query.executeUpdate();

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updatePrice(int orderID, double totalPrice) {
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "update order_info set totalPrice =:priceParam where orderID =:orderIDParam";
            Query query = session.createSQLQuery(sql).addEntity(Order.class);
            query.setParameter("orderIDParam",orderID);
            query.setParameter("priceParam",totalPrice);
            query.executeUpdate();

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateModifyDate(int orderID) {
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "update order_info set modifyDate =:dateParam where orderID =:orderIDParam";
            Query query = session.createSQLQuery(sql).addEntity(Order.class);
            query.setParameter("orderIDParam",orderID);
            query.setParameter("dateParam",new Date());
            query.executeUpdate();

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> findOrderByUserID(int userID) {
        List<Order> orderHistory = new ArrayList<>();
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "select * from order_info t where t.userID =:userIDParam";
            Query query = session.createSQLQuery(sql).addEntity(Order.class);
            query.setParameter("userIDParam",userID);
            System.out.println(sql);

            List list = query.list();

            for(int i = 0; i < list.size();i++){
                Order order = (Order) list.get(i);
                orderHistory.add(order);
                System.out.println(order.toString());
            }

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return orderHistory;
    }

    @Override
    public List<Order> getAllOrder() {
        List<Order> orderList = new ArrayList<>();
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            Query query = session.createSQLQuery("select * from order_info").addEntity(Order.class);
            List list = query.list();

            for(int i = 0; i < list.size();i++){
                Order order = (Order) list.get(i);
                orderList.add(order);
            }

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public Order getOrder(int orderID) {
        Order order = null;
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            Query query = session.createSQLQuery("select * from order_info where orderID =:idParam").addEntity(Order.class);
            query.setParameter("idParam",orderID);
            order = (Order)query.list().get(0);

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public List<Order> categoryFilter(int categoryID) {
        List<Order> orderList = new ArrayList<>();
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            Query query = session.createSQLQuery("select * from order_info where category =:categoryParam").addEntity(Order.class);
            query.setParameter("categoryParam",categoryID);//2 for ticket; 1 for restaurant
            List list = query.list();

            for(int i = 0; i < list.size();i++){
                Order order = (Order) list.get(i);
                orderList.add(order);
            }

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public List<Order> statusFilter(String status) {
        List<Order> orderList = new ArrayList<>();
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            Query query = session.createSQLQuery("select * from order_info where orderStatus =:orderStatusParam").addEntity(Order.class);
            query.setParameter("orderStatusParam",status);
            List list = query.list();

            for(int i = 0; i < list.size();i++){
                Order order = (Order) list.get(i);
                orderList.add(order);
            }

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public List<Order> sortOrder(String sortMethod) {

        List<Order> orderList = new ArrayList<>();
            try{
                Configuration cfg = new Configuration();
                SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
                Session session = sf.openSession();
                Transaction tx = session.beginTransaction();

                int method = Integer.parseInt(sortMethod);
                String sql = "";
                if(method == 1){
                    sql = "select * from order_info order by orderDate desc";
                }else if(method == 2){
                    sql = "SELECT * FROM order_info order by totalPrice";
                }else if(method == 3){
                    sql = "SELECT * FROM order_info order by totalPrice desc";
                }

                Query query = session.createSQLQuery(sql).addEntity(Order.class);


                List list = query.list();

                for(int i = 0; i < list.size();i++){
                    Order order = (Order) list.get(i);
                    orderList.add(order);

                }

                tx.commit();
                session.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            return orderList;
    }
}
