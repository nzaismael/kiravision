/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.settings.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AOS
 */
@Entity
@Table(name="banks")
@XmlRootElement(name="BANK")
@XmlAccessorType(XmlAccessType.FIELD)
public class BankBean implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(length=30,unique=true,nullable=false)
    
    private String bankshot;
    private String bankFull;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the bankshot
     */
    public String getBankshot() {
        return bankshot;
    }

    /**
     * @param bankshot the bankshot to set
     */
    public void setBankshot(String bankshot) {
        this.bankshot = bankshot;
    }

    /**
     * @return the bankFull
     */
    public String getBankFull() {
        return bankFull;
    }

    /**
     * @param bankFull the bankFull to set
     */
    public void setBankFull(String bankFull) {
        this.bankFull = bankFull;
    }
    
    
}
