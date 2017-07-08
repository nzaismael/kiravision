/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.settings.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AOS
 */
@Entity
@Table(name = "Operations")
@XmlRootElement(name = "OPERATION")
@XmlAccessorType(XmlAccessType.FIELD)
public class OperationBean implements Serializable {

    @Id
    @Column(name = "id")
    @XmlElement(name = "ID")
    private int id;
    @Column(name = "operationCode", unique = true, nullable = false, length = 2)
    @XmlElement(name = "CODE")
    private String code;
    @XmlElement(name = "NAME")

    @Column(name = "operationName", length = 60, nullable = false)
    private String operatonName;

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
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the operatonName
     */
    public String getOperatonName() {
        return operatonName;
    }

    /**
     * @param operatonName the operatonName to set
     */
    public void setOperatonName(String operatonName) {
        this.operatonName = operatonName;
    }
    
    
    

}
