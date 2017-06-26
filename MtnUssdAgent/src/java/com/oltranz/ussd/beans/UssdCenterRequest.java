/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oltranz.ussd.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aimable
 */
@XmlRootElement(name = "COMMAND")
@XmlAccessorType(XmlAccessType.FIELD)
public class UssdCenterRequest {

    @XmlElement(name = "MSISDN")
    private String msisdn;

    @XmlElement(name = "NEWREQUEST")
    private int newRequest;

    @XmlElement(name = "SPID")
    private String spid;

    @XmlElement(name = "AGENTID")
    private String agentId;

    @XmlElement(name = "SESSIONID")
    private Long sessionId;

    @XmlElement(name = "INPUT")
    private String input;

    public UssdCenterRequest() {
    }

    public UssdCenterRequest(String msisdn, int newRequest, String spid, String agentId, Long sessionId, String input) {
        this.msisdn = msisdn;
        this.newRequest = newRequest;
        this.spid = spid;
        this.agentId = agentId;
        this.sessionId = sessionId;
        this.input = input;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public int getNewRequest() {
        return newRequest;
    }

    public void setNewRequest(int newRequest) {
        this.newRequest = newRequest;
    }

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

}
