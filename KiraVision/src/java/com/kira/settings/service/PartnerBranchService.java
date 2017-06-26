/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.settings.service;

import com.kira.settings.beans.PartnerBranchRequest;
import com.kira.settings.ejb.PartnerBrancheEjb;
import com.kira.settings.entities.PartnerBranch;
import com.kira.ussd.utilities.CommonLibrary;
import java.io.InputStream;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author AOS
 */
@Stateless
@Path("device")
public class PartnerBranchService {
    @EJB
    PartnerBrancheEjb partnerdeviceEjb;
    @Path("/findpos")
    @POST
   @Produces(MediaType.APPLICATION_JSON)
    public String retrieveDevicepos(InputStream is) throws Exception
    {
         ObjectMapper mapper = new ObjectMapper();
      String requestdata=  CommonLibrary.inputStream2String(is);
      System.out.println(requestdata);
      PartnerBranchRequest deviceRequest = new PartnerBranchRequest();
      deviceRequest=(PartnerBranchRequest)mapper.readValue(requestdata.trim(), PartnerBranchRequest.class);
        String json=mapper.writeValueAsString(partnerdeviceEjb.returnPartnerBranchpos(deviceRequest.getDeviceserialNumber(), deviceRequest.getDeviceImei()));
     return  json;
         }
    
  
  @Path("/findposall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PartnerBranch retrieveDevicespos()
    {
       return partnerdeviceEjb.listdeviceonPOS();
        
    }
      
    
    
}
