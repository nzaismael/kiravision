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
@XmlRootElement(name="CURRENCIES")
@XmlAccessorType(XmlAccessType.FIELD)
public class CurrenciesBean implements Serializable{
    @XmlElement(name="CURRENCY")
    private List<CurrencyBean> currencies=new ArrayList<>();

    /**
     * @return the currencies
     */
    public List<CurrencyBean> getCurrencies() {
        return currencies;
    }

    /**
     * @param currencies the currencies to set
     */
    public void setCurrencies(List<CurrencyBean> currencies) {
        this.currencies = currencies;
    }
    
    
    
}
