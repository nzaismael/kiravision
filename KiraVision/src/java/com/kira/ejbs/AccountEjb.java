/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.ejbs;


import com.kira.entities.AccountBean;
import com.kira.entities.AccountsBean;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author AOS
 */
@Stateless
public class AccountEjb {
    @PersistenceContext
    EntityManager em;
    
   public AccountBean createNewAccount(AccountBean ab){
       
       try
       {
       ab.setCreatedOn(new java.util.Date());
       ab.setModifiedOn(new java.util.Date());
       ab.setAccountOwner("-");
       ab.setAccountType("A");
       ab.setAccountNumber(this.newAccountNumber(ab.getAccountSchema().getAccountGroup()));  
       
       
       em.persist(ab);
       return ab;
       }
       catch(Exception e)
       {
           System.out.println(e.getMessage());
       ab.setAccountNumber(null);
       return ab;
     
       }
   }
   public boolean updateAcount(AccountBean ab)
   {
       try
       {
       em.merge(ab);
       return true;
       }
       catch(Exception e)
       {
       return false;
       } 
   }
   
public AccountsBean listAccounts()
{
    Query q = em.createQuery("select a from AccountBean a  ");
   List<AccountBean> accounts = new ArrayList<>();
   accounts=q.getResultList();
   AccountsBean abs = new AccountsBean();
   abs.setAccounts(accounts);
return abs;   
}

  
public AccountsBean listAccountsByState(String state)
{
    Query q = em.createQuery("select a from AccountBean a where a.state=:state");
    q.setParameter("state", state);
    List<AccountBean> accounts = new ArrayList<>();
    accounts=q.getResultList();
    AccountsBean abs = new AccountsBean();
    abs.setAccounts(accounts);
return abs;   
}
  
public AccountsBean listAccountsByType(String type)
{
    Query q = em.createQuery("select a from AccountBean a where a.accountType=:type");
    q.setParameter("type", type);
    List<AccountBean> accounts = new ArrayList<>();
    accounts=q.getResultList();
    AccountsBean abs = new AccountsBean();
    abs.setAccounts(accounts);
return abs;   
}


public String newAccountNumber(String group)
{
    
   Query q = em.createQuery("select max(ab.accountNumber)+1 from AccountBean ab where ab.accountSchema.accountGroup=:group");
   q.setParameter("group", group);
   List<Integer> nextAccount = new ArrayList();
   nextAccount = q.getResultList();
   if(nextAccount.size()>0)
   {
       return ""+nextAccount.get(0);
   }
   else
   {
    return group+"0001";   
   }
    
}
}
