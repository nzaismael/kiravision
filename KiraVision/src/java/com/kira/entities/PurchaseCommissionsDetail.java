/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.entities;

import com.kira.settings.entities.CommissionsDistribution;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AOS
 */
@Entity
@Table(name="purchaseComDetails")

public class PurchaseCommissionsDetail implements Serializable{
    @Id
    private int detailId;
    @Id
    private PurchaseBean purchase;
    private CommissionsDistribution comm;
    private double commissionAmount;

    /**
     * @return the detailId
     */
    public int getDetailId() {
        return detailId;
    }

    /**
     * @param detailId the detailId to set
     */
    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    /**
     * @return the purchase
     */
    public PurchaseBean getPurchase() {
        return purchase;
    }

    /**
     * @param purchase the purchase to set
     */
    public void setPurchase(PurchaseBean purchase) {
        this.purchase = purchase;
    }

    /**
     * @return the comm
     */
    public CommissionsDistribution getComm() {
        return comm;
    }

    /**
     * @param comm the comm to set
     */
    public void setComm(CommissionsDistribution comm) {
        this.comm = comm;
    }

    /**
     * @return the commissionAmount
     */
    public double getCommissionAmount() {
        return commissionAmount;
    }

    /**
     * @param commissionAmount the commissionAmount to set
     */
    public void setCommissionAmount(double commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    
    
}
