/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.customer.controller;

import com.kira.customer.beans.AccountBean;
import com.kira.customer.beans.AccountsBean;
import com.kira.ussd.utilities.CommonLibrary;
import com.settings.controller.LoginController;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
@ManagedBean(name="accountController")
public class AccountController implements Serializable {
    private String pageTitle;
    private String contentPage;
    private AccountsBean accounts = new AccountsBean();
    AccountBean accountBean=new AccountBean();
    @ManagedProperty(value = "#{login}")
    private LoginController login;
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
}
