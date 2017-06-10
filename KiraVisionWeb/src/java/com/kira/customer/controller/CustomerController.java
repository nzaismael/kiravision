/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.customer.controller;

import com.kira.customer.beans.CardHolder;
import com.kira.customer.beans.CardHolders;
import com.kira.customer.beans.CommercialAgent;
import com.kira.ussd.utilities.CommonLibrary;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@ManagedBean(name="customer")
public class CustomerController implements Serializable {
     private List<CardHolder> cardholders = new ArrayList();
     private CardHolder cardHolder = new CardHolder();
     private CommercialAgent commagent = new CommercialAgent();
              private CardHolder chparent;
              private CardHolder chchild ;
              private CardHolder chgrandchild ;
      private String leftPageContent;
      private String leftPageTitle;
      private Date verification;
      public void CustomerController()
      {
          
      }
  public String listCustomers() throws Exception
  {
     
      
      String customersUrl="http://localhost:8080/KiraVision/cardholder/allcardholders";
        Response response = CommonLibrary.sendRESTRequest(customersUrl, " ", MediaType.TEXT_PLAIN,"GET");
    System.out.println("in the list of all customers");
if(response.getStatus()==200)
{
            String customersxml = response.readEntity(String.class);
            
            CardHolders  listCustomers = new CardHolders();
            listCustomers = (CardHolders)CommonLibrary.unmarshalling(customersxml, CardHolders.class);
            setCardholders(listCustomers.getCustomers());
           this.setLeftPageContent("customersStatistics.xhtml");
           this.setLeftPageTitle("Customers Statistics");
}   
   
   
FacesContext.getCurrentInstance().getExternalContext().redirect("/KiraVisionWeb/customer/customersIndex.xhtml");
 
   return null;
  }
public String saveNewCustomer() throws Exception
{
    this.setVerification(new java.util.Date());
   CardHolder ch=new CardHolder();
    ch=this.getCardHolder();
    ch.setClientPin("000000");
    ch.setStatus(true);
  CardHolder ctem = new CardHolder();
ctem=this.getChparent();
System.out.println("before chparent checkup ");
CommercialAgent ca ;
if(this.getChparent()!=null)
{
    ctem=this.getChparent();
String agenturl ="http://localhost:8080/KiraVision/commercialagent/agentbyphone/"+this.getChparent().getClientPhone();
Response response1 = CommonLibrary.sendRESTRequest(agenturl, "", MediaType.APPLICATION_XML,"GET");
int status = response1.getStatus();
String agentxml = response1.readEntity(String.class);
System.out.println(agentxml);
if(status==200)
{
    System.out.println("the commercial agent is found.");
    ca=(CommercialAgent)CommonLibrary.unmarshalling(agentxml, CommercialAgent.class);
   ch.setParent(ca);
   ch.setChild(null);
  ch.setChild(null);
}
else
{
    System.out.println("not found in the agents");
    String churl ="http://localhost:8080/KiraVision/cardholder/cardholderphone/"+this.getChparent().getClientPhone();
     Response chresponse = CommonLibrary.sendRESTRequest(churl, "", MediaType.TEXT_PLAIN, "GET");
     String chxml = chresponse.readEntity(String.class);
     CardHolder cardHolder = new CardHolder();
     cardHolder=(CardHolder)CommonLibrary.unmarshalling(chxml, CardHolder.class);
     CommercialAgent age= new CommercialAgent();
     age.setAgentEmail(cardHolder.getClientEmail());
     age.setAgentName(cardHolder.getClientName());
     age.setAgentPhone(cardHolder.getClientPhone());
     age.setAgentSurname(cardHolder.getClientSurname());
    ch.setParent(age);
    ch.setChild(null);
    ch.setGrandChild(null);
}

}
else
{
    ch.setParent(null);
    ch.setChild(null);
    ch.setGrandChild(null);
}

  String cardHolderxml=CommonLibrary.marchalling(ch, CardHolder.class);
  System.out.println("card holder :"+cardHolderxml);
 String customersUrl="http://localhost:8080/KiraVision/cardholder/newcardholder";
 Response response ;

response = CommonLibrary.sendRESTRequest(customersUrl,cardHolderxml, MediaType.APPLICATION_XML, "POST");
int status1 = response.getStatus();
boolean saved  = Boolean.parseBoolean(response.readEntity(String.class));
if(response.getStatus()==200)
{
  this.getCardholders().add(0, ch);
  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info!","New Customer added!"));

}
else
{
 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "The Customer Could not be added. See administrator to check."));
   
}
this.setChparent(null);
 this.setCardHolder(new CardHolder());
  return null; 
  
}
 public void insidenavigation(String page, String title)
    {
        System.out.println("in the navigation page  "+page);
        this.setCardHolder(new CardHolder());
        this.setChparent(new CardHolder());
        this.setLeftPageContent(page);
        this.setLeftPageTitle(title);
        
    }  

 public String  customerParenthoud() 
 {
     try
     {
    String phone = this.getCardHolder().getParent().getAgentPhone();
     String agenturl ="http://localhost:8080/KiraVision/cardholder/cardholderphone/"+phone;
     Response response = CommonLibrary.sendRESTRequest(agenturl, "", MediaType.TEXT_PLAIN, "GET");
     String agentxml = response.readEntity(String.class);
     CardHolder cardHolder = new CardHolder();
     cardHolder=(CardHolder)CommonLibrary.unmarshalling(agentxml, CardHolder.class);
     if(cardHolder!=null)
     {
     this.setChparent(cardHolder);
     
     }
     else
     {
         this.setChparent(new CardHolder());
     }
     }
     catch(Exception e)
     {
         System.out.println(e.getMessage());
     }
     
     //System.out.println("in the parenthoud "+this.getCommagent().getAgentEmail());
     return null;
 }
 
 public void insidenavigationDetails(String page, String title,Object obj)
    {
        System.out.println("in the navigation page  "+page);
        
        this.setLeftPageContent(page);
        this.setLeftPageTitle(title);
        this.setCardHolder((CardHolder)obj);
        
    }  
 
 
 
 

