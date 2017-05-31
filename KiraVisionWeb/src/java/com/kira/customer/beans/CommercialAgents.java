/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.customer.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hp
 */
@XmlRootElement(name="AGENTS")
@XmlAccessorType(XmlAccessType.FIELD)
public class CommercialAgents implements Serializable {
    @XmlElement(name="COMMAGENT")
    private List<CommercialAgent> agents = new ArrayList();

    /**
     * @return the agents
     */
    public List<CommercialAgent> getAgents() {
        return agents;
    }

    /**
     * @param agents the agents to set
     */
    public void setAgents(List<CommercialAgent> agents) {
        this.agents = agents;
    }
    
    
    
}
