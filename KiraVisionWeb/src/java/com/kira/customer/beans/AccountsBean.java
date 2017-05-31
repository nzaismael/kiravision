/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.customer.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AOS
 */
public class AccountsBean implements Serializable {
    private List accounts = new ArrayList();

    /**
     * @return the accounts
     */
    public List getAccounts() {
        return accounts;
    }

    /**
     * @param accounts the accounts to set
     */
    public void setAccounts(List accounts) {
        this.accounts = accounts;
    }
    
}
