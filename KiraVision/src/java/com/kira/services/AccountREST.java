/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.services;

import com.kira.ejbs.AccountEjb;
import com.kira.entities.AccountBean;
import com.kira.entities.AccountsBean;
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
 * @author AOS
 */
@Stateless
@Path("account")
public class AccountREST {
    public AccountREST()
    {
        
    }
    
    @EJB
    AccountEjb accountEjb;
  
    @Path("createAccount")
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public boolean createNewAccount(AccountBean ab)
    {
       return  accountEjb.createNewAccount(ab);
      
    }
    @Path("updateAccount")
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public boolean UpdateAccount(AccountBean ab)
    {
        return accountEjb.updateAcount(ab);
    }
    
    @Path("accountsByState/{state}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public AccountsBean accountsbyState(@PathParam("state")String state)
    {
        return accountEjb.listAccountsByState(state);
    }
    
  @Path("accountsByType/{type}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public AccountsBean accountsbyType(@PathParam("type")String type)
    {
        return accountEjb.listAccountsByType(type);
    } 
    
    @Path("allaccounts")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public AccountsBean allAccounts()
    {
        return accountEjb.listAccounts();
    }
}
