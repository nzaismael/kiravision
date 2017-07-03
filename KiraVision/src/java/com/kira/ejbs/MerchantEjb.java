/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.ejbs;

import com.kira.entities.MerchantBean;
import com.kira.entities.MerchantBeans;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Hp
 */
@Stateless

public class MerchantEjb {
@PersistenceContext
private EntityManager em;

public boolean addMerchant(MerchantBean merchant)  
{
    
    try
    {
       em.persist(merchant);
        return true;
    }
    catch(Exception e)
    {
        
        return false;
    }
}
   
    public MerchantBean editMerchant(MerchantBean merchant)
    {
        try
        {
            merchant.setMerchantModifiedOn(new java.util.Date());
            
            em.merge(merchant);
            em.flush();
            return merchant;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
  public MerchantBeans  listAllMerchants()
  {
      String query="select m from MerchantBean m";
      Query q = em.createQuery(query);
      MerchantBeans mb = new MerchantBeans();
      mb.setMerchants(q.getResultList());
     return mb;
  }
  
  
public MerchantBeans activeMerchants()
{
    Query q = em.createQuery("select m from MerchantBean m where m.status=true");
    MerchantBeans mb = new MerchantBeans();
    mb.setMerchants(q.getResultList());
    return mb;
}


}
