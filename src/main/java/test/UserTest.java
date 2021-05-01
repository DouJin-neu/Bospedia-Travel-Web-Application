package test;

import com.djin.pojo.Order;
import com.djin.pojo.User;
import com.djin.service.UserService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserTest {


    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        User user = context.getBean("user1",User.class);
        System.out.println(user.toString());
    }

    @Test
    public void getOrderHistory(){
        Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery(" from Order where userID = 1");
        List<Order> list = query.list();
        for(Order o : list){
            System.out.println(o.toString());
        }

        tx.commit();
        session.close();
    }

    @Test
    public void updateOrder(){
        Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery(" update Order o set o.orderCategory=2 where o.orderID = 1");

        int status = query.executeUpdate();
        System.out.println(status);
        tx.commit();
        session.close();
    }

    @Test
    public void filterOrder(){
        Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Criteria criteria = session.createCriteria(Order.class);

        //restriction
        //criteria.add(Restrictions.eq("price",price)); //eq = equals
        List res = criteria.list();


    }

    @Autowired
    UserService userService;

    @Test
    public void getAllUser(){
        List<User> userList = userService.getAllUser();
        for(User user:userList){
            System.out.println(user.getUserID());
        }
    }

    @Test
    public void updateTime(){

        System.out.println(new Timestamp(System.currentTimeMillis()));
        try{
        Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        String sql = "update user_info set updateTime=:timeParam where userID = 11";
        Query query = session.createSQLQuery(sql).addEntity(User.class);

        query.setParameter("timeParam",new Timestamp(System.currentTimeMillis()));

        query.executeUpdate();

        tx.commit();
        session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
