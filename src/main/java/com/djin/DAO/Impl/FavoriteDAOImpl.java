package com.djin.DAO.Impl;

import com.djin.DAO.FavoriteDAO;
import com.djin.pojo.Favorite;
import com.djin.pojo.Restaurant;
import com.djin.pojo.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("favoriteDAO")
public class FavoriteDAOImpl implements FavoriteDAO {
    @Override
    public void addFavorite(Favorite favorite) {

        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            session.save(favorite);

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFavorite(Favorite favorite) {

        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

           session.delete(favorite);

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateCollection(String ticketID, String restaurantID) {

        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            if(restaurantID.equals("0")){
                String sql = "update ticket_info set collect =collect+1 where ticketID =:idParam";
                Query query = session.createSQLQuery(sql).addEntity(Ticket.class);
                query.setParameter("idParam",Integer.parseInt(ticketID));
                query.executeUpdate();
            }else if(ticketID.equals("0")){
                String sql = "update restaurant_info set collect =collect+1 where restaurantID =:idParam";
                Query query = session.createSQLQuery(sql).addEntity(Restaurant.class);
                query.setParameter("idParam",Integer.parseInt(restaurantID));
                query.executeUpdate();
            }

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Favorite> findFavoriteByUserID(int userID) {
        List<Favorite> favoriteList = new ArrayList<>();
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "select * from favorite_info where userID =:userIDParam";
            Query query = session.createSQLQuery(sql).addEntity(Favorite.class);
            query.setParameter("userIDParam",userID);
            System.out.println(sql);

            List list = query.list();

            for(int i = 0; i < list.size();i++){
                Favorite favorite = (Favorite) list.get(i);
                favoriteList.add(favorite);
            }

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return favoriteList;
    }


    @Override
    public List<Favorite> findFavoriteByFilter(String keyword, String minPrice, String maxPrice, int userID) {
        List<Favorite> favoriteList = new ArrayList<>();

        try{
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

            String sql = "SELECT * FROM ticket_info t INNER JOIN favorite_info f ON (f.ticketID = t.ticketID AND (f.userID =:userIDParam AND t.ticketName LIKE:keywordParam AND t.price >:minPriceParam AND t.price <:maxPriceParam ) ) GROUP BY f.ProductID";

            Query query = session.createSQLQuery(sql).addEntity(Favorite.class);
            query.setParameter("keywordParam","%"+keyword+"%");
            query.setParameter("minPriceParam",minP);
            query.setParameter("maxPriceParam",maxP);
            query.setParameter("userIDParam", userID);
            System.out.println(sql);

            List list = query.list();

            for(int i = 0; i < list.size();i++){
                Favorite favorite = (Favorite) list.get(i);
                System.out.println(favorite.getTicketID());
                favoriteList.add(favorite);

            }

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return favoriteList;
    }

    @Override
    public List<Favorite> sortFavorite(String sortMethod, int userID) {

        List<Favorite> favoriteList = new ArrayList<>();
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            int method = Integer.parseInt(sortMethod);
            String sql = "";
            String sql2 = "";
            if(method == 1){
                sql = "select * from favorite_info f inner JOIN ticket_info t on t.ticketID = f.ticketID and f.userID =:userIDParam group by f.productID order by f.collectedDate desc";
                sql2 = "select * from favorite_info f inner JOIN restaurant_info r on r. restaurantID = f. restaurantID and f.userID =:userIDParam group by f.productID order by f.collectedDate desc";
            }else if(method == 2){
                sql = "SELECT * FROM favorite_info f inner JOIN ticket_info t on t.ticketID = f.ticketID and f.userID =:userIDParam group by f.productID order by t.price";
                sql2= "SELECT * FROM favorite_info f inner JOIN restaurant_info r on r. restaurantID = f. restaurantID and f.userID =:userIDParam group by f.productID order by r.average_price";
            }else if(method == 3){
                sql = "SELECT * FROM favorite_info f inner JOIN ticket_info t on t.ticketID = f.ticketID and f.userID =:userIDParam group by f.productID order by t.price desc";
                sql2= "SELECT * FROM favorite_info f inner JOIN restaurant_info r on r. restaurantID = f. restaurantID and f.userID =:userIDParam group by f.productID order by r.average_price desc";
            }else{
                sql = "select * from favorite_info f inner JOIN ticket_info t on t.ticketID = f.ticketID and f.userID =:userIDParam group by f.productID order by collect desc ";
                sql2 = "select * from favorite_info f inner JOIN restaurant_info r on r. restaurantID = f. restaurantID and f.userID =:userIDParam group by f.productID order by collect desc ";
            }

            Query query = session.createSQLQuery(sql).addEntity(Favorite.class);
            Query query2 = session.createSQLQuery(sql2).addEntity(Favorite.class);

            query.setParameter("userIDParam",userID);
            query2.setParameter("userIDParam",userID);
            System.out.println(sql);

            List list = query.list();
            List listR = query2.list();

            for(int i = 0; i < list.size();i++){
                Favorite favorite = (Favorite) list.get(i);
                System.out.println(favorite.getTicketID());
                favoriteList.add(favorite);

            }
            for(int i = 0; i < listR.size();i++){
                Favorite favorite = (Favorite) listR.get(i);
                System.out.println(favorite.getRestaurantID());
                favoriteList.add(favorite);

            }

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return favoriteList;
    }

    @Override
    public Favorite findFavoriteByUserIDAndTicketID(int userID, int ticketID) {

        Favorite favorite = null;
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "SELECT * FROM favorite_info where userID =:userIDParam and ticketID =:ticketIDParam";

            Query query = session.createSQLQuery(sql).addEntity(Favorite.class);

            query.setParameter("userIDParam",userID);
            query.setParameter("ticketIDParam",ticketID);
            System.out.println(sql);

            List list = query.list();

             favorite = (Favorite) list.get(0);

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return favorite;
    }

    @Override
    public Favorite findFavoriteByUserIDAndRestaurantID(int userID, int restaurantID) {

        Favorite favorite = null;
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "SELECT * FROM favorite_info where userID =:userIDParam and restaurantID =:restaurantIDParam";

            Query query = session.createSQLQuery(sql).addEntity(Favorite.class);

            query.setParameter("userIDParam",userID);
            query.setParameter("restaurantIDParam",restaurantID);
            System.out.println(sql);

            List list = query.list();

            favorite = (Favorite) list.get(0);

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return favorite;
    }


}
