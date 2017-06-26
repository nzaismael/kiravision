/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.beans;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * @author AOS
 */
public class CustomerPOS implements Serializable{
   @JsonProperty(value="customerNames")
    private String customerNames;
   @JsonProperty(value="customerPhone")
    private String phoneNumber;

    /**
     * @return the customerNames
     */
    public String getCustomerNames() {
        return customerNames;
    }

    /**
     * @param customerNames the customerNames to set
     */
    public void setCustomerNames(String customerNames) {
        this.customerNames = customerNames;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
   
   
}
