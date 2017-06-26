/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.settings.beans;

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
    @XmlRootElement(name="USERS")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users implements Serializable{
         @XmlElement(name="user")
    private List<User> listUsers = new ArrayList();

    /**
     * @return the listUsers
     */
    public List<User> getListUsers() {
        return listUsers;
    }

    /**
     * @param listUsers the listUsers to set
     */

    public void setListUsers(List<User> listUsers) {
        this.listUsers = listUsers;
    }
    
}
