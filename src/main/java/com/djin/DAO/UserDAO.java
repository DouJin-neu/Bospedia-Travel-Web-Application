package com.djin.DAO;


import com.djin.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDAO {

    public void register(User user);

    public void updateCustomerInfo(User user);

    public void updateEmail(int userID, String email);

    public void updatePhoneNum(int userID, String phoneNum);

    public void addUser(User user);

    public User getUserByEmailAndPwd(String email, String password);

    public void updatePassword(int id, String password);

    public User findUser(String email, String password);

    public boolean isExist(String email);

    public List<User> getAllUser();

    public void deleteUser(int id);

    public User getUser(int userID);

    public void updateMember(int userID, int role);

    public List<User> findUserByName(String userName);

    public List<User> findUserByRole(String userRole);
}
