/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.utils;

import java.io.Serializable;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="USSDNAVIGATION")
@XmlAccessorType(XmlAccessType.FIELD)
public class KiraUssdNavigation {
    @XmlElement(name="SESSIONID")
    private String sessionid;
   
    @XmlElement(name="AGENTID")
    private int agentid;
    @XmlElement(name="MSISDN")
    private String msisdn;
    @XmlElement(name="NEXTVALUE")
    private String nextValue;
    @XmlElement(name="PREVIOUSVALUE")
    private String previousValue;
    @XmlTransient
    private java.util.Date lastAccessed;
    @XmlTransient
    private String language;
    @XmlTransient
    private String operationUrl;
    @XmlTransient
    private String nextValue2;
    private String nextValue3;
    
    private CardHolder cardholder;
    private String agentchosenMenu;
    /**
     * @return the sessionid
     */
    public String getSessionid() {
        return sessionid;
    }

    /**
     * @param sessionid the sessionid to set
     */
    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    /**
     * @return the agentid
     */
    public int getAgentid() {
        return agentid;
    }

    /**
     * @param agentid the agentid to set
     */
    public void setAgentid(int agentid) {
        this.agentid = agentid;
    }

    /**
     * @return the msisdn
     */
    public String getMsisdn() {
        return msisdn;
    }

    /**
     * @param msisdn the msisdn to set
     */
    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    /**
     * @return the nextValue
     */
    public String getNextValue() {
        return nextValue;
    }

    /**
     * @param nextValue the nextValue to set
     */
    public void setNextValue(String nextValue) {
        this.nextValue = nextValue;
    }

    /**
     * @return the previousValue
     */
    public String getPreviousValue() {
        return previousValue;
    }

    /**
     * @param previousValue the previousValue to set
     */
    public void setPreviousValue(String previousValue) {
        this.previousValue = previousValue;
    }

    /**
     * @return the lastAccessed
     */
    public java.util.Date getLastAccessed() {
        return lastAccessed;
    }

    /**
     * @param lastAccessed the lastAccessed to set
     */
    public void setLastAccessed(java.util.Date lastAccessed) {
        this.lastAccessed = lastAccessed;
    }

    /**
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return the operationUrl
     */
    public String getOperationUrl() {
        return operationUrl;
    }

    /**
     * @param operationUrl the operationUrl to set
     */
    public void setOperationUrl(String operationUrl) {
        this.operationUrl = operationUrl;
    }

    /**
     * @return the nextValue2
     */
    public String getNextValue2() {
        return nextValue2;
    }

    /**
     * @param nextValue2 the nextValue2 to set
     */
    public void setNextValue2(String nextValue2) {
        this.nextValue2 = nextValue2;
    }

    /**
     * @return the cardholder
     */
    public CardHolder getCardholder() {
        return cardholder;
    }

    /**
     * @param cardholder the cardholder to set
     */
    public void setCardholder(CardHolder cardholder) {
        this.cardholder = cardholder;
    }

    /**
     * @return the agentchosenMenu
     */
    public String getAgentchosenMenu() {
        return agentchosenMenu;
    }

    /**
     * @param agentchosenMenu the agentchosenMenu to set
     */
    public void setAgentchosenMenu(String agentchosenMenu) {
        this.agentchosenMenu = agentchosenMenu;
    }

    /**
     * @return the nextValue3
     */
    public String getNextValue3() {
        return nextValue3;
    }

    /**
     * @param nextValue3 the nextValue3 to set
     */
    public void setNextValue3(String nextValue3) {
        this.nextValue3 = nextValue3;
    }
    
  
    
   
}
