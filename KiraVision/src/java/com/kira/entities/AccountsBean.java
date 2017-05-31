/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.entities;

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
    private List<AccountBean> accounts = new ArrayList<>();

    /**
     * @return the accounts
     */
    public List<AccountBean> getAccounts() {
        return accounts;
    }

    /**
     * @param accounts the accounts to set
     */
    public void setAccounts(List<AccountBean> accounts) {
        this.accounts = accounts;
    }
    
    
}
