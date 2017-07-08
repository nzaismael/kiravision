/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.beans;

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
@XmlRootElement(name="COMMISSIONS")
@XmlAccessorType(XmlAccessType.FIELD)
public class PurchaseCommissions implements Serializable{
    
      @XmlElement(name="COMMISSION")
    private List<CommissionDetail> comdetails = new ArrayList();

    /**
     * @return the comdetails
     */
    public List<CommissionDetail> getComdetails() {
        return comdetails;
    }

    /**
     * @param comdetails the comdetails to set
     */
    public void setComdetails(List<CommissionDetail> comdetails) {
        this.comdetails = comdetails;
    }
    
    
}
