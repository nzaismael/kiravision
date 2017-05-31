/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.settings.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Hp
 */
@Entity
@Table(name="SystemGroups")
public class SystemGoups {
   @Id
    private String groupId;
    private String GroupName;
    private String groupDescription;

    /**
     * @return the groupId
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * @param groupId the groupId to set
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * @return the GroupName
     */
    public String getGroupName() {
        return GroupName;
    }

    /**
     * @param GroupName the GroupName to set
     */
    public void setGroupName(String GroupName) {
        this.GroupName = GroupName;
    }

    /**
     * @return the groupDescription
     */
    public String getGroupDescription() {
        return groupDescription;
    }

    /**
     * @param groupDescription the groupDescription to set
     */
    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }
    
    
}
