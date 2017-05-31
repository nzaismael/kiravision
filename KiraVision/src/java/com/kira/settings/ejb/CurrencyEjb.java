/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.settings.ejb;

import com.kira.settings.entities.CurrencyBean;
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
public class CurrencyEjb {
    @PersistenceContext
    EntityManager em;
    
    public List<CurrencyBean> listCurrencies()
  {
      Query q =em.createQuery("select cu from CurrencyBean cu ");
      return q.getResultList();
  }
}
