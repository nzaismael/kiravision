
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
public class PartnerBranchRequest implements Serializable {
    
    @XmlElement(name="DEVICESERIALNUMBER")
    @JsonProperty(value="deviceserialNumber")
    private String deviceserialNumber;
      @XmlElement(name="DEVICEIMEI")
      @JsonProperty(value="deviceImei")
    private String deviceImei;

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
