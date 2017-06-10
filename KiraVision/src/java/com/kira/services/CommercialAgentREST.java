/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.services;

import com.kira.ejbs.CommercialAgentEjb;
import com.kira.entities.CommercialAgent;
import com.kira.entities.CommercialAgents;
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
@Path("commercialagent")
public class CommercialAgentREST {
    @EJB
   private CommercialAgentEjb agentEjb;
    
    @Path("allagents")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public CommercialAgents allCommercialAgents()
    {
      CommercialAgents agents = new CommercialAgents();
      agents.setListAgents(agentEjb.allCommercialAgents());
        return agents;
    }
    
    @Path("newagent")
    @POST
    @Consumes(MediaType.APPLICATION_XML)
      public boolean addnewAgent(CommercialAgent agent)
    {
      return agentEjb.addCommercialAgent(agent);
    }
    
    @Path("editagent")
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public boolean editAgent(CommercialAgent agent)
    {
        return agentEjb.editCommercialAgent(agent);
    }
   
   @Path("agentbyphone/{phone}/{pin}")
   @GET
   @Produces(MediaType.APPLICATION_XML)
   public CommercialAgent getCommercialagentbyphonepin(@PathParam("phone")String phone,@PathParam("pin")String pin)
   {
      return agentEjb.agentbyPhonepin(phone, pin);
      // return null;
   }        
           
   @Path("agentbyphone/{phone}")
   @GET
   @Produces(MediaType.APPLICATION_XML)
   public CommercialAgent getCommercialagentbyPhone(@PathParam("phone")String phone)
   {
      return agentEjb.agentByPhone(phone);
      // return null;
   }        
            
    
}
