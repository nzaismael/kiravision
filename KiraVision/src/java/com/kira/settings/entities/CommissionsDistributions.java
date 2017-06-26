/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.settings.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AOS
 */
@XmlRootElement(name="COMMISSIONS")
@XmlAccessorType(XmlAccessType.FIELD)
public class CommissionsDistributions implements Serializable{
    @XmlElement(name="COMMISSION")
    private List<CommissionsDistribution> coms = new ArrayList<>();

    /**
     * @return the coms
     */
    public List<CommissionsDistribution> getComs() {
        return coms;
    }

    /**
     * @param coms the coms to set
     */
    public void setComs(List<CommissionsDistribution> coms) {
        this.coms = coms;
    }
    
    
    
}
