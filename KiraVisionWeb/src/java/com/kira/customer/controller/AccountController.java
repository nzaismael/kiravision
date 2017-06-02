/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.customer.controller;

import com.kira.customer.beans.AccountBean;
import com.kira.customer.beans.AccountsBean;
import com.kira.ussd.utilities.CommonLibrary;
import com.settings.beans.AccountType;
import com.settings.beans.AccountTypes;
import com.settings.beans.BankBean;
import com.settings.beans.BanksBean;
import com.settings.beans.CurrenciesBean;
import com.settings.beans.CurrencyBean;
import com.settings.controller.LoginController;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author AOS
 */
@Stateless
@SessionScoped
@ManagedBean(name="accountController")
public class AccountController implements Serializable {
    private String pageTitle;
    private String contentPage;
    private AccountsBean accounts = new AccountsBean();
    private AccountBean accountBean=new AccountBean();
    private CurrenciesBean currencies = new CurrenciesBean();
    private CurrencyBean currency = new CurrencyBean();
    Map<String,String> accountTypes =new LinkedHashMap<String,String>();;
    private BanksBean banks = new BanksBean();
     private BankBean bank =new BankBean();
     private AccountType accountSchema = new AccountType();
     private AccountTypes accountSchemas = new AccountTypes();
     
    @ManagedProperty(value = "#{login}")
    private LoginController login;
    @PostConstruct
    public void  AccountControllerInit()
    {
       // list currencies
        String urlcurrency="http://localhost:8080/KiraVision/users/currency/allCurrencies";
        Response rescur = CommonLibrary.sendRESTRequest(urlcurrency, "", MediaType.TEXT_PLAIN, "GET");
        String xmlCurrency = rescur.readEntity(String.class);
        setCurrencies((CurrenciesBean)CommonLibrary.unmarshalling(xmlCurrency, CurrenciesBean.class));
        
      /// listing Banks
      String urlbank="http://localhost:8080/KiraVision/users/bank/allBanks";
        Response resban = CommonLibrary.sendRESTRequest(urlbank, "", MediaType.TEXT_PLAIN, "GET");
        String xmlbank = resban.readEntity(String.class);
        setBanks((BanksBean)CommonLibrary.unmarshalling(xmlbank, BanksBean.class));
         
        /// Account Types
        
     String urltype="http://localhost:8080/KiraVision/users/type/accounttypes";
     Response restypes = CommonLibrary.sendRESTRequest(urltype, "", MediaType.TEXT_PLAIN, "GET");
        String xmltype = restypes.readEntity(String.class);
        setAccountSchemas((AccountTypes)CommonLibrary.unmarshalling(xmltype, AccountTypes.class));
        
          
    }
    
