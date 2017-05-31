/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.customer.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hp
 */
@Entity
@Table(name="merchant")
@XmlRootElement(name="MERCHANT")
@XmlAccessorType(XmlAccessType.FIELD)
public class MerchantBean implements Serializable{
    @Id
     @Column(name="merchantid",length=10,nullable=false)
    private String merchantId;
    @Column(name="merchantname",length=60,nullable=false)
    private String merchantName;
    @Column(name="merchantsurname",length=60)
    private String merchantSurname;
    @Column(name="merchantphone",length=30)
    private String merchantPhone;
    @Column(name="merchantemail",length=30)
    private String merchantEmail;
    @Column(name="merchantlocation")
    private String merchantLocation;
    @Column(name="merchantdescription")
    private String merchantDescription;
    @Temporal(TemporalType.TIMESTAMP)
    private Date merchantCreatedOn;
    @Temporal(TemporalType.TIMESTAMP)
    private Date merchantModifiedOn;
    @Column(name="merchantpin",length=10)
    private String userpin;
    
    private boolean status;

    /**
     * @return the merchantId
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * @param merchantId the merchantId to set
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * @return the merchantName
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * @param merchantName the merchantName to set
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    /**
     * @return the merchantSurname
     */
    public String getMerchantSurname() {
        return merchantSurname;
    }

    /**
     * @param merchantSurname the merchantSurname to set
     */
    public void setMerchantSurname(String merchantSurname) {
        this.merchantSurname = merchantSurname;
    }

    /**
     * @return the merchantPhone
     */
    public String getMerchantPhone() {
        return merchantPhone;
    }

    /**
     * @param merchantPhone the merchantPhone to set
     */
    public void setMerchantPhone(String merchantPhone) {
        this.merchantPhone = merchantPhone;
    }

    /**
     * @return the merchantEmail
     */
    public String getMerchantEmail() {
        return merchantEmail;
    }

    /**
     * @param merchantEmail the merchantEmail to set
     */
    public void setMerchantEmail(String merchantEmail) {
        this.merchantEmail = merchantEmail;
    }

    /**
     * @return the merchantLocation
     */
    public String getMerchantLocation() {
        return merchantLocation;
    }

    /**
     * @param merchantLocation the merchantLocation to set
     */
    public void setMerchantLocation(String merchantLocation) {
        this.merchantLocation = merchantLocation;
    }

    /**
     * @return the merchantDescription
     */
    public String getMerchantDescription() {
        return merchantDescription;
    }

    /**
     * @param merchantDescription the merchantDescription to set
     */
    public void setMerchantDescription(String merchantDescription) {
        this.merchantDescription = merchantDescription;
    }

    /**
     * @return the merchantCreatedOn
     */
    public Date getMerchantCreatedOn() {
        return merchantCreatedOn;
    }

    /**
     * @param merchantCreatedOn the merchantCreatedOn to set
     */
    public void setMerchantCreatedOn(Date merchantCreatedOn) {
        this.merchantCreatedOn = merchantCreatedOn;
    }

    /**
     * @return the merchantModifiedOn
     */
    public Date getMerchantModifiedOn() {
        return merchantModifiedOn;
    }

    /**
     * @param merchantModifiedOn the merchantModifiedOn to set
     */
    public void setMerchantModifiedOn(Date merchantModifiedOn) {
        this.merchantModifiedOn = merchantModifiedOn;
    }

    /**
     * @return the userpin
     */
    public String getUserpin() {
        return userpin;
    }

    /**
     * @param userpin the userpin to set
     */
    public void setUserpin(String userpin) {
        this.userpin = userpin;
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
    
    
    
}  
