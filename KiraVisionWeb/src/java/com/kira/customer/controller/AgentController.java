/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.customer.controller;

import com.kira.customer.beans.CommercialAgent;
import com.kira.customer.beans.CommercialAgents;
import com.kira.ussd.utilities.CommonLibrary;
import com.settings.beans.User;
import com.settings.controller.LoginController;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Hp
 */
@SessionScoped
@ManagedBean(name="agent")
public class AgentController implements Serializable{
  private CommercialAgents commercialAgents=new CommercialAgents();
  private CommercialAgent commercialAgent=new CommercialAgent() ;
  private String leftPage;
  private String leftTitle;
 
 
    public String listCommercialAgents() throws Exception
    {
        String url ="http://localhost:8080/KiraVision/commercialagent/allagents";
        Response response = CommonLibrary.sendRESTRequest(url, "", MediaType.TEXT_PLAIN, "GET");
        if(response.getStatus()==200)
        {
          String agentsxml = response.readEntity(String.class);
         CommercialAgents  agents = new CommercialAgents();
         agents  =(CommercialAgents) CommonLibrary.unmarshalling(agentsxml, CommercialAgents.class);
         System.out.println(agentsxml);
         this.setCommercialAgents(agents);
          System.out.println("returning agents  ");
      //    System.out.println(getLogin().getLoginUser().getUsername());
        }
        else
        {
            System.out.println(response.readEntity(String.class));
        }
        this.setLeftPage("agentsStatistics.xhtml");
      this.setLeftTitle("Statistics on Commerial Agents");
      FacesContext.getCurrentInstance().getExternalContext().redirect("/KiraVisionWeb/coagent/agentsIndex.xhtml");
      
      
      return null;
    }

   public String newCommercialAgent()
   {
       CommercialAgent coag = new CommercialAgent();
       coag= this.getCommercialAgent();
     if(coag.getAgentPhone().trim().length()==0)
     {
     coag=null;  
       
     }
     String url ="http://localhost:8080/KiraVision/commercialagent/newagent";
        String agentxml = CommonLibrary.marchalling(this.getCommercialAgent(), CommercialAgent.class);
        Response response = CommonLibrary.sendRESTRequest(url,agentxml, MediaType.APPLICATION_XML, "POST");
    if(response.getStatus()==200)
    {
       this.setCommercialAgent(new CommercialAgent()); 
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info!", "Commercial Agent successfully added."));
 
    }
   else
    {
     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", "Error happened. See Administrator for assistance"));
    }
       return null;
   }
    
    
    
    public void sidenavigation(String page, String title)
    {
        this.setLeftPage(page);
        this.setLeftTitle(title);
    }

    /**
     * @return the commercialAgents
     */
    public CommercialAgents getCommercialAgents() {
        return commercialAgents;
    }

    /**
     * @param commercialAgents the commercialAgents to set
     */
    public void setCommercialAgents(CommercialAgents commercialAgents) {
        this.commercialAgents = commercialAgents;
    }

    /**
     * @return the commercialAgent
     */
    public CommercialAgent getCommercialAgent() {
        return commercialAgent;
    }

    /**
     * @param commercialAgent the commercialAgent to set
     */
    public void setCommercialAgent(CommercialAgent commercialAgent) {
        this.commercialAgent = commercialAgent;
    }

    /**
     * @return the leftPage
     */
    public String getLeftPage() {
        return leftPage;
    }

    /**
     * @param leftPage the leftPage to set
     */
    public void setLeftPage(String leftPage) {
        this.leftPage = leftPage;
    }

    /**
     * @return the leftTitle
     */
    public String getLeftTitle() {
        return leftTitle;
    }

    /**
     * @param leftTitle the leftTitle to set
     */
    public void setLeftTitle(String leftTitle) {
        this.leftTitle = leftTitle;
    }

    

}