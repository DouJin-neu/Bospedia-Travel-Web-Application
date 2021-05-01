package com.djin.pojo;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

//Ticket entity
@Component("ticket")
public class Ticket {

    private int ticketID;
    private String ticketName;
    private double price;
    private String tIntroduce;
    private String tFlag;  //available？
    private Date tDate;  //start selling date
    private int collect;  //times that it has been collected
    private int cid; //category id
    private String timage;
    private int amount;

    public Ticket() {
    }

    public Ticket(int ticketID, String ticketName, double price, String tIntroduce, String tFlag, Date tDate, int collect, int cid, String timage, int amount) {
        this.ticketID = ticketID;
        this.ticketName = ticketName;
        this.price = price;
        this.tIntroduce = tIntroduce;
        this.tFlag = tFlag;
        this.tDate = tDate;
        this.collect = collect;
        this.cid = cid;
        this.timage = timage;
        this.amount = amount;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String gettIntroduce() {
        return tIntroduce;
    }

    public void settIntroduce(String tIntroduce) {
        this.tIntroduce = tIntroduce;
    }

    public String gettFlag() {
        return tFlag;
    }

    public void settFlag(String tFlag) {
        this.tFlag = tFlag;
    }

    public Date gettDate() {
        return tDate;
    }

    public void settDate(Date tDate) {
        this.tDate = tDate;
    }

    public int getCollect() {
        return collect;
    }

    public void setCollect(int collect) {
        this.collect = collect;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getTimage() {
        return timage;
    }

    public void setTimage(String timage) {
        this.timage = timage;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