/**
     * @return the cardholders
     */
    public List<CardHolder> getCardholders() {
        return cardholders;
    }

    /**
     * @param cardholders the cardholders to set
     */
    public void setCardholders(List<CardHolder> cardholders) {
        this.cardholders = cardholders;
    }

    /**
     * @return the cardHolder
     */
    public CardHolder getCardHolder() {
        return cardHolder;
    }

    /**
     * @param cardHolder the cardHolder to set
     */
    public void setCardHolder(CardHolder cardHolder) {
        this.cardHolder = cardHolder;
    }

    /**
     * @return the leftPageContent
     */
    public String getLeftPageContent() {
        return leftPageContent;
    }

    /**
     * @param leftPageContent the leftPageContent to set
     */
    public void setLeftPageContent(String leftPageContent) {
        this.leftPageContent = leftPageContent;
    }

    /**
     * @return the leftPageTitle
     */
    public String getLeftPageTitle() {
        return leftPageTitle;
    }

    /**
     * @param leftPageTitle the leftPageTitle to set
     */
    public void setLeftPageTitle(String leftPageTitle) {
        this.leftPageTitle = leftPageTitle;
    }

    /**
     * @return the verification
     */
    public Date getVerification() {
        return verification;
    }

    /**
     * @param verification the verification to set
     */
    public void setVerification(Date verification) {
        this.verification = verification;
    }

    /**
     * @return the commagent
     */
    public CommercialAgent getCommagent() {
        return commagent;
    }

    /**
     * @param commagent the commagent to set
     */
    public void setCommagent(CommercialAgent commagent) {
        this.commagent = commagent;
    }

    /**
     * @return the chparent
     */
    public CardHolder getChparent() {
        return chparent;
    }

    /**
     * @param chparent the chparent to set
     */
    public void setChparent(CardHolder chparent) {
        this.chparent = chparent;
    }

    /**
     * @return the chchild
     */
    public CardHolder getChchild() {
        return chchild;
    }

    /**
     * @param chchild the chchild to set
     */
    public void setChchild(CardHolder chchild) {
        this.chchild = chchild;
    }

    /**
     * @return the chgrandchild
     */
    public CardHolder getChgrandchild() {
        return chgrandchild;
    }

    /**
     * @param chgrandchild the chgrandchild to set
     */
    public void setChgrandchild(CardHolder chgrandchild) {
        this.chgrandchild = chgrandchild;
    }

   
}
