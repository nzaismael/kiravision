/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.entities;

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
@XmlRootElement(name="MERCHANTS")
@XmlAccessorType(XmlAccessType.FIELD)
public class MerchantBeans {
    @XmlElement(name="MERCHANT")
   private List<MerchantBean> merchants = new ArrayList();

    /**
     * @return the merchants
     */
    public List<MerchantBean> getMerchants() {
        return merchants;
    }

    /**
     * @param merchants the merchants to set
     */
    public void setMerchants(List<MerchantBean> merchants) {
        this.merchants = merchants;
    }
   
}
