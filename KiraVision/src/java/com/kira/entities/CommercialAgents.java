/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.entities;

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
public class CommercialAgents {
    @XmlElement(name="COMMAGENT")
    private List<CommercialAgent> listAgents = new ArrayList();

    /**
     * @return the listAgents
     */
    public List<CommercialAgent> getListAgents() {
        return listAgents;
    }

    /**
     * @param listAgents the listAgents to set
     */
    public void setListAgents(List<CommercialAgent> listAgents) {
        this.listAgents = listAgents;
    }

   
    
}
