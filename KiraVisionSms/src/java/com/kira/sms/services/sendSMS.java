/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.sms.services;



import com.esicia.gateway.soap.ksms.KsendRequestType;
import com.esicia.gateway.soap.ksms.KsendResponseType;
import com.esicia.gateway.soap.ksms.Ksms;
import com.kira.sms.beans.SendParameter;
import java.io.InputStream;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author AOS
 */
@Stateless
@Path("smsnotification")
public class sendSMS {
    
  @POST
  @Path("newsms")
  @Consumes(MediaType.APPLICATION_XML)
  @Produces(MediaType.APPLICATION_XML)
    public void  sendnotification(SendParameter parameters)
    {
        KsendRequestType ksend1 = new KsendRequestType();
        ksend1.setAccount(parameters.getAccount());
        ksend1.setMessage(parameters.getMessage());
        ksend1.setPhone(parameters.getPhone());
        ksend1.setPin(parameters.getPin());
        ksend1.setSender(parameters.getSender());
        ksend1.setCallurl("");
        ksend1.setMessagetype("");
        ksend1.setMsgid("2");
        ksend1.setReceivedlr("");
        
         Ksms ksms = new Ksms();
     
      ksms.getKsmsPort().ksend(ksend1);
  
  //  System.out.println(kresponse.getBalance()) ;
     
        
    }
    @Path("/smsresponse")
    @POST
 public void    receiveResponse(InputStream is)
 {
     System.out.println(CommonLibrary.inputStream2String(is));
 }
}
