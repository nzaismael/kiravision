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

    @Path("list")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<User> listAllUsers()
    {
     return userEjb.listAllUsers();
    } 
    
    @Path("finduser/{userid}")
   @GET
    @Produces(MediaType.APPLICATION_XML)
    public User findUser(@PathParam("userid")String userId)
    {
        return userEjb.retrieveUser(userId);
    }
    @Path("activeusers")
    @GET
    public List<User> getActiveUsers()
    {
        return userEjb.listActiveUsers();
    }
    @Path("adduser")
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public boolean addNewUser(User user)
    {
        user.setCreatedOn(new java.util.Date());
        user.setModifiedOn(new java.util.Date());
        return userEjb.addUser(user);
        
    }
        
   
   

  @Path("login/{userid}/{ping}")
 @GET
 @Produces(MediaType.APPLICATION_XML)
public User logonUser(@PathParam("userid")String userId,@PathParam("ping")String userPin)
{
   return userEjb.retrieveUser(userId, userPin);
}
    
}
