/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author AOS
 */

@Entity
@Table(name="purchases")
public class PurchaseBean implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long purchaseId;
    private double purchaseAmount;
    private CommercialAgent parent;
    private CommercialAgent child;
    private CommercialAgent grandchild;
    private MerchantReduction contract;
    private CardHolder client;
    private String ebmBillNumber;
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date purchaseOn;
       /**
     * @return the purchaseId
     */
    public Long getPurchaseId() {
        return purchaseId;
    }

    /**
     * @param purchaseId the purchaseId to set
     */
    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    /**
     * @return the purchaseAmount
     */
    public double getPurchaseAmount() {
        return purchaseAmount;
    }

    /**
     * @param purchaseAmount the purchaseAmount to set
     */
    public void setPurchaseAmount(double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
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
     * @return the grandchild
     */
    public CommercialAgent getGrandchild() {
        return grandchild;
    }

    /**
     * @param grandchild the grandchild to set
     */
    public void setGrandchild(CommercialAgent grandchild) {
        this.grandchild = grandchild;
    }

    /**
     * @return the contract
     */
    public MerchantReduction getContract() {
        return contract;
    }

    /**
     * @param contract the contract to set
     */
    public void setContract(MerchantReduction contract) {
        this.contract = contract;
    }

    /**
     * @return the client
     */
    public CardHolder getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(CardHolder client) {
        this.client = client;
    }

    /**
     * @return the ebmBillNumber
     */
    public String getEbmBillNumber() {
        return ebmBillNumber;
    }

    /**
     * @param ebmBillNumber the ebmBillNumber to set
     */
    public void setEbmBillNumber(String ebmBillNumber) {
        this.ebmBillNumber = ebmBillNumber;
    }

    /**
     * @return the purchaseOn
     */
    public java.util.Date getPurchaseOn() {
        return purchaseOn;
    }

    /**
     * @param purchaseOn the purchaseOn to set
     */
    public void setPurchaseOn(java.util.Date purchaseOn) {
        this.purchaseOn = purchaseOn;
    }
    
    
    
    
}
