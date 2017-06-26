/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oltranz.ussd.beans;

import java.math.BigInteger;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aimable
 */
@XmlRootElement(name = "COMMAND")
@XmlAccessorType(XmlAccessType.FIELD)
public class UssdCenterResponse {

    @XmlElement(name = "MSISDN")
    private String msisdn;

    @XmlElement(name = "SESSIONID")
    private BigInteger sessionId;

    @XmlElement(name = "SPID")
    private String spid;

    @XmlElement(name = "INPUT")
    private String input;

    @XmlElement(name = "FREEFLOW")
    private String freeFlow;

    @XmlElement(name = "MESSAGE")
    private String messageTitle;

    @XmlElement(name = "NEWREQUEST")
    private int newRequest;

    @XmlElementWrapper(name = "MENUS")
    @XmlElement(name = "MENU")
    private List<String> menus;

    public UssdCenterResponse() {
    }
    
    public UssdCenterResponse(String msisdn, BigInteger sessionId, String spid, String input, String freeFlow, String messageTitle, int newRequest, List<String> menus) {
        this.msisdn = msisdn;
        this.sessionId = sessionId;
        this.spid = spid;
        this.input = input;
        this.freeFlow = freeFlow;
        this.messageTitle = messageTitle;
        this.newRequest = newRequest;
        this.menus = menus;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public BigInteger getSessionId() {
        return sessionId;
    }

    public void setSessionId(BigInteger sessionId) {
        this.sessionId = sessionId;
    }

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getFreeFlow() {
        return freeFlow;
    }

    public void setFreeFlow(String freeFlow) {
        this.freeFlow = freeFlow;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public int getNewRequest() {
        return newRequest;
    }

    public void setNewRequest(int newRequest) {
        this.newRequest = newRequest;
    }

    public List<String> getMenus() {
        return menus;
    }

    public void setMenus(List<String> menus) {
        this.menus = menus;
    }
    
    

}
