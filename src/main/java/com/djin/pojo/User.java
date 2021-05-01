package com.djin.pojo;

import org.hibernate.annotations.NamedQuery;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component("user1")
public class User {

    private int userID;
    private String uname;
    private String password;
    private String birthday;
    private String sex;
    private String email;
    private String phone;
    private Integer role;

    private Date createTime;
    private Date updateTime;

    private Set<Order> orderSet = new HashSet<>();
    private Set<Favorite> favoriteSet = new HashSet<>();



    public User(){

    }

    public User(String uname, String password, String birthday, String sex, String email, String phone, Integer role, Date createTime, Date updateTime) {
        this.uname = uname;
        this.password = password;
        this.birthday = birthday;
        this.sex = sex;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Set<Favorite> getFavoriteSet() {
        return favoriteSet;
    }

    public void setFavoriteSet(Set<Favorite> favoriteSet) {
        this.favoriteSet = favoriteSet;
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }

    @Override
    public String toString(){
        return "User{" +
                ", id=" + userID +
                ", username=" + uname +
                ", password=" + password +
                ", email=" + email +
                ", phone=" + phone +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", role=" + role +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                "}";
    }
}
