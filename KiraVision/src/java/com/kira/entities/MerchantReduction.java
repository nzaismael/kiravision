/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.entities;

import com.kira.entities.MerchantBean;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Hp
 */
@Entity
@Table(name="merchantReduction")
public class MerchantReduction implements Serializable{
   @Id
        @OneToOne 
        private MerchantBean merchant;
        private double reduction;        

    /**
     * @return the merchant
     */
    public MerchantBean getMerchant() {
        return merchant;
    }

    /**
     * @param merchant the merchant to set
     */
    public void setMerchant(MerchantBean merchant) {
        this.merchant = merchant;
    }

    /**
     * @return the reduction
     */
    public double getReduction() {
        return reduction;
    }

    /**
     * @param reduction the reduction to set
     */
    public void setReduction(double reduction) {
        this.reduction = reduction;
    }
    
}
