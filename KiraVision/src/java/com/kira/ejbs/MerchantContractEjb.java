/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.ejbs;

import com.kira.entities.MerchantReduction;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

/**
 *
 * @author AOS
 */
@Stateless
public class MerchantContractEjb {
    @PersistenceUnit
    EntityManager em;
    public MerchantReduction addMerchantContract(MerchantReduction contract)
    {
        try
        {
            List<MerchantReduction> merchantcontracts = new ArrayList<>();
            merchantcontracts = this.returnallpertinerContracts(contract.getMerchant().getMerchantId());
            for(MerchantReduction re:merchantcontracts)
            {
                re.setStatus(false);
                re.setSignedOn(new java.util.Date());
               this.updatePernterContract(re);
            }
        em.persist(contract);
        em.flush();
        
        
            return contract;
        }
        catch(Exception e)
        {
            return null;
        }
        
    }
public MerchantReduction returnActiveContract(long merchantId)    
{
    Query query = em.createQuery("select co from MerchantReduction co where co.merchant.merchantId=:id and co.status=true");
   query.setParameter("id", merchantId);
    List<MerchantReduction> list= query.getResultList();
    if(list.size()>0)
        return list.get(0);
    else
        return null;
}
 
public List<MerchantReduction> returnallpertinerContracts(long merchantId)
{
    Query query = em.createQuery("select re from MerchantReduction re where re.merchant.merchantId=:id");
  return  query.getResultList();
}
   
public boolean updatePernterContract(MerchantReduction contract)
{
    try
    {
    em.merge(contract);
    return true;
    }
    catch(Exception e)
    {
        return false;
}
}

}
