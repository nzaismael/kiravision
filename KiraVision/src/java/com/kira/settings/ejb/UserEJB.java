/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.settings.ejb;

import com.kira.settings.entities.User;
import java.util.ArrayList;
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
public class UserEJB {
@PersistenceContext
private EntityManager em;
    
   public boolean addUser(User user)
   {
       try
       {
       em.persist(user);
       return true;
       }
       catch(Exception e)
       {
           return false;
       }
   }
   
  public void editUser(User user) 
  {
      em.merge(user);
  }
  
  public User retrieveUser(String userId)
  {
    return  em.find(User.class, userId);
  }
  
  public List<User> listAllUsers()
  {
    Query q = em.createQuery("select u from User u  ")  ;
    return q.getResultList();
  }
  public List<User> listActiveUsers()
  {
      Query q =em.createQuery("select u from User u where u.status=true");
      return q.getResultList();
  }
  
  public User retrieveUser(String userId,String pin)
  {
      Query q = em.createQuery("select u from User u where u.userId=:userId and u.userPin=:userPin");
      q.setParameter("userId",userId);
      q.setParameter("userPin",pin);
      List<User> users = new ArrayList();
      users= q.getResultList();
      if(users.isEmpty())
          return null;
      else
          return users.get(0);
      
  
  }
}
