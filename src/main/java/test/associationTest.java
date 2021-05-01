package test;

import com.djin.pojo.Order;
import com.djin.pojo.User;
import com.djin.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Set;

public class associationTest {



    @Test
    public void demo01(){
        Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        String sql = "select * from user_info where userID =:userIDParam";
        Query query = session.createSQLQuery(sql).addEntity(User.class);

        query.setParameter("userIDParam",28);

         User user = (User)query.list().get(0);
         Set<Order> set = user.getOrderSet();
         System.out.println(set.size());



        tx.commit();
        session.close();


    }
}
