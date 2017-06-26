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
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author AOS
 */
@Stateless
public class MerchantContractEjb {
    @PersistenceContext
   private EntityManager emcontra;
    
    public MerchantReduction addMerchantContract(MerchantReduction contract)
    {
        try
        {
            List<MerchantReduction> merchantcontracts = new ArrayList<>();
            merchantcontracts = this.returnallpertinerContracts(contract.getMerchant().getMerchantId());
            for(MerchantReduction re:merchantcontracts)
            {
                re.setStatus(false);
             
                re.setStopedOn(new java.util.Date());
               this.updatePernterContract(re);
            }
            contract.setStatus(true);
        emcontra.persist(contract);
        emcontra.flush();
              return contract;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
public MerchantReduction activeContract(long merchantId)    
{
    Query query = emcontra.createQuery("select co from MerchantReduction co where co.merchant.merchantId=:id and co.status=true");
   query.setParameter("id", merchantId);
    List<MerchantReduction> list= query.getResultList();
    if(list.size()>0)
        return list.get(0);
    else
        return null;
}
 
public List<MerchantReduction> returnallpertinerContracts(long merchantId)
{
    Query query = emcontra.createQuery("select re from MerchantReduction re where re.merchant.merchantId=:id");
  query.setParameter("id", merchantId);
    return  query.getResultList();
}


   
public boolean updatePernterContract(MerchantReduction contract)
{
    try
    {
    emcontra.merge(contract);
    return true;
    }
    catch(Exception e)
    {
        return false;
}
}

}
