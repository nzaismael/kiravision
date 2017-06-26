/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.settings.entities;

import com.kira.entities.MerchantBean;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.map.annotate.JsonRootName;

/**
 *
 * @author AOS
 */
@Entity
@Table(name="partnerBranches")
 @XmlRootElement(name="PARTNERBRANCH")

@XmlAccessorType(XmlAccessType.FIELD)
public class PartnerBranch implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @XmlElement(name="BRANCHID")
    private Long id;
    @XmlElement(name="BRANCHID")
    private MerchantBean merchantBean;
    @XmlElement(name="BRANCHNAME")
    private String Description;
    @XmlElement(name="DEVICESERIALNUMBER")
   private String deviceSerialNumber;
    @XmlElement(name="DEVICEIMEI")
   private String deviceImei;
    @XmlElement(name="STATUS")
   private boolean status;
   
           
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
     * @return the merchantBean
     */
    public MerchantBean getMerchantBean() {
        return merchantBean;
    }

    /**
     * @param merchantBean the merchantBean to set
     */
    public void setMerchantBean(MerchantBean merchantBean) {
        this.merchantBean = merchantBean;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * @return the deviceSerialNumber
     */
    public String getDeviceSerialNumber() {
        return deviceSerialNumber;
    }

    /**
     * @param deviceSerialNumber the deviceSerialNumber to set
     */
    public void setDeviceSerialNumber(String deviceSerialNumber) {
        this.deviceSerialNumber = deviceSerialNumber;
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
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
