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


public class BanksBean implements Serializable {
    @XmlElement(name="BANK")
    private List<BankBean>banks = new ArrayList<>();

    /**
     * @return the banks
     */
    public List<BankBean> getBanks() {
        return banks;
    }

    /**
     * @param banks the banks to set
     */
    public void setBanks(List<BankBean> banks) {
        this.banks = banks;
    }
    
    
}
