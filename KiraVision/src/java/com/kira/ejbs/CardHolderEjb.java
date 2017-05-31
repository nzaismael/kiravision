/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.ejbs;

import com.kira.entities.CardHolder;
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
public class CardHolderEjb {
    @PersistenceContext
private EntityManager em;
  
    public boolean addCardHolder(CardHolder cardholder)
    {
        try
        {
            cardholder.setCreatedOn(new java.util.Date());
            cardholder.setModifiedOn(new java.util.Date());
            em.persist(cardholder );
            return true;
        }
        catch(Exception e)
        {
            System.out.println("Error while adding a new card holder. \n"+e.getMessage());
            return false;
        }
    }
        public boolean editcardholder(CardHolder cardholder)
        {
     try
        {
          
            cardholder.setModifiedOn(new java.util.Date());
            em.merge(cardholder );
            return true;
        }
        catch(Exception e)
        {
            System.out.println("Error while adding a new card holder. \n"+e.getMessage());
            return false;
        }   
    }
   
        public List<CardHolder> allCardHolders()
        {
            Query q = em.createQuery("select ch from CardHolder ch");
            return q.getResultList();
        }
        public List<CardHolder> activeCardHolders()
        {
            Query q = em.createQuery("select ch from CardHolder ch where ch.status=true ");
            return q.getResultList();
        }
    
        
        public CardHolder getcardHolderbyPhone(String phone)
        {
            Query q = em.createQuery("select ch from CardHolder ch  where ch.clientPhone=:phone");
            q.setParameter("phone", phone);
            try
            {
            return (CardHolder) q.getSingleResult();
            }
            catch(Exception e)
            {
                return null;
            }
        }
        
        public CardHolder getCardHolderbyPhonepin(String phone,String pin)
        {
             Query q = em.createQuery("select ch from CardHolder ch  where ch.clientPhone=:phone and ch.clientPin=:pin");
            q.setParameter("phone", phone);
            q.setParameter("pin", pin);
            try
            {
            return (CardHolder) q.getSingleResult();
            } catch(Exception e){return null;}
        }
        
        
        
}
