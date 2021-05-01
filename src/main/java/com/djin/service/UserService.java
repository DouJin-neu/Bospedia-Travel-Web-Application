package com.djin.service;

import com.djin.pojo.User;

import java.util.List;

public interface UserService {


    public void updateEmail(int userID, String email);

    public void updatePhoneNum(int userID, String phoneNum);

    public void updatePassword(int userID, String password);

    public void register(User user);

    public void updateCustomerInfo(User user);

    public User findUser(String email, String password);

    public boolean isExist(String email);

    public List<User> getAllUser();

    public void deleteUser(int id);

    public User getUser(int userID);

    public void updateMember(int userID,int role);

    public List<User> findUserByName(String userName);

    public List<User> findUserByRole(String userRole);
}
