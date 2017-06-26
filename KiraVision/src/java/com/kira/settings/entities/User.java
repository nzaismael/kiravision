/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.settings.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hp
 */
@Entity
@Table(name="SystemUsers")
@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable {
 @Id
  @Column(length=30,nullable=false)
 @XmlElement(name="ID",nillable=true)
private String userId; 
  @Column(length=60,nullable=false)
  @XmlElement(name="NAME")
private String username;
  @Column(length=60,nullable=false)
  @XmlElement(name="SURNAME",nillable=true)
private String userSurname;
  @Temporal(TemporalType.TIMESTAMP)
  @XmlElement(name="CREATEDON")
private java.util.Date createdOn;
  @Temporal(TemporalType.TIMESTAMP)
  @XmlElement(name="MODIFIEDON")
private java.util.Date modifiedOn;
  @Column(length=40,nullable=false)
  @XmlElement(name="SECRET",nillable=true)
private String userPin;
  @XmlElement(name="STATUS")
  private boolean status;
  @Column(name="mobile",length=20,unique=true)
  @XmlElement(name="MOBILE",nillable=true)
  private String mobileNumber;
  @Column(name="email",length=30)
  @XmlElement(name="EMAIL",nillable=true)
  private String userEmail;
  
   /**
     * @return the userPin
     */
    public String getUserPin() {
        return userPin;
    }

    /**
     * @param userPin the userPin to set
     */
    public void setUserPin(String userPin) {
        this.userPin = userPin;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the userSurname
     */
    public String getUserSurname() {
        return userSurname;
    }

    /**
     * @param userSurname the userSurname to set
     */
    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    /**
     * @return the createdOn
     */
    public java.util.Date getCreatedOn() {
        return createdOn;
    }

    /**
     * @param createdOn the createdOn to set
     */
    public void setCreatedOn(java.util.Date createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * @return the modifiedOn
     */
    public java.util.Date getModifiedOn() {
        return modifiedOn;
    }

    /**
     * @param modifiedOn the modifiedOn to set
     */
    public void setModifiedOn(java.util.Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    /**
     * @return the mobileNumber
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * @param mobileNumber the mobileNumber to set
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * @return the userEmail
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param userEmail the userEmail to set
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

}
