/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.utils;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import javax.ejb.Singleton;


/**
 *
 * @author ismaelnzamutuma
 */

@Singleton

public class KiraSessionManager implements Serializable {
     private ConcurrentHashMap<String, KiraUssdNavigation> missdnSessions = new ConcurrentHashMap<>();
    
     public KiraUssdNavigation checkMsisdnSession(String msisdn)
     {
       
         
         return (KiraUssdNavigation)missdnSessions.get(msisdn);
         
         
     }
     
   public void addmisdnSession(String msisdn,KiraUssdNavigation un)
   {
       missdnSessions.put(msisdn, un);
   }
 public void terminateMisdnSession(String msisdn,KiraUssdNavigation un)
   {
       missdnSessions.remove(msisdn);
   }

 
   
}
