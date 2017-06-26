/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.sms.services;


import com.kira.sms.beans.SendParameter;
import com.kira.sms.client.KsendRequestType;
import com.kira.sms.client.Ksms;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
    public void sendnotification(SendParameter parameters)
    {
        KsendRequestType ksend = new KsendRequestType();
        ksend.setAccount(parameters.getAccount());
        ksend.setMessage(parameters.getMessage());
        ksend.setPhone(parameters.getPhone());
        ksend.setPin(parameters.getPin());
        ksend.setSender(parameters.getSender());
        Ksms ksms = new Ksms();
        ksms.getKsmsPort().ksend(ksend);
   
    }
    
}
