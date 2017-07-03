/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.services;

import com.kira.ejbs.MerchantContractEjb;
import com.kira.ejbs.MerchantEjb;
import com.kira.entities.MerchantBean;
import com.kira.entities.MerchantBeans;
import com.kira.entities.MerchantReduction;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Hp
 */
@Stateless
@Path("merchant")
public class MerchantREST {
    @EJB
    MerchantEjb merchantEjb;
     @EJB
    MerchantContractEjb contractejb;  
    @POST
    @Path("newmerchant")
    @Consumes(MediaType.APPLICATION_XML)
    public boolean addnewMerchant(MerchantBean mb)
    {
        return merchantEjb.addMerchant(mb);
    }
   @GET
   @Path("merchants")
   @Produces(MediaType.APPLICATION_XML)
   public MerchantBeans listMerchants()
   {
       MerchantBeans mb = new MerchantBeans();
       mb=merchantEjb.listAllMerchants();
       return mb;
       
   }
   
   @GET
   @Path("activemerchants")
   @Produces(MediaType.APPLICATION_XML)
   public MerchantBeans getactivemerchants()
   {
       return merchantEjb.activeMerchants();
   }
   
@GET
@Path("merchantContract/{merchantId}")
  @Produces(MediaType.APPLICATION_XML)
public MerchantReduction getMerchantcontract(@PathParam("merchantId")long merchantId)
{
    return contractejb.activeContract(merchantId);
}
   
@Path("merchantnewcontract")
@POST
@Consumes(MediaType.APPLICATION_XML)
public MerchantReduction addNewMerchantContract(MerchantReduction contract)
{
   // System.out.println("im in the contract saving");
    return contractejb.addMerchantContract(contract);
}  
@Path("/editmerchant")
@POST
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public MerchantBean editingMerchantBean(MerchantBean partner)
{
    partner.setMerchantModifiedOn(new java.util.Date());
  return  merchantEjb.editMerchant(partner);
}
}
