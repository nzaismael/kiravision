/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.customer.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hp
 */

@XmlRootElement(name="CONTRACT")
@XmlAccessorType(XmlAccessType.FIELD)
public class MerchantReduction implements Serializable{
   @Id
   @XmlElement(name="ID")
   
   private Long Id ;
       @XmlElement(name="MERCHANT")
       
        private MerchantBean merchant;
     
       @XmlElement(name="REDUCTION")
        private double reduction; 
       @Temporal(TemporalType.DATE)
        @XmlElement(name="SIGNEDON")
        private java.util.Date signedOn = new java.util.Date();
         @XmlElement(name="SIGNATORYPARTNER")
        private String signatoryPartner;
         @XmlElement(name="PARTNERPOSITION")
          private String partnerPosition;
         @XmlElement(name="KIRAPOSITION")
       
         private String kiraPosition;
          @XmlElement(name="SIGNATORYKIRA")
        private String signatoryKira;
           @XmlElement(name="STOPPEDON")
           @Temporal(TemporalType.TIMESTAMP)
        private java.util.Date stopedOn;
            @XmlElement(name="STATUS")
       private boolean status;

    /**
     * @return the Id
     */
    public Long getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(Long Id) {
        this.Id = Id;
    }

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
     * @return the reduction
     */
    public double getReduction() {
        return reduction;
    }

    /**
     * @param reduction the reduction to set
     */
    public void setReduction(double reduction) {
        this.reduction = reduction;
    }

    /**
     * @return the signedOn
     */
    public java.util.Date getSignedOn() {
        return signedOn;
    }

    /**
     * @param signedOn the signedOn to set
     */
    public void setSignedOn(java.util.Date signedOn) {
        this.signedOn = signedOn;
    }

    /**
     * @return the signatoryPartner
     */
    public String getSignatoryPartner() {
        return signatoryPartner;
    }

    /**
     * @param signatoryPartner the signatoryPartner to set
     */
    public void setSignatoryPartner(String signatoryPartner) {
        this.signatoryPartner = signatoryPartner;
    }

    /**
     * @return the partnerPosition
     */
    public String getPartnerPosition() {
        return partnerPosition;
    }

    /**
     * @param partnerPosition the partnerPosition to set
     */
    public void setPartnerPosition(String partnerPosition) {
        this.partnerPosition = partnerPosition;
    }

    /**
     * @return the kiraPosition
     */
    public String getKiraPosition() {
        return kiraPosition;
    }

    /**
     * @param kiraPosition the kiraPosition to set
     */
    public void setKiraPosition(String kiraPosition) {
        this.kiraPosition = kiraPosition;
    }

    /**
     * @return the signatoryKira
     */
    public String getSignatoryKira() {
        return signatoryKira;
    }

    /**
     * @param signatoryKira the signatoryKira to set
     */
    public void setSignatoryKira(String signatoryKira) {
        this.signatoryKira = signatoryKira;
    }

    /**
     * @return the stopedOn
     */
    public java.util.Date getStopedOn() {
        return stopedOn;
    }

    /**
     * @param stopedOn the stopedOn to set
     */
    public void setStopedOn(java.util.Date stopedOn) {
        this.stopedOn = stopedOn;
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
