/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.settings.beans;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * @author AOS
 */
@XmlRootElement(name="DEVICE")
@XmlAccessorType(XmlAccessType.FIELD)

public class PartnerBranchPOS implements Serializable{
   @XmlElement(name="BRANCHID")
   @JsonProperty(value="id")
    private Long id;
   @XmlElement(name="BRAMCHNAME")
   @JsonProperty(value="branchName")
    private String branchName;
    @XmlElement(name="BRAMCHNAME")
    @JsonProperty(value="merchanteNames")
    private String merchantNames;
     @XmlElement(name="DEVICESERIALNUMBER")
     @JsonProperty(value="deviceserialNumber")
    private String deviceserialNumber;
      @XmlElement(name="DEVICEIMEI")
      @JsonProperty(value="deviceImei")
    private String deviceImei;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the branchName
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * @param branchName the branchName to set
     */
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    /**
     * @return the merchantNames
     */
    public String getMerchantNames() {
        return merchantNames;
    }

    /**
     * @param merchantNames the merchantNames to set
     */
    public void setMerchantNames(String merchantNames) {
        this.merchantNames = merchantNames;
    }

    /**
     * @return the deviceserialNumber
     */
    public String getDeviceserialNumber() {
        return deviceserialNumber;
    }

    /**
     * @param deviceserialNumber the deviceserialNumber to set
     */
    public void setDeviceserialNumber(String deviceserialNumber) {
        this.deviceserialNumber = deviceserialNumber;
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

      
    
}
