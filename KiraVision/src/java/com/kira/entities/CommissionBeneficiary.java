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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hp
 */
@Entity
@Table(name="CommissionBeneficiary")
@XmlRootElement(name="BENEFICIARY")
@XmlAccessorType(XmlAccessType.FIELD)
public class CommissionBeneficiary implements Serializable{
    @Id
    @XmlElement(name="ID")
   private String cbId;
    @XmlElement(name="DESCRIPTION")
   private String cbDescription;

    /**
     * @return the cbId
     */
    public String getCbId() {
        return cbId;
    }

    /**
     * @param cbId the cbId to set
     */
    public void setCbId(String cbId) {
        this.cbId = cbId;
    }

    /**
     * @return the cbDescription
     */
    public String getCbDescription() {
        return cbDescription;
    }

    /**
     * @param cbDescription the cbDescription to set
     */
    public void setCbDescription(String cbDescription) {
        this.cbDescription = cbDescription;
    }
    
    
    
}
