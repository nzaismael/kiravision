/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.customer.controller;

import com.kira.customer.beans.CardHolder;
import com.kira.customer.beans.CardHolders;
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
    
  String cardHolderxml=CommonLibrary.marchalling(ch, CardHolder.class);
 String customersUrl="http://localhost:8080/KiraVision/cardholder/newcardholder";
 Response response ;
response = CommonLibrary.sendRESTRequest(customersUrl,cardHolderxml, MediaType.APPLICATION_XML, "POST");
if(response.getStatus()==200)
{
  this.getCardholders().add(0, ch);
  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info!","New Customer added!"));

}
else
{
 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "The Customer Could not be added. See administrator to check."));
   
}
 this.setCardHolder(new CardHolder());
  return null; 
    
}
 public void insidenavigation(String page, String title)
    {
        System.out.println("in the navigation page  "+page);
        this.setLeftPageContent(page);
        this.setLeftPageTitle(title);
        
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

   
}
