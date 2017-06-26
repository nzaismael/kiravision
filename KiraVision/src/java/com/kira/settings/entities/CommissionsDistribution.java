/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.settings.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AOS
 */
@Entity
@Table(name="commissionsDistribution")
@XmlRootElement(name="COMMISSION")
@XmlAccessorType(XmlAccessType.FIELD)
public class CommissionsDistribution implements Serializable {
     @Id
     @Column(name="id")
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     @XmlElement(name="COMMISSIONID")
    private Long id;
    @Column(name="commcode",length=5,unique=true)
    @XmlElement(name="COMMISSIONCODE")
    private String commisonCode;
    @Column(name="commissionName",length=100,unique=true)
    private String commissionname;
    @Column(name="percentage")
    @XmlElement(name="PERCENTAGECOMMISSION")
    private double commission;
    @Column(name="account",length=20)
    private String account;
    @Column(name="status")
     @XmlElement(name="STATUS")
    private boolean status;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the commisonCode
     */
    public String getCommisonCode() {
        return commisonCode;
    }

    /**
     * @param commisonCode the commisonCode to set
     */
    public void setCommisonCode(String commisonCode) {
        this.commisonCode = commisonCode;
    }

    /**
     * @return the commissionname
     */
    public String getCommissionname() {
        return commissionname;
    }

    /**
     * @param commissionname the commissionname to set
     */
    public void setCommissionname(String commissionname) {
        this.commissionname = commissionname;
    }

    /**
     * @return the commission
     */
    public double getCommission() {
        return commission;
    }

    /**
     * @param commission the commission to set
     */
    public void setCommission(double commission) {
        this.commission = commission;
    }

    /**
     * @return the account
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(String account) {
        this.account = account;
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
