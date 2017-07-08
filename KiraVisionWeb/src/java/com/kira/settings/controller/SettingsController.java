/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.settings.controller;

import com.kira.ussd.utilities.CommonLibrary;
import com.settings.beans.User;
import com.settings.beans.Users;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author AOS
 */
@Stateless
@SessionScoped
@ManagedBean(name="settingsController")
public class SettingsController implements Serializable {
    String rooturl = "http://localhost:8080/KiraVision/users/";
    public SettingsController()
    {
        
    }
     private String leftPageMenu;
      private String pageTitle;
      private User newuser = new User();
   private Users sysUsers = new Users();
   
  public void listUsers() throws Exception
  {
     
     String url = rooturl+"list";
     Response response = CommonLibrary.sendRESTRequest(url, "", MediaType.APPLICATION_XML, "GET");
     String xml = response.readEntity(String.class);
    // System.out.println(xml);
     System.out.println(response.getStatus());
    if(response.getStatus()==200)
    {
        this.setSysUsers((Users) CommonLibrary.unmarshalling(xml, Users.class));
    }
      //System.out.println(this.getSysUsers().getListUsers().size());
      this.setLeftPageMenu("users.xhtml");
     this.setPageTitle("Users");
      FacesContext.getCurrentInstance().getExternalContext().redirect("..//settings/settings.xhtml");
     
  }
  public void addNewUser()
  {
      
      String url = rooturl+"adduser";
      String xml = CommonLibrary.marchalling(this.getNewuser(), User.class);
      Response response = CommonLibrary.sendRESTRequest(url, xml, MediaType.APPLICATION_XML, "POST");
      
      if(response.getStatus()==200)
      {
          this.getSysUsers().getListUsers().add(0,this.getNewuser());
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info!","The new User is added successfully!"));

      }
      
      else
      {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!","The User could not be added. Either login id is given or See the Administrator!"));
   
      }
      
    
  }

  
    /**
     * @return the pageTitle
     */
    public String getPageTitle() {
        return pageTitle;
    }

    /**
     * @param pageTitle the pageTitle to set
     */
    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    /**
     * @return the leftPageMenu
     */
    public String getLeftPageMenu() {
        return leftPageMenu;
    }

    /**
     * @param leftPageMenu the leftPageMenu to set
     */
    public void setLeftPageMenu(String leftPageMenu) {
        this.leftPageMenu = leftPageMenu;
    }

    /**
     * @return the sysUsers
     */
    public Users getSysUsers() {
        return sysUsers;
    }

    /**
     * @param sysUsers the sysUsers to set
     */
    public void setSysUsers(Users sysUsers) {
        this.sysUsers = sysUsers;
    }

    /**
     * @return the newuser
     */
    public User getNewuser() {
        return newuser;
    }

    /**
     * @param newuser the newuser to set
     */
    public void setNewuser(User newuser) {
        this.newuser = newuser;
    }


}
