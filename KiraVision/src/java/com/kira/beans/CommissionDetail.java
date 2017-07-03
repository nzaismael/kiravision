/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.beans;

import com.kira.entities.PurchaseCommissionsDetail;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AOS
 */
@XmlRootElement(name="COMMISSION")
@XmlAccessorType(XmlAccessType.FIELD)
public class CommissionDetail implements Serializable{
 public CommissionDetail(PurchaseCommissionsDetail comdet) 
 {
     commisionCode=comdet.getComm().getCommisonCode();
     commissionAcount=this.getCommissionAcount();
     commissionName=comdet.getComm().getCommissionname();
     amount=comdet.getCommissionAmount();
 }
    
    
    
    @XmlElement(name="COMMISSIONCODE")
    private String commisionCode;
    @XmlElement(name="COMMISSIONACCOUNT")
    private String commissionAcount;
    @XmlElement(name="COMMISSIONNAME")
    private String commissionName;
    @XmlElement(name="COMMISSIONAMOUNT")
    private double amount;

    
    
    
    /**
     * @return the commisionCode
     */
    public String getCommisionCode() {
        return commisionCode;
    }

    /**
     * @param commisionCode the commisionCode to set
     */
    public void setCommisionCode(String commisionCode) {
        this.commisionCode = commisionCode;
    }

    /**
     * @return the commissionAcount
     */
    public String getCommissionAcount() {
        return commissionAcount;
    }

    /**
     * @param commissionAcount the commissionAcount to set
     */
    public void setCommissionAcount(String commissionAcount) {
        this.commissionAcount = commissionAcount;
    }

    /**
     * @return the commissionName
     */
    public String getCommissionName() {
        return commissionName;
    }

    /**
     * @param commissionName the commissionName to set
     */
    public void setCommissionName(String commissionName) {
        this.commissionName = commissionName;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
     
}
