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
 * @author AOS
 */
@XmlRootElement(name="ACCOUNTS")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountsBean implements Serializable{
    @XmlElement(name="ACCOUNT")
    private List<AccountBean> listaccounts = new ArrayList<>();

    /**
     * @return the listaccounts
     */
    public List<AccountBean> getListaccounts() {
        return listaccounts;
    }

    /**
     * @param listaccounts the listaccounts to set
     */
    public void setListaccounts(List<AccountBean> listaccounts) {
        this.listaccounts = listaccounts;
    }

    
}
