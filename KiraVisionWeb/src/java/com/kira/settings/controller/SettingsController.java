/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.settings.controller;

import com.kira.ussd.utilities.CommonLibrary;
import javax.ejb.Stateless;
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
public class SettingsController {
     private String leftPageMenu;
      private String pageTitle;
   
  public void listUsers() throws Exception
  {
     
     String url = "http://localhost:8080/KiraVision/users/list";
     Response response = CommonLibrary.sendRESTRequest(url, "", MediaType.APPLICATION_XML, "GET");
     String xml = response.readEntity(String.class);
    
      
      this.setLeftPageMenu("users.xhtml");
     this.setPageTitle("Users");
      FacesContext.getCurrentInstance().getExternalContext().redirect("/KiraVisionWeb/settings/settings.xhtml");
     
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

}
