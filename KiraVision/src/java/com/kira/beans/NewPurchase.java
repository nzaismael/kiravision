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
public class NewPurchase implements Serializable {
    @JsonProperty(value="deviceserialNumber")
    private String posSerial;
      @JsonProperty(value="deviceImei")
    private String deviceImei;
    @JsonProperty(value="cardnumber")
    
    private String cardNumber;
    @JsonProperty(value="amount")
    private double amount;

    /**
     * @return the posSerial
     */
    public String getPosSerial() {
        return posSerial;
    }

    /**
     * @param posSerial the posSerial to set
     */
    public void setPosSerial(String posSerial) {
        this.posSerial = posSerial;
    }

    /**
     * @return the deviceImei
     */
    public String getDeviceImei() {
        return deviceImei;
    }

    /**
     * @param deviceImei the deviceImei to set
     */
    public void setDeviceImei(String deviceImei) {
        this.deviceImei = deviceImei;
    }

    /**
     * @return the cardNumber
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * @param cardNumber the cardNumber to set
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

}
