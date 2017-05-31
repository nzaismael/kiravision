/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.ussd.service;

import com.kira.ussd.utilities.CommonLibrary;
import com.kira.utils.KiraSessionManager;
import com.kira.utils.KiraUssdNavigation;
import com.kira.utils.UssdRequest;
import com.kira.utils.UssdResponse;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ussd.kira.messageResources.BundleResourceManager;

/**
 *
 * @author Hp
 */
@Path("newcustomer")
@Stateless
public class NewCustomer {
  private String nextValue;
@EJB
    private KiraSessionManager kirassessionManager;
   
   @EJB
    private BundleResourceManager messagesmanager;  

   @Path("newcustomermenus")
   @POST
   @Consumes(MediaType.APPLICATION_XML)
   public String captureCustomer(UssdRequest urb)
   {
       System.out.println("in the customer webservice");
       
       KiraUssdNavigation un = new KiraUssdNavigation();
       List<String> emptyList = new ArrayList();
       emptyList.add("");
      un = this.getKirassessionManager().checkMsisdnSession(urb.getMsisdn());
      UssdResponse urs = new UssdResponse();
      // if(un.getNextValue3()==null)
      // {
           un.setNextValue3("name");
       //}
      switch(un.getNextValue3())
       {
           case "name":
               urs.setAgentId(urb.getAgentId());
               urs.setFreeFlow("FC");
               urs.setMenuTitle("Enter the Customer Name^^ ");
               urs.setMenus(emptyList);
               urs.setMsisdn(urb.getMsisdn());
               urs.setNew_request("0");
               urs.setSessionId(urb.getSessionId());
               urs.setSpId(urb.getSpId());
            //   un.setNextValue3("surname");
              un.setLastAccessed(new java.util.Date());
              this.getKirassessionManager().addmisdnSession(urb.getMsisdn(), un);
               break;
           
       }
       
       String xml=CommonLibrary.marchalling(urs, UssdResponse.class);
       System.out.println(xml);
       return xml;
       //return CommonLibrary.marchalling(urs, UssdResponse.class);
   }
   
   
   
   
    /**
     * @return the nextValue
     */
    public String getNextValue() {
        return nextValue;
    }

    /**
     * @param nextValue the nextValue to set
     */
    public void setNextValue(String nextValue) {
        this.nextValue = nextValue;
    }

    /**
     * @return the kirassessionManager
     */
    public KiraSessionManager getKirassessionManager() {
        return kirassessionManager;
    }

    /**
     * @param kirassessionManager the kirassessionManager to set
     */
    public void setKirassessionManager(KiraSessionManager kirassessionManager) {
        this.kirassessionManager = kirassessionManager;
    }

    /**
     * @return the messagesmanager
     */
    public BundleResourceManager getMessagesmanager() {
        return messagesmanager;
    }

    /**
     * @param messagesmanager the messagesmanager to set
     */
    public void setMessagesmanager(BundleResourceManager messagesmanager) {
        this.messagesmanager = messagesmanager;
    }
 

   
}
