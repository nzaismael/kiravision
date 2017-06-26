/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oltranz.ussd.beans;

import java.io.Serializable;
import java.math.BigInteger;

/**
 *
 * @author aimable
 */
public class UssdRequest implements Serializable {

    private String input;

    private Long sessionID;

    private String msisdn;

    private int newRequest;
    
    private String datetime;
    
    private BigInteger transactionID;
    
    private String spId;
    
    private String agentId;

    public UssdRequest() {
    }

    public UssdRequest(String input, Long sessionID, String msisdn, int newRequest, String datetime, BigInteger transactionID, String spId, String agentId) {
        this.input = input;
        this.sessionID = sessionID;
        this.msisdn = msisdn;
        this.newRequest = newRequest;
        this.datetime = datetime;
        this.transactionID = transactionID;
        this.spId = spId;
        this.agentId = agentId;
    }
    
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Long getSessionID() {
        return sessionID;
    }

    public void setSessionID(Long sessionID) {
        this.sessionID = sessionID;
    }

    public BigInteger getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(BigInteger transactionID) {
        this.transactionID = transactionID;
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

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getSpId() {
        return spId;
    }

    public void setSpId(String spId) {
        this.spId = spId;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }
     
    
}
