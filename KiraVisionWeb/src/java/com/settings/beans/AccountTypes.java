/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.settings.beans;

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
@XmlRootElement(name="ACCOUNTTYPESBEAN")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountTypes implements Serializable{
    @XmlElement(name="ACCOUNTTYPEBEAN")
    private List<AccountType> accounttypes = new ArrayList<>();

    /**
     * @return the accounttypes
     */
    public List<AccountType> getAccounttypes() {
        return accounttypes;
    }

    /**
     * @param accounttypes the accounttypes to set
     */
    public void setAccounttypes(List<AccountType> accounttypes) {
        this.accounttypes = accounttypes;
    }
    
}
