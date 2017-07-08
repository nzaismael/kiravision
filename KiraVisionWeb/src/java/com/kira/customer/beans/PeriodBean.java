/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.customer.beans;

/**
 *
 * @author AOS
 */
public class PeriodBean {
    
  public PeriodBean()
   {
      /* this.setFrom(new java.util.Date());
       this.setTo(new java.util.Date());*/
   }
    private java.util.Date from;
    private java.util.Date to;

    /**
     * @return the from
     */
    public java.util.Date getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(java.util.Date from) {
        this.from = from;
    }

    /**
     * @return the to
     */
    public java.util.Date getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(java.util.Date to) {
        this.to = to;
    }
    
    
    
    
}
