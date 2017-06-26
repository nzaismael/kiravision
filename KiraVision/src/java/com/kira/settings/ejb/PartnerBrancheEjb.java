/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.settings.ejb;

import com.kira.settings.beans.PartnerBranchPOS;
import com.kira.settings.entities.PartnerBranch;
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
public class PartnerBrancheEjb  {
    @PersistenceContext
    EntityManager em;
    public PartnerBranchPOS returnPartnerBranchpos(String serialNumber,String imei)
    {
        try
        {
     Query q = em.createQuery("select pb from PartnerBranch pb where pb.deviceImei=:imei and pb.deviceSerialNumber=:serialNumber");
     q.setParameter("imei", imei);
     q.setParameter("serialNumber",serialNumber);
     PartnerBranch pb=(PartnerBranch)q.getResultList().get(0);
     PartnerBranchPOS pbp = new PartnerBranchPOS();
     pbp.setBranchName(pb.getDescription());
     pbp.setDeviceserialNumber(pb.getDeviceSerialNumber());
     pbp.setId(pb.getId());
     pbp.setDeviceImei(pb.getDeviceImei());
     pbp.setMerchantNames(pb.getMerchantBean().getMerchantName()+" "+pb.getMerchantBean().getMerchantSurname());
     return pbp;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
 public PartnerBranch retrieveDevice(String serialNumber,String imei)
 {
     try
     {
   Query q = em.createQuery("select pb from PartnerBranch pb where pb.deviceImei=:imei and pb.deviceSerialNumber=:serialNumber");
     q.setParameter("imei", imei);
     q.setParameter("serialNumber",serialNumber);
     PartnerBranch pb=(PartnerBranch)q.getResultList().get(0);
       return pb;  
     }
     catch(Exception e)
     {
         return null;
     }
 }
 
 public PartnerBranch listdeviceonPOS()
 {
    Query q = em.createQuery("select pb from PartnerBranch pb ");
    
     return (PartnerBranch)q.getResultList().get(0); 
 }
 
}
