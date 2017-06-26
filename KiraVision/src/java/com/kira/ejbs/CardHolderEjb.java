/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.ejbs;

import com.kira.entities.CardHolder;
import com.kira.entities.CommercialAgent;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
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
    @EJB 
    CommercialAgentEjb comejb;
    public boolean addCardHolder(CardHolder cardholder)
    {
        
       try
        {
            cardholder.setCreatedOn(new java.util.Date());
            CommercialAgent ag =new CommercialAgent();
            ag=cardholder.getParent();
         
        if(ag==null) 
        {
            CommercialAgent ag1 = new CommercialAgent();
            ag1.setAgentEmail(cardholder.getClientEmail());
            ag1.setAgentName(cardholder.getClientName());
            ag1.setAgentPhone(cardholder.getClientPhone());
            ag1.setAgentSurname(cardholder.getClientSurname());
           comejb.addCommercialAgent(ag1);
           return true;
        }
        else
        {
         //   System.out.println("in the card holder addition "+ag.getAgentPhone());
        CommercialAgent ag2 = comejb.agentByPhone(ag.getAgentPhone());
           if(ag.getAgentId()!=null)
           {
            CardHolder ch ;
            ch= this.getcardHolderbyPhone(ag.getAgentPhone());
            System.out.println(ch.getClientEmail());
              cardholder.setParent(ch.getChild());
              cardholder.setChild(ch.getGrandChild());
              cardholder.setGrandChild(ag);
              em.persist(cardholder);
           }
           else
           {
              /* CommercialAgent cag= new CommercialAgent();
               cag.setAgentEmail(cardholder.getClientEmail());
               cag.setAgentName(cardholder.getClientName());
               cag.setAgentPhone(cardholder.getClientPhone());
               cag.setAgentSurname(cardholder.getClientSurname());*/
              CommercialAgent parent = comejb.addCommercialAgent(ag, true);
              CardHolder ca=this.getcardHolderbyPhone(ag.getAgentPhone());
              System.out.println(parent.getAgentId());
              cardholder.setParent(ca.getChild());
              cardholder.setChild(ca.getGrandChild());
              cardholder.setGrandChild(parent);
              em.persist(cardholder );
           }
             
              return true;
       
           
            
            
        
        }
            }
        catch(Exception e)
        {
            System.out.println("Error while adding a new card holder. "+e.getMessage());
            return false;
        }
    }
    
  public void   addCardHolder(CardHolder cardHolder,boolean agent)
  {
      em.persist(cardHolder);
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
            List<CardHolder> cards = new ArrayList<>();
            try
            {
                cards=q.getResultList();
                if(cards.size()>0)
            return (CardHolder) cards.get(0);
                else
                    return null;
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
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
        
 public CardHolder getCardHolderByCardNumber(String cardNumber)
 {
     Query q = em.createQuery("select ch from CardHolder ch  where ch.cardNumber=:cardNumber");
            q.setParameter("cardNumber", cardNumber);
            
            try
            {
            return (CardHolder) q.getSingleResult();
            } catch(Exception e){return null;}
 }
        
}
