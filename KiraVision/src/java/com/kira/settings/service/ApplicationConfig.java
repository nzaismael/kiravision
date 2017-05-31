/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.settings.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Hp
 */
@javax.ws.rs.ApplicationPath("*")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.kira.services.AccountREST.class);
        resources.add(com.kira.services.CardHolderREST.class);
        resources.add(com.kira.services.CommercialAgentREST.class);
        resources.add(com.kira.services.MerchantREST.class);
        resources.add(com.kira.settings.service.UserFacadeREST.class);
    }
    
}
