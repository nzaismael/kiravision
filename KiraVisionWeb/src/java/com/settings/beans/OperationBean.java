/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.settings.beans;

import java.io.Serializable;

/**
 *
 * @author AOS
 */
public class OperationBean implements Serializable{
  private int id;
  private String code;
  private String Operation;

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
     * @return the Operation
     */
    public String getOperation() {
        return Operation;
    }

    /**
     * @param Operation the Operation to set
     */
    public void setOperation(String Operation) {
        this.Operation = Operation;
    }
  
  
   
}
