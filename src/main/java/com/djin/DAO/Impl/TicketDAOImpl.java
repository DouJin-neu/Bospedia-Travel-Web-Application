package com.djin.DAO.Impl;

import com.djin.DAO.TicketDAO;
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

@Repository("ticketDAO")
public class TicketDAOImpl implements TicketDAO {
    @Override
    public void addTicket(Ticket ticket) {

    }

    @Override
    public void deleteTicket(int ticketID) {

    }

    @Override
    public void updateFlag(int ticketID, String flag) {

        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "update ticket_info t set tFlag =:flagParam where t.ticketID =:ticketIDParam";
            Query query = session.createSQLQuery(sql).addEntity(Ticket.class);
            query.setParameter("flagParam",flag);
            query.setParameter("ticketIDParam",ticketID);

            System.out.println(sql);
            System.out.println("update finished");

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateSellingDate(int ticketID, Date sellingDate) {

        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "update ticket_info t set sellingDate =:sellingDateParam where t.ticketID =:ticketIDParam";
            Query query = session.createSQLQuery(sql).addEntity(Ticket.class);
            query.setParameter("sellingDateParam",sellingDate);
            query.setParameter("ticketIDParam",ticketID);

            System.out.println(sql);
            System.out.println("update finished");

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Ticket> findTicketByName(String ticketName) {
        List<Ticket> resultByName = new ArrayList<>();
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

           String sql = "select * from ticket_info t where t.ticketName =:ticketNameParam";
            //String sql = "select * from ticket_info t where t.ticketName like :ticketNameParam";
            Query query = session.createSQLQuery(sql).addEntity(Ticket.class);
            query.setParameter("ticketNameParam",ticketName);
            System.out.println(sql);

            List list = query.list();

            for(int i = 0; i < list.size();i++){
                Ticket ticket = (Ticket) list.get(i);
                resultByName.add(ticket);
                System.out.println(ticket.getTicketName());
            }

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resultByName;
    }

    @Override
    public List<Ticket> findTicketByKeyword(String keyword) {
        List<Ticket> resultByKeyword = new ArrayList<>();
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "select * from ticket_info t where (t.ticketName like :keywordParam " +
                    "or t.price like :keywordParam or t.tIntroduce like :keywordParam or t.sellingDate like :keywordParam) and tFlag='true'";
            Query query = session.createSQLQuery(sql).addEntity(Ticket.class);
            query.setParameter("keywordParam","%"+keyword+"%");
            System.out.println(sql);

            List list = query.list();

            for(int i = 0; i < list.size();i++){
                Ticket ticket = (Ticket) list.get(i);
                resultByKeyword.add(ticket);
                System.out.println(ticket.getTicketName());
            }

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resultByKeyword;
    }

    @Override
    public List<Ticket> getAllTicket() {

        List<Ticket> ticketList = new ArrayList<>();
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "select * from ticket_info";
            Query query = session.createSQLQuery(sql).addEntity(Ticket.class);
            System.out.println(sql);

            List list = query.list();

            for(int i = 0; i < list.size();i++){
                Ticket ticket = (Ticket) list.get(i);
                ticketList.add(ticket);
                System.out.println(ticket.getTicketID()+" , "+ticket.getTicketName());
            }

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return ticketList;
    }

    @Override
    public List<Ticket> getAvailTicket() {

       List<Ticket> ticketList = new ArrayList<>();
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "select * from ticket_info where tFlag='true'";
            Query query = session.createSQLQuery(sql).addEntity(Ticket.class);
            System.out.println(sql);

            List list = query.list();

            for(int i = 0; i < list.size();i++){
                Ticket ticket = (Ticket) list.get(i);
                ticketList.add(ticket);
                System.out.println(ticket.getTicketID()+" , "+ticket.getTicketName());
            }

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return ticketList;
    }

    @Override
    public Ticket getTicket(int ticketID) {
        Ticket ticket = null;
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "select * from ticket_info t where t.ticketID =:ticketIDParam";
            Query query = session.createSQLQuery(sql).addEntity(Ticket.class);
            query.setParameter("ticketIDParam",ticketID);

            List list = query.list();

            ticket = (Ticket) list.get(0);

            System.out.println(sql);
            System.out.println("Ticket ID: "+ ticket.getTicketID()+"Ticket Name: "+ticket.getTicketName());

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return ticket;
    }

    @Override
    public List<Ticket> findTopCollection() {
        List<Ticket> topCollection = new ArrayList<>();
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "select * from ticket_info where collect >:collectParam";
            Query query = session.createSQLQuery(sql).addEntity(Ticket.class);
            query.setParameter("collectParam",1000);

            List list = query.list();

            for(int i = 0; i < list.size();i++){
                Ticket ticket = (Ticket) list.get(i);
                topCollection.add(ticket);
                System.out.println(ticket.getTicketID()+" , "+ticket.getTicketName());
            }

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return topCollection;
    }

    @Override
    public List<Ticket> sortTicket(String sortMethod) {
        List<Ticket> allTickets = new ArrayList<>();
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            int method = Integer.parseInt(sortMethod);
            String sql = "";
            if(method == 1){
                sql = "select * from ticket_info order by sellingDate desc";
            }else if(method == 2){
                sql = "SELECT * FROM ticket_info order by price";
            }else if(method == 3){
                sql = "SELECT * FROM ticket_info order by price desc";
            }else{
                sql = "select * from ticket_info order by collect desc ";
            }

            Query query = session.createSQLQuery(sql).addEntity(Ticket.class);

            System.out.println(sql);

            List list = query.list();

            for(int i = 0; i < list.size();i++){
                Ticket ticket = (Ticket) list.get(i);
                System.out.println(ticket.getTicketID());
                allTickets.add(ticket);

            }

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return allTickets;
    }

    @Override
    public List<Ticket> sortTrips(String sortMethod) {
        List<Ticket> allTrips = new ArrayList<>();
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            int method = Integer.parseInt(sortMethod);
            String sql = "";
            if(method == 1){
                sql = "select * from ticket_info where categoryID=4 order by sellingDate desc";
            }else if(method == 4){
                sql = "SELECT * FROM ticket_info where categoryID=4 order by collect desc";
            }

            Query query = session.createSQLQuery(sql).addEntity(Ticket.class);

            System.out.println(sql);

            List list = query.list();

            for(int i = 0; i < list.size();i++){
                Ticket ticket = (Ticket) list.get(i);
                System.out.println(ticket.getTicketID());
                allTrips.add(ticket);

            }

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return allTrips;
    }

    @Override
    public List<Ticket> findTicketByFilter(int minPrice, int maxPrice) {
        List<Ticket> allTickets = new ArrayList<>();

        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "SELECT * FROM ticket_info t where t.price >:minPriceParam AND t.price <:maxPriceParam";

            Query query = session.createSQLQuery(sql).addEntity(Ticket.class);
            query.setParameter("minPriceParam",minPrice);
            query.setParameter("maxPriceParam",maxPrice);
            System.out.println(sql);

            List list = query.list();

            for(int i = 0; i < list.size();i++){
                Ticket ticket = (Ticket) list.get(i);
                System.out.println(ticket.getTicketID());
                allTickets.add(ticket);

            }

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return allTickets;
    }

    @Override
    public List<Ticket> findAllTrips() {
        List<Ticket> tripList = new ArrayList<>();
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "select * from ticket_info where categoryID =4";
            Query query = session.createSQLQuery(sql).addEntity(Ticket.class);

            List list = query.list();

            for(int i = 0; i < list.size();i++){
                Ticket ticket = (Ticket) list.get(i);
                tripList.add(ticket);
                System.out.println(ticket.getTicketID()+" , "+ticket.getTicketName());
            }

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return tripList;
    }
}
