/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.settings.ejb;

import com.kira.settings.entities.BankBean;
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
public class BankEjb {
    @PersistenceContext
    EntityManager em;
  public List<BankBean> allBanks()
  {
      Query q = em.createQuery("select b from BankBean b  ");
      return q.getResultList();
  }

  public BankBean findBank(int id)
  {
      Query q = em.createQuery("select cu from BankBean cu where cu.id=:id");
        q.setParameter("id", id);
        List<BankBean> curs = new ArrayList<>();
        curs=q.getResultList();
        if(curs.size()>0)
                {
                    return curs.get(0);
                }
        else
            return null;
  }
}
