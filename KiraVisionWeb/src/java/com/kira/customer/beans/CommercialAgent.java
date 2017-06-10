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

@XmlRootElement(name="COMMAGENT")
@XmlAccessorType(XmlAccessType.FIELD)
public class CommercialAgent implements Serializable {
    public CommercialAgent()
    {
        
    }
    
@XmlElement(name="ID")
private Long agentId;

@XmlElement(name="NAME")
private String agentName;
@XmlElement(name="SURNAME")

private String agentSurname;
@XmlElement(name="PIN")

private String agentPin;
@XmlElement(name="MSISDN")


private String agentPhone;
@XmlElement(name="EMAIL")

private String agentEmail;
@XmlElement(name="AGENTTYPE")

private String agentType;
@XmlElement(name="CREATEDON")

private java.util.Date createdOn;

@XmlElement(name="MODIFIEDON")
private java.util.Date modifiedOn;
@XmlElement(name="STATUS")
private boolean status;

    /**
     * @return the agentId
     */
    public Long getAgentId() {
        return agentId;
    }

    /**
     * @param agentId the agentId to set
     */
    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    /**
     * @return the agentName
     */
    public String getAgentName() {
        return agentName;
    }

    /**
     * @param agentName the agentName to set
     */
    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    /**
     * @return the agentSurname
     */
    public String getAgentSurname() {
        return agentSurname;
    }

    /**
     * @param agentSurname the agentSurname to set
     */
    public void setAgentSurname(String agentSurname) {
        this.agentSurname = agentSurname;
    }

    /**
     * @return the agentPin
     */
    public String getAgentPin() {
        return agentPin;
    }

    /**
     * @param agentPin the agentPin to set
     */
    public void setAgentPin(String agentPin) {
        this.agentPin = agentPin;
    }

    /**
     * @return the agentPhone
     */
    public String getAgentPhone() {
        return agentPhone;
    }

    /**
     * @param agentPhone the agentPhone to set
     */
    public void setAgentPhone(String agentPhone) {
        this.agentPhone = agentPhone;
    }

    /**
     * @return the agentEmail
     */
    public String getAgentEmail() {
        return agentEmail;
    }

    /**
     * @param agentEmail the agentEmail to set
     */
    public void setAgentEmail(String agentEmail) {
        this.agentEmail = agentEmail;
    }

    /**
     * @return the agentType
     */
    public String getAgentType() {
        return agentType;
    }

    /**
     * @param agentType the agentType to set
     */
    public void setAgentType(String agentType) {
        this.agentType = agentType;
    }

    /**
     * @return the createdOn
     */
    public java.util.Date getCreatedOn() {
        return createdOn;
    }

    /**
     * @param createdOn the createdOn to set
     */
    public void setCreatedOn(java.util.Date createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * @return the modifiedOn
     */
    public java.util.Date getModifiedOn() {
        return modifiedOn;
    }

    /**
     * @param modifiedOn the modifiedOn to set
     */
    public void setModifiedOn(java.util.Date modifiedOn) {
        this.modifiedOn = modifiedOn;
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
