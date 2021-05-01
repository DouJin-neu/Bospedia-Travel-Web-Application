package com.djin.service.Impl;

import com.djin.DAO.UserDAO;
import com.djin.pojo.User;
import com.djin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public void updateEmail(int userID, String email) {

        userDAO.updateEmail(userID,email);
    }

    @Override
    public void updatePhoneNum(int userID, String phoneNum) {

        userDAO.updatePhoneNum(userID, phoneNum);
    }

    @Override
    public void updatePassword(int userID, String password) {

        userDAO.updatePassword(userID, password);
    }

    @Override
    public void register(User user) {

        userDAO.register(user);
    }

    @Override
    public void updateCustomerInfo(User user) {
        userDAO.updateCustomerInfo(user);
    }

    @Override
    public User findUser(String email, String password) {
        User user = userDAO.findUser(email, password);
        return user;
    }

    @Override
    public boolean isExist(String email) {
        return userDAO.isExist(email);
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList = userDAO.getAllUser();
        return userList;
    }

    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    @Override
    public User getUser(int userID) {
        User user = userDAO.getUser(userID);
        return user;
    }

    @Override
    public void updateMember(int userID, int role) {

        userDAO.updateMember(userID, role);
    }

    @Override
    public List<User> findUserByName(String userName) {
        return userDAO.findUserByName(userName);
    }

    @Override
    public List<User> findUserByRole(String userRole) {
        return userDAO.findUserByRole(userRole);
    }
}
