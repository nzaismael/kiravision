/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.services;

import com.kira.beans.CommissionDetail;
import com.kira.beans.NewPurchase;
import com.kira.beans.PurchaseCommissions;
import com.kira.ejbs.PurchasesEjb;
import com.kira.ussd.utilities.CommonLibrary;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
 
   @Path("/purchasestransactions/{from}/{to}")
   @GET
  @Produces(MediaType.APPLICATION_XML)
    public String  getPurchaseTransactions(@PathParam("from")String from,@PathParam("to")String to) throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        ObjectMapper mapper = new ObjectMapper();
        List<CommissionDetail> comdet= new ArrayList<>();
        PurchaseCommissions coms = new PurchaseCommissions();
        PurchaseCommissions comdets = new PurchaseCommissions();
     coms =purchasesEjb.purchasesCommissions(sdf.parse(from),sdf.parse(to));   
 
     Map<String, Double> totalByDept = coms.getComdetails().stream()
.collect(Collectors.groupingBy(CommissionDetail::getCommissionName,
Collectors.summingDouble(CommissionDetail::getAmount)));   
 
 
 for(String s:totalByDept.keySet())
 {
     CommissionDetail comdet1 = new CommissionDetail();
     comdet1.setAmount(totalByDept.get(s));
     comdet1.setCommissionName(s);
     comdets.getComdetails().add(comdet1); 
 }
       
    // System.out.println(comdets.getComdetails().size()) ;
  return mapper.writeValueAsString(comdets);   
    }
    
    
}
