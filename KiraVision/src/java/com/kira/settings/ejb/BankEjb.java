/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.settings.ejb;

import com.kira.settings.entities.BankBean;
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
public class BankEjb {
    @PersistenceContext
    EntityManager em;
  public List<BankBean> allBanks()
  {
      Query q = em.createQuery("select b from BankBean b  ");
      return q.getResultList();
  }
    
}
