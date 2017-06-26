/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.settings.service;

import com.kira.settings.entities.User;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.kira.settings.ejb.*;
import com.kira.settings.entities.AccountType;
import com.kira.settings.entities.AccountTypes;
import com.kira.settings.entities.BankBean;
import com.kira.settings.entities.BanksBean;
import com.kira.settings.entities.CommissionsDistributions;
import com.kira.settings.entities.CurrenciesBean;
import com.kira.settings.entities.CurrencyBean;
import com.kira.settings.entities.Users;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
/**
 *
 * @author Hp
 */
@Stateless
@Path("users")
public class UserFacadeREST {
@EJB
    private UserEJB userEjb;
@EJB
private CurrencyEjb currencyEjb;
@EJB
private BankEjb bankEjb;
@EJB
AccountTypeEjb accountTypeEjb;
@EJB
private CommissionsDistributionEjb comejb;
    @Path("list")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Users listAllUsers()
    {
        Users users = new Users();
        users.setListUsers(getUserEjb().listAllUsers());
     return users;
    } 
    
    @Path("finduser/{userid}")
   @GET
    @Produces(MediaType.APPLICATION_XML)
    public User findUser(@PathParam("userid")String userId)
    {
        return getUserEjb().retrieveUser(userId);
    }
    @Path("activeusers")
    @GET
    public List<User> getActiveUsers()
    {
        return getUserEjb().listActiveUsers();
    }
    @Path("adduser")
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public boolean addNewUser(User user)
    {
        user.setUserPin("secret123");
        user.setCreatedOn(new java.util.Date());
        user.setModifiedOn(new java.util.Date());
        return getUserEjb().addUser(user);
        
    }
        
   
   

  @Path("login/{userid}/{ping}")
 @GET
 @Produces(MediaType.APPLICATION_XML)
public User logonUser(@PathParam("userid")String userId,@PathParam("ping")String userPin)
{
   return getUserEjb().retrieveUser(userId, userPin);
}

@Path("currency/allCurrencies")
@GET
@Produces({MediaType.APPLICATION_XML})
public CurrenciesBean returnCurrencies()
{
    System.out.println(this.getCurrencyEjb().listCurrencies().size());
    CurrenciesBean cb = new CurrenciesBean();
    cb.setCurrencies(this.getCurrencyEjb().listCurrencies());
    return cb;
  
}
@Path("bank/allBanks")
@GET
@Produces({MediaType.APPLICATION_XML})
public BanksBean returnBanks()
{
    
    //System.out.println(this.getCurrencyEjb().listCurrencies().size());
    BanksBean bb = new BanksBean();
    bb.setBanks(bankEjb.allBanks());
    return bb;
  
}

@Path("type/accounttypes")
@GET
@Produces({MediaType.APPLICATION_XML})
public AccountTypes accountTypes()
{
    
    //System.out.println(this.getCurrencyEjb().listCurrencies().size());
    AccountTypes ats = new AccountTypes();
    ats.setAccounttypes(accountTypeEjb.allAccountTypes());
    return ats;
  
}

@Path("type/accounttypes/{id}")
@GET
@Produces({MediaType.APPLICATION_XML})
public AccountType findAccountType(@PathParam("id")int id)
{
    
    //System.out.println(this.getCurrencyEjb().listCurrencies().size());
    AccountType at = new AccountType();
   return  accountTypeEjb.findAccountType(id);
  
  
}

@Path("bank/allBanks/{id}")
@GET
@Produces({MediaType.APPLICATION_XML})
public BankBean findBank(@PathParam("id")int id)
{
    
    //System.out.println(this.getCurrencyEjb().listCurrencies().size());
    BankBean bb = new BankBean();
   return bankEjb.findBank(id);
    
  
}

@Path("currency/allCurrencies/{id}")
@GET
@Produces({MediaType.APPLICATION_XML})
public CurrencyBean returnCurrencies(@PathParam("id")int id)
{
   
    CurrencyBean cb = new CurrencyBean();
    return this.getCurrencyEjb().findCurrency(id);
    
  
}

@Path("commissions/activecommissions")
@GET
@Produces(MediaType.APPLICATION_XML)
public CommissionsDistributions getAllcommissionsdistribution()
{
    CommissionsDistributions cd = new CommissionsDistributions();
    cd .setComs(comejb.allCommissionsDistribution());
   return  cd;
    
}



    /**
     * @return the userEjb
     */
    public UserEJB getUserEjb() {
        return userEjb;
    }

    /**
     * @param userEjb the userEjb to set
     */
    public void setUserEjb(UserEJB userEjb) {
        this.userEjb = userEjb;
    }

    /**
     * @return the currencyEjb
     */
    public CurrencyEjb getCurrencyEjb() {
        return currencyEjb;
    }

    /**
     * @param currencyEjb the currencyEjb to set
     */
    public void setCurrencyEjb(CurrencyEjb currencyEjb) {
        this.currencyEjb = currencyEjb;
    }

    /**
     * @return the bankEjb
     */
    public BankEjb getBankEjb() {
        return bankEjb;
    }

    /**
     * @param bankEjb the bankEjb to set
     */
    public void setBankEjb(BankEjb bankEjb) {
        this.bankEjb = bankEjb;
    }
    
}
