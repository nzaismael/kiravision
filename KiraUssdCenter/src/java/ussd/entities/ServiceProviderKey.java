/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussd.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ismaelnzamutuma
 */
public class ServiceProviderKey implements Serializable {
    
    int agentId;
    String spId;
    public ServiceProviderKey(int agentId,String spId)
    {
        this.agentId=agentId;
        this.spId=spId;
    }
   @Override
   public boolean equals(Object obj)
   {
       if(!(obj instanceof ServiceProviderKey))
       return false;
       if(obj==this)
           return true;
       
       return false;
               
           
       
   }
   
   @Override
   public int hashCode()
   {
       return Objects.hashCode(this);
   }
    
    
}
