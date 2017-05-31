/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.customer.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hp
 */
@XmlRootElement(name="CLIENTS")
@XmlAccessorType(XmlAccessType.FIELD)
public class CardHolders implements Serializable {
  @XmlElement(name="CLIENT")
    private List<CardHolder> customers = new ArrayList<>();

    /**
     * @return the customers
     */
    public List<CardHolder> getCustomers() {
        return customers;
    }

    /**
     * @param customers the customers to set
     */
    public void setCustomers(List<CardHolder> customers) {
        this.customers = customers;
    }

    
   
}
