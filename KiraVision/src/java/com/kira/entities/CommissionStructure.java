/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hp
 */
@Entity
@Table(name="CommissionStructure")
@XmlRootElement(name="COMMSTRUCTURE")
@XmlAccessorType(XmlAccessType.FIELD)
public class CommissionStructure implements Serializable {
    @Id
    private CommissionBeneficiary beneficiary;
     private int lowerLimit;
     private int upperLimit;
     private double percentage;

    /**
     * @return the beneficiary
     */
    public CommissionBeneficiary getBeneficiary() {
        return beneficiary;
    }

    /**
     * @param beneficiary the beneficiary to set
     */
    public void setBeneficiary(CommissionBeneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

    /**
     * @return the lowerLimit
     */
    public int getLowerLimit() {
        return lowerLimit;
    }

    /**
     * @param lowerLimit the lowerLimit to set
     */
    public void setLowerLimit(int lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    /**
     * @return the upperLimit
     */
    public int getUpperLimit() {
        return upperLimit;
    }

    /**
     * @param upperLimit the upperLimit to set
     */
    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    /**
     * @return the percentage
     */
    public double getPercentage() {
        return percentage;
    }

    /**
     * @param percentage the percentage to set
     */
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
    
}
