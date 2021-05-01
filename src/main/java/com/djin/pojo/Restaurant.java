package com.djin.pojo;

import org.springframework.stereotype.Component;

@Component("restaurant")
public class Restaurant {

    private int restaurantID;
    private String restaurantName;
    private String average_price;
    private String rIntroduce;
    private int rCategory;
    private int collect;
    private String contact;
    private String address;
    private String timage;

    public Restaurant() {
    }

    public Restaurant(int restaurantID, String restaurantName, String average_price, String rIntroduce, int rCategory, int collect, String contact, String address, String timage) {
        this.restaurantID = restaurantID;
        this.restaurantName = restaurantName;
        this.average_price = average_price;
        this.rIntroduce = rIntroduce;
        this.rCategory = rCategory;
        this.collect = collect;
        this.contact = contact;
        this.address = address;
        this.timage = timage;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getAverage_price() {
        return average_price;
    }

    public void setAverage_price(String average_price) {
        this.average_price = average_price;
    }

    public String getrIntroduce() {
        return rIntroduce;
    }

    public void setrIntroduce(String rIntroduce) {
        this.rIntroduce = rIntroduce;
    }

    public int getrCategory() {
        return rCategory;
    }

    public void setrCategory(int rCategory) {
        this.rCategory = rCategory;
    }

    public int getCollect() {
        return collect;
    }

    public void setCollect(int collect) {
        this.collect = collect;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTimage() {
        return timage;
    }

    public void setTimage(String timage) {
        this.timage = timage;
    }
}
