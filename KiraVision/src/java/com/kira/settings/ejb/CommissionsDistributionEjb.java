/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.settings.ejb;

import com.kira.settings.entities.CommissionsDistribution;
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
public class CommissionsDistributionEjb {
@PersistenceContext
EntityManager em;

public List<CommissionsDistribution> allCommissionsDistribution()
        {
            Query query = em.createQuery("select cd from CommissionsDistribution cd where cd.status=true");
            return query.getResultList();
         //   return null;
        }
    
}
