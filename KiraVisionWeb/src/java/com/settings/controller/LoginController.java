/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.settings.controller;

import com.kira.ussd.utilities.CommonLibrary;
import com.settings.beans.Navigation;
import com.settings.beans.User;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Hp
 */

@SessionScoped
@ManagedBean(name="login")
public class LoginController implements Serializable {
   @ManagedProperty(value = "#{navigation}")
    private Navigation navigation;
  @ManagedProperty(value = "#{user}")
     private User loginUser =new User();
     
     public LoginController()
     {
         
     }
     
    public void authentication() 
    {
       // getLoginUser().
     String loginUrl ="http://localhost:8080/KiraVision/users/login/"+getLoginUser().getUserId()+"/"+getLoginUser().getUserPin();
    Response response =    CommonLibrary.sendRESTRequest(loginUrl, "",MediaType.TEXT_PLAIN, "GET");
    int status = response.getStatus();
    
    navigation.setCurrentPage(null);
    if(status==200)
    {
       try
       {
           String xmlresponse = response.readEntity(String.class);
      
      // System.out.println(xmlresponse);
       this.setLoginUser((User)CommonLibrary.unmarshalling(xmlresponse, User.class));
         navigation.setCurrentPage("mainMenu/menus.xhtml");
       //  System.out.println(this.getLoginUser().getUserId());
       }
       catch(Exception e)
       {
           System.out.println(e.getMessage());
       
    }
   
        
    } 
    
    }

    /**
     * @return the navigation
     */
  
    public void initializeEnvironment()
    {
        System.out.println(loginUser.getUserSurname());
        /// initializing all parameters
    }
    
    
    public Navigation getNavigation() {
        return navigation;
    }

    /**
     * @param navigation the navigation to set
     */
    public void setNavigation(Navigation navigation) {
        this.navigation = navigation;
    }

    /**
     * @return the loginUser
     */
    public User getLoginUser() {
        return loginUser;
    }

    /**
     * @param loginUser the loginUser to set
     */
    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }
}
