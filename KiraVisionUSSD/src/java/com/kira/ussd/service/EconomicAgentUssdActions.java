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
import javax.ws.rs.core.Response;
import ussd.kira.messageResources.BundleResourceManager;

/**
 *
 * @author Hp
 */

@Path("agentsactions")
@Stateless
public class EconomicAgentUssdActions {
  @EJB
    private KiraSessionManager kirassessionManager;
   
   @EJB
    private BundleResourceManager messagesmanager;
    
    @Path("actions")
    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
 public String agentMenus(UssdRequest urb)
{
   String nextValue="";
        KiraUssdNavigation un = new KiraUssdNavigation();
       UssdResponse urs = new UssdResponse();  
       un=(KiraUssdNavigation)this.getKirassessionManager().checkMsisdnSession(urb.getMsisdn());
       long elapsedTime = (new java.util.Date().getTime()-un.getLastAccessed().getTime())/1000;
       if(un.getNextValue2()==null)
       {
           nextValue="agentMainMenu";
       }
    switch(nextValue)
            {
        case  "agentMainMenu"  :      
        urs.setAgentId(urb.getAgentId());
        urs.setFreeFlow("FC");
        urs.setMenuTitle("Choisir^^");
        List<String> list1=new ArrayList();
        list1.add("11. New Customer^");
        list1.add("2. My Customers^");
        list1.add("3. Card Remittance^");
        list1.add("4. My Account^");
        list1.add("5. Change Pin^");
       urs.setMenus(list1);
       urs.setMsisdn(urb.getMsisdn());
       urs.setNew_request("0");
       urs.setSessionId(urb.getSessionId());
       urs.setSpId(urb.getSpId());
       un.setNextValue2("actionstoacton");
       
       un.setLastAccessed(new java.util.Date());
      this.getKirassessionManager().addmisdnSession(urb.getMsisdn(), un);
        break;
        
        case "actionstoacton" :
        un.setAgentchosenMenu(urb.getInput());
        un.setLastAccessed(new java.util.Date());
        un.setNextValue2("agentactions");
       this.getKirassessionManager().addmisdnSession(urb.getMsisdn(), un);
       
        case "customeractions" :
           switch(un.getAgentchosenMenu()) 
           {
               case "11": // new Customer
                  String newCustomerUrl="http://localhost:8080/KiraVisionUSSD/newcustomer/newcustomermenus"; 
                 Response newcustomerresponse = CommonLibrary.sendRESTRequest(newCustomerUrl, CommonLibrary.marchalling(urb, UssdRequest.class), MediaType.APPLICATION_XML, "POST");
                   String newcastumerxml= newcustomerresponse.readEntity(String.class);
                    urs = (UssdResponse)CommonLibrary.unmarshalling(newcastumerxml, UssdResponse.class);
                 break;
               
           }
           
            
            
         break;
        
        
        
      //   case "" 
        
            }
     return CommonLibrary.marchalling(urs, UssdResponse.class);
 //return "NZAMUTUMA ISMAEL";   
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
     * @return the nextValue
     */
   
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
