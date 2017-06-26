/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.beans;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * @author AOS
 */
public class PurchaseResponsePOS implements Serializable {
    @JsonProperty("purchaseStatus")
    private int purchaseStatus;
    @JsonProperty("purchaseDesc")
private String purchaseDesc;

    /**
     * @return the purchaseStatus
     */
    public int getPurchaseStatus() {
        return purchaseStatus;
    }

    /**
     * @param purchaseStatus the purchaseStatus to set
     */
    public void setPurchaseStatus(int purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }

    /**
     * @return the purchaseDesc
     */
    public String getPurchaseDesc() {
        return purchaseDesc;
    }

    /**
     * @param purchaseDesc the purchaseDesc to set
     */
    public void setPurchaseDesc(String purchaseDesc) {
        this.purchaseDesc = purchaseDesc;
    }
        
        
}
