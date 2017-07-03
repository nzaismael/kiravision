/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ussd.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author ismaelnzamutuma
 */
@Entity
@Table(name="serviceproviders")
@IdClass(ServiceProviderKey.class)
public class ServiceProviderBean implements Serializable{
    @Id
    private String spId;
    @Id
  private int agentId;
  private String spName;
  private String spUssdUrl;
  

    /**
     * @return the spId
     */
    public String getSpId() {
        return spId;
    }

    /**
     * @param spId the spId to set
     */
    public void setSpId(String spId) {
        this.spId = spId;
    }

    /**
     * @return the spName
     */
    public String getSpName() {
        return spName;
    }

    /**
     * @param spName the spName to set
     */
    public void setSpName(String spName) {
        this.spName = spName;
    }

    /**
     * @return the spUssdUrl
     */
    public String getSpUssdUrl() {
        return spUssdUrl;
    }

    /**
     * @param spUssdUrl the spUssdUrl to set
     */
    public void setSpUssdUrl(String spUssdUrl) {
        this.spUssdUrl = spUssdUrl;
    }

    /**
     * @return the agentId
     */
    public int getAgentId() {
        return agentId;
    }

    /**
     * @param agentId the agentId to set
     */
    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }
  
  
    
    
}
