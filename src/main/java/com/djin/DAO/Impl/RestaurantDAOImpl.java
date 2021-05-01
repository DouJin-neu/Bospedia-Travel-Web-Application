package com.djin.DAO.Impl;

import com.djin.DAO.RestaurantDAO;
import com.djin.pojo.Restaurant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("restaurantDAO")
public class RestaurantDAOImpl implements RestaurantDAO {
    @Override
    public void addRestaurant(Restaurant restaurant) {

    }

    @Override
    public void deleteRestaurant(int restaurantID) {

    }

    @Override
    public void updateInfo(int restaurantID, String rIntroduce) {

        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "update restaurant_info r set r.rIntroduce =:introParam where r.restaurantID =:restaurantIDParam";
            Query query = session.createSQLQuery(sql).addEntity(Restaurant.class);
            query.setParameter("introParam",rIntroduce);
            query.setParameter("restaurantIDParam",restaurantID);

            System.out.println(sql);
            System.out.println("update finished");

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Restaurant> findRestaurantByCategory(String rCategory) {
        List<Restaurant> resultByCategory = new ArrayList<>();
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "select * from restaurant_info r where r.rCategory =:categoryParam";
            Query query = session.createSQLQuery(sql).addEntity(Restaurant.class);
            query.setParameter("categoryParam",rCategory);
            System.out.println(sql);

            List list = query.list();

            for(int i = 0; i < list.size();i++){
                Restaurant restaurant = (Restaurant) list.get(i);
                resultByCategory.add(restaurant);
                //System.out.println(restaurant.getRestaurantName());
            }

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resultByCategory;
    }

    @Override
    public List<Restaurant> findRestaurantByName(String name) {
        List<Restaurant> resultByName = new ArrayList<>();
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "select * from restaurant_info r where r.restaurantName =:nameParam";
            Query query = session.createSQLQuery(sql).addEntity(Restaurant.class);
            query.setParameter("nameParam",name);
            System.out.println(sql);

            List list = query.list();

            for(int i = 0; i < list.size();i++){
                Restaurant restaurant = (Restaurant) list.get(i);
                resultByName.add(restaurant);
                System.out.println(restaurant.getRestaurantName());
            }

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resultByName;
    }

    @Override
    public List<Restaurant> findRestaurantByKeyword(String keyword) {
        List<Restaurant> resultByKeyword = new ArrayList<>();
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "select * from restaurant_info t where t.restaurantName like :keywordParam " +
                    "or t.average_price like :keywordParam or t.rIntroduce like :keywordParam or t.address like :keywordParam";
            Query query = session.createSQLQuery(sql).addEntity(Restaurant.class);
            query.setParameter("keywordParam","%"+keyword+"%");
            System.out.println(sql);

            List list = query.list();

            for(int i = 0; i < list.size();i++){
                Restaurant restaurant = (Restaurant) list.get(i);
                resultByKeyword.add(restaurant);
                System.out.println(restaurant.getRestaurantName());
            }

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resultByKeyword;
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        List<Restaurant> restaurantList = new ArrayList<>();
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "select * from restaurant_info";
            Query query = session.createSQLQuery(sql).addEntity(Restaurant.class);
            System.out.println(sql);

            List list = query.list();

            for(int i = 0; i < list.size();i++){
                Restaurant restaurant = (Restaurant) list.get(i);
                restaurantList.add(restaurant);
                System.out.println(restaurant.getRestaurantID()+" , "+restaurant.getRestaurantName());
            }

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return restaurantList;
    }

    @Override
    public Restaurant getRestaurant(int restaurantID) {
        Restaurant restaurant = null;
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "select * from restaurant_info r where r.restaurantID =:restaurantIDParam";

            Query query = session.createSQLQuery(sql).addEntity(Restaurant.class);
            System.out.println(sql);
            query.setParameter("restaurantIDParam",restaurantID);
            List list = query.list();
            restaurant = (Restaurant) list.get(0);
            System.out.println(restaurant.getRestaurantID()+" , "+restaurant.getRestaurantName());


            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return restaurant;
    }

    @Override
    public List<Restaurant> findTopCollection() {
        List<Restaurant> topCollection = new ArrayList<>();
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "select * from restaurant_info where collect >:collectParam";
            Query query = session.createSQLQuery(sql).addEntity(Restaurant.class);
            query.setParameter("collectParam",100);

            List list = query.list();

            for(int i = 0; i < list.size();i++){
                Restaurant restaurant = (Restaurant) list.get(i);
                topCollection.add(restaurant);
                System.out.println(restaurant.getRestaurantID()+" , "+restaurant.getRestaurantName());
            }

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return topCollection;
    }

    @Override
    public List<Restaurant> sortRestaurant(String sortMethod) {
        List<Restaurant> allRestaurants = new ArrayList<>();
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            int method = Integer.parseInt(sortMethod);
            String sql = "";
            if(method == 1){
                sql = "select * from restaurant_info";
            }else if(method == 2){
                sql = "SELECT * FROM restaurant_info order by price";
            }else if(method == 3){
                sql = "SELECT * FROM restaurant_info order by price desc";
            }else{
                sql = "select * from restaurant_info order by collect desc ";
            }

            Query query = session.createSQLQuery(sql).addEntity(Restaurant.class);

            System.out.println(sql);

            List list = query.list();

            for(int i = 0; i < list.size();i++){
                Restaurant restaurant = (Restaurant) list.get(i);
                System.out.println(restaurant.getRestaurantID());
                allRestaurants.add(restaurant);

            }

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return allRestaurants;
    }

    @Override
    public List<Restaurant> findRestaurantByFilter(int minPrice, int maxPrice) {

            List<Restaurant> allRestaurants = new ArrayList<>();

            try{
                Configuration cfg = new Configuration();
                SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
                Session session = sf.openSession();
                Transaction tx = session.beginTransaction();

                String sql = "SELECT * FROM restaurant_info t where t.average_price >:minPriceParam AND t.average_price <:maxPriceParam";

                Query query = session.createSQLQuery(sql).addEntity(Restaurant.class);
                query.setParameter("minPriceParam",minPrice);
                query.setParameter("maxPriceParam",maxPrice);
                System.out.println(sql);

                List list = query.list();

                for(int i = 0; i < list.size();i++){
                    Restaurant restaurant = (Restaurant) list.get(i);
                    System.out.println(restaurant.getRestaurantID());
                    allRestaurants.add(restaurant);

                }

                tx.commit();
                session.close();
            }catch(Exception e){
                e.printStackTrace();
            }

            return allRestaurants;

    }
}
