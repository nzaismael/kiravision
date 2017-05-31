/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.utils;

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

@XmlRootElement(name="CLIENT")
@XmlAccessorType(XmlAccessType.FIELD)
public class CardHolder implements Serializable {
    @Id
    @XmlElement(name="ID")
    
 private String clientId;
     @XmlElement(name="NAME")
   
 private String clientName;
      @XmlElement(name="SURNAME")
   
 private String clientSurname;
       @XmlElement(name="MSISDN")
   
 private String clientPhone;
        @XmlElement(name="EMAIL")
    
    private String clientEmail;
         @XmlElement(name="PIN")
   
    private String clientPin;
          @XmlElement(name="CARDNUMBER")
    
    private String cardNumber;
           @XmlElement(name="STATUS")
    private boolean status;
    private CommercialAgent parent;
    private CommercialAgent child;
    private CommercialAgent grandChild;
@Temporal(TemporalType.TIMESTAMP)
        @XmlElement(name="CREATEDON")
private java.util.Date createdOn;
@Temporal(TemporalType.TIMESTAMP)
        @XmlElement(name="MODIFIEDON")
private java.util.Date modifiedOn;


    /**
     * @return the clientId
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * @param clientId the clientId to set
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * @return the clientName
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * @param clientName the clientName to set
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * @return the clientSurname
     */
    public String getClientSurname() {
        return clientSurname;
    }

    /**
     * @param clientSurname the clientSurname to set
     */
    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    /**
     * @return the clientPhone
     */
    public String getClientPhone() {
        return clientPhone;
    }

    /**
     * @param clientPhone the clientPhone to set
     */
    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    /**
     * @return the clientEmail
     */
    public String getClientEmail() {
        return clientEmail;
    }

    /**
     * @param clientEmail the clientEmail to set
     */
    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    /**
     * @return the clientPin
     */
    public String getClientPin() {
        return clientPin;
    }

    /**
     * @param clientPin the clientPin to set
     */
    public void setClientPin(String clientPin) {
        this.clientPin = clientPin;
    }

    /**
     * @return the cardNumber
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * @param cardNumber the cardNumber to set
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
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
     * @return the parent
     */
    public CommercialAgent getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(CommercialAgent parent) {
        this.parent = parent;
    }

    /**
     * @return the child
     */
    public CommercialAgent getChild() {
        return child;
    }

    /**
     * @param child the child to set
     */
    public void setChild(CommercialAgent child) {
        this.child = child;
    }

    /**
     * @return the grandChild
     */
    public CommercialAgent getGrandChild() {
        return grandChild;
    }

    /**
     * @param grandChild the grandChild to set
     */
    public void setGrandChild(CommercialAgent grandChild) {
        this.grandChild = grandChild;
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
 
    
}
