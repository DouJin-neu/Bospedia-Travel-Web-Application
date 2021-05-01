package com.djin.DAO.Impl;

import com.djin.DAO.UserDAO;
import com.djin.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {



    @Override
    public void updateEmail(int userID, String email) {

        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "update user_info set email =:emailParam where userID =:userIDParam";
            Query query = session.createSQLQuery(sql).addEntity(User.class);

            query.setParameter("emailParam",email);
            query.setParameter("userIDParam",userID);


            query.executeUpdate();

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void updatePhoneNum(int userID, String phoneNum) {

        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "update user_info set phone =:phoneNumParam where userID =:userIDParam";
            Query query = session.createSQLQuery(sql).addEntity(User.class);

            query.setParameter("phoneNumParam",phoneNum);
            query.setParameter("userIDParam",userID);

            query.executeUpdate();

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void addUser(User user) {


    }



    @Override
    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "select * from user_info";
            Query query = session.createSQLQuery(sql).addEntity(User.class);

            List list = query.list();

            for(int i = 0; i < list.size();i++){
                User user = (User)list.get(i);
                userList.add(user);
            }

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return userList;

    }

    @Override
    public User getUserByEmailAndPwd(String email, String password) {
        return null;
    }

    @Override
    public void deleteUser(int userID) {

        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "delete from user_info where userID =:userIDParam";
            Query query = session.createSQLQuery(sql).addEntity(User.class);

            query.setParameter("userIDParam",userID);
            int row = query.executeUpdate();


            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public User getUser(int userID) {
        User user = null;
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "select * from user_info where userID =:userIDParam";
            Query query = session.createSQLQuery(sql).addEntity(User.class);

            query.setParameter("userIDParam",userID);

            user = (User)query.list().get(0);

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findUserByName(String userName) {
        List<User> userList = new ArrayList<>();
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "select * from user_info where uname like:nameParam";
            Query query = session.createSQLQuery(sql).addEntity(User.class);

            query.setParameter("nameParam","%"+userName+"%");

            List list = query.list();

            for(int i = 0; i < list.size();i++){
                User user = (User)list.get(i);
                userList.add(user);
            }

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public List<User> findUserByRole(String userRole) {
        List<User> userList = new ArrayList<>();
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            int roleID = Integer.parseInt(userRole);

            String sql = "select * from user_info where roleID =:userRoleParam";
            Query query = session.createSQLQuery(sql).addEntity(User.class);

            query.setParameter("userRoleParam",roleID);

            List list = query.list();

            for(int i = 0; i < list.size();i++){
                User user = (User) list.get(i);
                userList.add(user);
            }

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public void updatePassword(int userID, String password) {

        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "update user_info set password =:passwordParam where userID =:userIDParam";
            Query query = session.createSQLQuery(sql).addEntity(User.class);

            query.setParameter("passwordParam",password);
            query.setParameter("userIDParam",userID);

            query.executeUpdate();

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateMember(int userID,int role) {

        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "update user_info set roleID =:roleParam where userID =:userIDParam";
            Query query = session.createSQLQuery(sql).addEntity(User.class);

            query.setParameter("roleParam",role);
            query.setParameter("userIDParam",userID);

            query.executeUpdate();

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void register(User user) {

        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            session.save(user);

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateCustomerInfo(User user) {

        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            session.update(user);

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public User findUser(String email, String password) {
        User user = null;
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "select * from user_info t where t.email =:userEmailParam and t.password =:userPwdParam";
            Query query = session.createSQLQuery(sql).addEntity(User.class);
            query.setParameter("userEmailParam",email);
            query.setParameter("userPwdParam",password);

            List list = query.list();

            user = (User)list.get(0);
           /* List<User> results = query.list();*/
            System.out.println(sql);
            System.out.println(user.toString());
           // user = (User) session.createQuery(sql, User.class);
           /* for(Object u:results){
                System.out.println(u.toString());
                user = (User) u;
            }*/

            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean isExist(String email) {
       boolean isExist = false;
        try{
            Configuration cfg = new Configuration();
            SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            String sql = "select * from user_info t where t.email =:userEmailParam";
            System.out.println(sql);

            Query query = session.createSQLQuery(sql);
            query.setParameter("userEmailParam",email);

            List<User> results = query.list();

            if(!results.isEmpty()){
                isExist = true;
            }
            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return isExist;
    }
}
