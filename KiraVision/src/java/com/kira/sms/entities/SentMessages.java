/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.sms.entities;

import com.kira.entities.CardHolder;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author AOS
 */
@Entity
@Table(name="transactionalsmses")
public class SentMessages  {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long msgid;
   private CardHolder cardHolder;
   private String message;
   private String phone;
   private String success;
   private double balance;
   private double cost;


    /**
     * @return the msgid
     */
    public Long getMsgid() {
        return msgid;
    }

    /**
     * @param msgid the msgid to set
     */
    public void setMsgid(Long msgid) {
        this.msgid = msgid;
    }

    /**
     * @return the cardHolder
     */
    public CardHolder getCardHolder() {
        return cardHolder;
    }

    /**
     * @param cardHolder the cardHolder to set
     */
    public void setCardHolder(CardHolder cardHolder) {
        this.cardHolder = cardHolder;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the success
     */
    public String getSuccess() {
        return success;
    }

    /**
     * @param success the success to set
     */
    public void setSuccess(String success) {
        this.success = success;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(double cost) {
        this.cost = cost;
    }
}
