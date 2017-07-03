/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.services;

import com.kira.beans.CommissionDetail;
import com.kira.beans.CommissionsDetails;
import com.kira.beans.NewPurchase;
import com.kira.ejbs.PurchasesEjb;
import com.kira.entities.PurchaseCommissionsDetail;
import com.kira.ussd.utilities.CommonLibrary;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
 
    @Path("/purchasestransactions")
    @GET
//    @Produces(MediaType.APPLICATION_XML)
    public String getPurchaseTransactions() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        List<CommissionDetail> comdet= new ArrayList<>();
        List<PurchaseCommissionsDetail> coms = new ArrayList<>();
        coms =purchasesEjb.purchases();
      //  if(coms!=null && coms.size()>0)
        //{
        coms.parallelStream()
                .map(com->{
                return new CommissionDetail(com);
                })
              .forEach(comdet::add);
        
        
        
      CommissionsDetails comdets = new CommissionsDetails();       
        comdets.setComdetails(comdet);
        System.out.println("in the service "+comdets.getComdetails().size());
     return    mapper.writeValueAsString(comdets);
     //return  comdets;
    // }
      //  else
         //   return null;
     
     
    }
}
