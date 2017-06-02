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
@Table(name="accountTypes")
@XmlRootElement(name="ACCOUNTTYPEBEAN")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountType  implements Serializable{
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private int id;
 @Column(length=6,unique=true,nullable=false)
 private String accountGroup;
 private String Description;

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
     * @return the accountGroup
     */
    public String getAccountGroup() {
        return accountGroup;
    }

    /**
     * @param accountGroup the accountGroup to set
     */
    public void setAccountGroup(String accountGroup) {
        this.accountGroup = accountGroup;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }
 
 
 
}
