/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.ejbs;

import com.kira.entities.Device;
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
public class DeviceEjb {
@PersistenceContext
private EntityManager em;
public boolean addDevice(Device device)
{
   try
   {
       em.persist(device);
       return true;
   }
   catch(Exception e)
   {
     return false;  
   }
}
public boolean editDevice(Device device)   
{
    try
    {
      em.merge(device);
      return true;
    }
    catch(Exception e)
    {
        return false;
    }
}
   
public List<Device> allDevices()
{
    Query q=em.createQuery("select d from Device d");
    return q.getResultList();
}
    
public List<Device> activeDevices()
{
    Query q =em.createQuery("select d from Device d where d.status=true");
    return q.getResultList();
}


}
