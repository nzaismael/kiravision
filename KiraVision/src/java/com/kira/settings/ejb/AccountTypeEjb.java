/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.settings.ejb;


import com.kira.settings.entities.AccountType;
import com.kira.settings.entities.CurrencyBean;
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
public class AccountTypeEjb {
    @PersistenceContext 
    EntityManager em;
    public List<AccountType> allAccountTypes()
    {
        Query q = em.createQuery("select at from AccountType at ");
        return q.getResultList();
    }
    
    public AccountType findAccountType(int id)
    {
        Query q = em.createQuery("select cu from AccountType cu where cu.id=:id");
        q.setParameter("id", id);
        List<AccountType> curs = new ArrayList<>();
        curs=q.getResultList();
        if(curs.size()>0)
                {
                    return curs.get(0);
                }
        else
            return null;
    }
        
}