    public String haveListofAccounts() throws Exception
    {
        
        String url = "http://localhost:8080/KiraVision/account/allaccounts";
        Response response=CommonLibrary.sendRESTRequest(url, "", MediaType.TEXT_PLAIN, "GET");
        if(response.getStatus()==200)
        {
          
               String xml = response.readEntity(String.class);
           
           this.setAccounts((AccountsBean)CommonLibrary.unmarshalling(xml, AccountsBean.class));
           System.out.println(xml);
           
        }
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("/KiraVisionWeb/accounts/accounts.xhtml");
        this.setContentPage("listAccounts.xhtml");
        this.setPageTitle("List of Accounts");
        
       
      
        //System.out.println(getLogin().getLoginUser().getUsername());
        return null;
    }
  
public void changeAccountType(AjaxBehaviorEvent event)
{
  try
  {
    String urlaccountType = "http://localhost:8080/KiraVision/users/type/accounttypes/"+this.getAccountSchema().getId();
    Response response =CommonLibrary.sendRESTRequest(urlaccountType, "", MediaType.APPLICATION_XML, "GET");
    String xml = response.readEntity(String.class);
    AccountType acc = new AccountType();
    acc=(AccountType)CommonLibrary.unmarshalling(xml, AccountType.class);
    if(acc!=null)
    {
    this.setAccountSchema(acc);
    }
    else
    {
        this.setAccountSchema(new AccountType());
    }
  }
  catch(Exception e)
  {
      System.out.println(e.getMessage());
  }
    
}

public String saveAccount()
{
  this.accountBean.setAccountSchema(this.getAccountSchema());
  
  String urlbank = "http://localhost:8080/KiraVision/users/bank/allBanks/"+this.getBank().getId();
    Response response =CommonLibrary.sendRESTRequest(urlbank, "", MediaType.APPLICATION_XML, "GET");
    String xml = response.readEntity(String.class);
    BankBean bb = new BankBean();
    bb=(BankBean)CommonLibrary.unmarshalling(xml, BankBean.class);
    if(bb!=null)
    {
    this.setBank(bb);
    }
    else
    {
        this.setBank(null);
    }
  String urlcurrency = "http://localhost:8080/KiraVision/users/currency/allCurrencies/"+this.getCurrency().getId();
    Response response1 =CommonLibrary.sendRESTRequest(urlcurrency, "", MediaType.APPLICATION_XML, "GET");
    String xml1 = response1.readEntity(String.class);
    CurrencyBean cb = new CurrencyBean();
    cb=(CurrencyBean)CommonLibrary.unmarshalling(xml1, CurrencyBean.class);
    if(cb!=null)
    {
    this.setCurrency(cb);
    }
    else
    {
        this.setCurrency(null);
    }
     
    this.accountBean.setBank(this.getBank());
    this.accountBean.setCurrency(this.getCurrency());
    this.accountBean.setState("O");
    this.accountBean.setBalance(0);
    this.accountBean.setCreatedBy(login.getLoginUser());
    this.accountBean.setModifiedBy(login.getLoginUser());
    String accountxml =CommonLibrary.marchalling(this.accountBean, AccountBean.class);
  String accountsaveUrl ="http://localhost:8080/KiraVision/account/createAccount";
  System.out.println(accountxml);
  Response responsesave =CommonLibrary.sendRESTRequest(accountsaveUrl, accountxml, MediaType.APPLICATION_XML, "POST");
  String respxml;
  respxml =responsesave.readEntity(String.class);
  AccountBean ab = new AccountBean();
  ab =(AccountBean) CommonLibrary.unmarshalling(respxml, AccountBean.class);
  if(ab.getAccountNumber()!=null)
  {
      this.accounts.getListaccounts().add(0,ab);
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info!", "Account number "+ab.getAccountNumber()+"  has been created"));
 
  }
  else
  {
     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", "Account could not be created. See the System administrator"));
   
  }
  return null;
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
     * @return the contentPage
     */
    public String getContentPage() {
        return contentPage;
    }

    /**
     * @param contentPage the contentPage to set
     */
    public void setContentPage(String contentPage) {
        this.contentPage = contentPage;
    }

    /**
     * @return the accounts
     */
    public AccountsBean getAccounts() {
        return accounts;
    }

    /**
     * @param accounts the accounts to set
     */
    public void setAccounts(AccountsBean accounts) {
        this.accounts = accounts;
    }

    /**
     * @return the login
     */
    public LoginController getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(LoginController login) {
        this.login = login;
    }

    /**
     * @return the accountBean
     */
    public AccountBean getAccountBean() {
        return accountBean;
    }

    /**
     * @param accountBean the accountBean to set
     */
    public void setAccountBean(AccountBean accountBean) {
        this.accountBean = accountBean;
    }

    /**
     * @return the currencies
     */
    public CurrenciesBean getCurrencies() {
        return currencies;
    }

    /**
     * @param currencies the currencies to set
     */
    public void setCurrencies(CurrenciesBean currencies) {
        this.currencies = currencies;
    }

    /**
     * @return the currency
     */
    public CurrencyBean getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(CurrencyBean currency) {
        this.currency = currency;
    }

    /**
     * @return the banks
     */
    public BanksBean getBanks() {
        return banks;
    }

    /**
     * @param banks the banks to set
     */
    public void setBanks(BanksBean banks) {
        this.banks = banks;
    }

    /**
     * @return the bank
     */
    public BankBean getBank() {
        return bank;
    }

    /**
     * @param bank the bank to set
     */
    public void setBank(BankBean bank) {
        this.bank = bank;
    }

    /**
     * @return the accountSchema
     */
    public AccountType getAccountSchema() {
        return accountSchema;
    }

    /**
     * @param accountSchema the accountSchema to set
     */
    public void setAccountSchema(AccountType accountSchema) {
        this.accountSchema = accountSchema;
    }

    /**
     * @return the accountSchemas
     */
    public AccountTypes getAccountSchemas() {
        return accountSchemas;
    }

    /**
     * @param accountSchemas the accountSchemas to set
     */
    public void setAccountSchemas(AccountTypes accountSchemas) {
        this.accountSchemas = accountSchemas;
    }
}
