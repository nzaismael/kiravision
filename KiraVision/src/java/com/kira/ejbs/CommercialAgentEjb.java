/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.ejbs;

import com.kira.entities.CardHolder;
import com.kira.entities.CommercialAgent;
import java.text.SimpleDateFormat;
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
public class CommercialAgentEjb {
    @PersistenceContext
private EntityManager emco;
    @EJB
    CardHolderEjb customer;
    
    public boolean addCommercialAgent(CommercialAgent agent)
    {
        try
        {
            //agent.setAgentId(this.nextCommercialAgentId());
            agent.setCreatedOn(new java.util.Date());
            agent.setModifiedOn(new java.util.Date());
            agent.setStatus(true);
            agent.setAgentType("P");
            emco.persist(agent);
            emco.flush();
            CardHolder ca= new CardHolder();
            ca.setClientEmail(agent.getAgentEmail());
            ca.setClientName(agent.getAgentName());
            ca.setClientPhone(agent.getAgentPhone());
            ca.setClientPin(agent.getAgentPin());
            ca.setClientSurname(agent.getAgentSurname());
            ca.setCreatedOn(agent.getCreatedOn());
            ca.setModifiedOn(agent.getModifiedOn());
            ca.setStatus(true);
            ca.setParent(agent);
            
            customer.addCardHolder(ca);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
        public boolean editCommercialAgent(CommercialAgent agent)
        {
            try
        {
            agent.setModifiedOn(new java.util.Date());
            emco.merge(agent);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
        }
        
 public String nextCommercialAgentId()
 {
     SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyHHmmssSS");
      return sdf.format(new java.util.Date());
 }
        
   public List<CommercialAgent> allCommercialAgents() 
   {
       Query q = emco.createQuery("select co from CommercialAgent co ");
       return q.getResultList();
       
       
   }
   
   public List<CommercialAgent> activeCommercialAgents()
   {
      Query q = emco.createQuery("select co from CommercialAgent co where co.status =true");
       return q.getResultList(); 
   }
   
   public CommercialAgent agentbyPhonepin(String phone,String pin)
   {
       Query q = emco.createQuery("select co from CommercialAgent co where co.agentPhone=:phone and co.agentPin=:pin");
       q.setParameter("phone",phone);
       q.setParameter("pin", pin);
     List<CommercialAgent> agents = q.getResultList();
     if(agents.size()>0)
     {
         return agents.get(0);
     }
     else
     {
         return null;
     }
   }
   
}
