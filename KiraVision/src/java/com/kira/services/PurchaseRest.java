/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.services;

import com.kira.beans.NewPurchase;
import com.kira.beans.PurchaseResponsePOS;
import com.kira.ejbs.PurchasesEjb;
import com.kira.ussd.utilities.CommonLibrary;
import java.io.InputStream;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author AOS
 */
@Stateless
@Path("/purchases")
public class PurchaseRest {
    @EJB
    PurchasesEjb purchasesEjb;
    @Path("/newpurchase")
    @POST
    public String newPurchase(InputStream is) throws Exception
    {
        String json =CommonLibrary.inputStream2String(is);
        System.out.println(json);
        ObjectMapper mapper = new ObjectMapper();
        NewPurchase purchase = new NewPurchase();
        purchase = (NewPurchase)mapper.readValue(json,NewPurchase.class);
      return  purchasesEjb.newTransaction(purchase);
        
    }
    
}
