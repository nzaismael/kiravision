/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oltranz.ussd.handlers;

import com.oltranz.ussd.beans.UssdCenterResponse;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import ussd.insurance.utilities.CommonLibrary;

/**
 * REST Web Service
 *
 * @author aimable
 */
@Path("/")
@Stateless
public class UssdService {

    @Inject
    UssdHelper ussdHelper;
    
    @Context
    ServletContext context;
    
    static final Logger logger = Logger.getLogger(UssdService.class.getName());

    /**
     * Creates a new instance of UssdService
     *
     * @param input
     * @param msisdn
     * @param sessionID
     * @param DateTime
     * @param newRequest
     * @param transactionId
     * @param req
     * @return
     */
    @POST
    @Path("/UssdRequestHandler")
   // @Consumes({MediaType.APPLICATION_FORM_URLENCODED, "multipart/form-data", "application/xml", "text/plain"})
    @Produces("text/plain")
    public Response getUssdMessage(InputStream is) {
        String inputstreamtext = CommonLibrary.inputStream2String(is);
        System.out.println("Response from the center: "+inputstreamtext);
    /*   @FormParam("input") String input,
            @FormParam("msisdn") String msisdn,
            @FormParam("sessionID") Long sessionID,
            @FormParam("DateTime") String DateTime,
            @FormParam("NewRequest") String newRequest,
            @FormParam("TransactionID") String transactionId,@Context HttpServletRequest req */
        
        try {
            /*String agentId=req.getParameter("agentId");
            String spId=req.getParameter("spId");
            String centerUrl=req.getParameter("centerUrl");
            UssdRequest ussdReq=new UssdRequest(input, sessionID, msisdn,Integer.valueOf(newRequest), DateTime,new BigInteger(transactionId),spId,agentId);
           // String centerUrl = "http://127.0.0.1:8085/USSDCenter/centerUssd/ussdRequest";
          
           System.out.println(centerUrl);
            
            UssdCenterRequest ussdCenterReq=ussdHelper.getUssdCenterRequest(ussdReq);*/
                    
         //   UssdCenterResponse ussdCenterResponse=ussdHelper.sendMessage(centerUrl, ussdCenterReq);
            UssdCenterResponse ussdCenterResponse=(UssdCenterResponse) CommonLibrary.unmarshalling(inputstreamtext, UssdCenterResponse.class);
            System.out.println(ussdCenterResponse.getMessageTitle());
            return ussdHelper.getUssdResponse(200,ussdCenterResponse);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            logger.log(Level.SEVERE, "The error", ex.getCause());
            return null;
        }
    }
    
    
    @POST
    @Path("/ussdRequest")
    @Produces("text/plain")
    public Response preparemessage(InputStream is)
    {
         String inputstreamtext = CommonLibrary.inputStream2String(is);
        System.out.println(inputstreamtext);
        UssdCenterResponse ussdCenterResponse=(UssdCenterResponse) CommonLibrary.unmarshalling(inputstreamtext, UssdCenterResponse.class);
           return ussdHelper.getUssdResponse(200,ussdCenterResponse);
  // return null;
    }

}
