package test;

import com.djin.pojo.Favorite;
import com.djin.pojo.Ticket;
import com.djin.service.FavoriteService;
import com.djin.service.TicketService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.EnumSet;
import java.util.List;


public class collectTest {
    /*@Test
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(standardServiceRegistry).buildMetadata();
        SchemaExport schemaExport = new SchemaExport();
        schemaExport.create(EnumSet.of(TargetType.DATABASE),metadata);
    }
*/
    @Test
    public void addFavorite(){

        Favorite favorite = new Favorite();
        favorite.setProductID(1);
        favorite.setRestaurantID(1);
        favorite.setUserID(1);
        favorite.setCollectedDate(new Date());

        Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(favorite);

        tx.commit();
        session.close();
    }

    @Autowired
    TicketService ticketService;

    @Test
    public void hqlTest(){

        Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("select ticketName from Ticket ");
        List<String> list = query.list();
        for(String name : list){
            System.out.println(name);
        }

        tx.commit();
        session.close();
    }

    @Autowired
    FavoriteService favoriteService;
    @Test
    public void getTicket(){
        List<Favorite> list = favoriteService.findFavoriteByUserID(4);
        for(int i = 0; i < list.size();i++){
            System.out.println(list.get(i).getTicket().getTicketName());
        }
    }
}
