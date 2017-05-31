/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.customer.controller;

import com.kira.customer.beans.MerchantBean;
import com.kira.customer.beans.MerchantBeans;
import com.kira.ussd.utilities.CommonLibrary;
import java.io.Serializable;
import java.util.Date;
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
@ManagedBean(name="partner")
public class PartnerController implements Serializable{
    private MerchantBean merchant = new MerchantBean();
    private MerchantBeans merchants = new MerchantBeans();
    private String leftPage;
    private String leftPageTitle;
    private Date verification;

    public String listPartners() throws Exception
    {
      String partnersUrl="http://localhost:8080/KiraVision/merchant/merchants";
        Response response = CommonLibrary.sendRESTRequest(partnersUrl, " ", MediaType.TEXT_PLAIN,"GET");
    System.out.println("in the list of Partners");
if(response.getStatus()==200)
{
            String partnerXml = response.readEntity(String.class);
            
            MerchantBeans mb = new MerchantBeans();
            mb = (MerchantBeans)CommonLibrary.unmarshalling(partnerXml, MerchantBeans.class);
            this.setMerchants(mb);
            
}   
this.setLeftPage("partnersStatistics.xhtml");
this.setLeftPageTitle("Statistics on Kira Vision Partners");
 FacesContext.getCurrentInstance().getExternalContext().redirect("/KiraVisionWeb/partners/partnersIndex.xhtml");
 
   return null;  
   }
    
    public void addNewPartner() throws Exception
    {
        this.setVerification(new java.util.Date());
     String partnersUrl="http://localhost:8080/KiraVision/merchant/newmerchant";
   MerchantBean mb = this.getMerchant();
   mb.setStatus(true);
   mb.setMerchantModifiedOn(new java.util.Date());
   mb.setMerchantCreatedOn(new java.util.Date());
     String merchantxml = CommonLibrary.marchalling(mb, MerchantBean.class);
       
     Response response = CommonLibrary.sendRESTRequest(partnersUrl, merchantxml, MediaType.APPLICATION_XML,"POST");
    System.out.println(merchantxml);
if(response.getStatus()==200)
{
           this.getMerchants().getMerchants().add(0, this.getMerchant());
         this.setMerchant(new MerchantBean());
}  
     
    }
  
    public void  leftNavigation(String page, String title)
    {
        this.setLeftPage(page);
        this.setLeftPageTitle(title);
    }
    
    /**
     * @return the merchant
     */
    public MerchantBean getMerchant() {
        return merchant;
    }

    /**
     * @param merchant the merchant to set
     */
    public void setMerchant(MerchantBean merchant) {
        this.merchant = merchant;
    }

    /**
     * @return the merchants
     */
    public MerchantBeans getMerchants() {
        return merchants;
    }

    /**
     * @param merchants the merchants to set
     */
    public void setMerchants(MerchantBeans merchants) {
        this.merchants = merchants;
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
