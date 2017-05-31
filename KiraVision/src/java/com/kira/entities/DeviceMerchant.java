/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hp
 */
@Entity
@Table(name="deviceMerchant")
@XmlRootElement(name="MERCHANTDEVICE")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeviceMerchant implements Serializable{
   @Id
   private MerchantBean merchant;
  @Id
  private Device device;
  private String deviceLocation;

    /**
     * @return the merchant
     */
    public MerchantBean getMerchant() {
        return merchant;
    }

    /**
     * @param merchant the merchant to set
     */
    public void setMerchant(MerchantBean merchant) {
        this.merchant = merchant;
    }

    /**
     * @return the device
     */
    public Device getDevice() {
        return device;
    }

    /**
     * @param device the device to set
     */
    public void setDevice(Device device) {
        this.device = device;
    }

    /**
     * @return the deviceLocation
     */
    public String getDeviceLocation() {
        return deviceLocation;
    }

    /**
     * @param deviceLocation the deviceLocation to set
     */
    public void setDeviceLocation(String deviceLocation) {
        this.deviceLocation = deviceLocation;
    }
  
    
}
