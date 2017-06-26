/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oltranz.ussd.handlers;

import com.oltranz.ussd.beans.UssdCenterRequest;
import com.oltranz.ussd.beans.UssdCenterResponse;
import com.oltranz.ussd.beans.UssdRequest;
import com.oltranz.ussd.beans.UssdResponse;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author aimable
 */
@Stateless
public class UssdHelper {

    private UssdRequest request;

    UssdCenterRequest centerRequest = new UssdCenterRequest();

    UssdCenterResponse centerResponse = new UssdCenterResponse();

    private UssdResponse response;

    private static final Logger log = Logger.getLogger(UssdHelper.class.getName());

    public UssdHelper() {

    }

    public Response getUssdResponse(Integer status, UssdCenterResponse centerResponse) {
        try {
            String message = formatUssdResponse(centerResponse);
            String freeFlow = "FC";
            if (centerResponse.getFreeFlow().equals("C")|| centerResponse.getFreeFlow().equals("FC")) {
                freeFlow = "FC";
            } else {
                freeFlow = "FB";
            }
            return Response.status(status).entity(message)
                    .header("FreeFlow", freeFlow)
                    .header("Expires", -1)
                    .header("Pragma", "no-cache")
                    .header("Cache-Control", "max-age=0")
                    .build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            log.log(Level.SEVERE, "The error ", e.getCause().getMessage());
            return null;
        }

    }

    public UssdCenterRequest getUssdCenterRequest(UssdRequest request) {
        centerRequest.setMsisdn(request.getMsisdn());
        centerRequest.setSessionId(request.getSessionID());
        centerRequest.setInput(request.getInput());
        centerRequest.setNewRequest(request.getNewRequest());
        centerRequest.setSpid(request.getSpId());
        centerRequest.setAgentId(request.getAgentId());
        return centerRequest;
    }

    public UssdCenterResponse sendMessage(String url, Object message) {

        try {

            // create client object from Client interface to manage and configure HTTP connections.
            Client client = ClientBuilder.newClient();
            /**
             * create WebTarget instance from client from which we will build
             * and execute the requests
             */
            WebTarget target = client.target(url);
            Invocation invocation = target.request().buildPost(Entity.entity(message, MediaType.APPLICATION_XML));
            Response resp = invocation.invoke();
            String xmlStringResp = resp.readEntity(String.class);
            StringReader str = new StringReader(xmlStringResp);

            JAXBContext reqcxt = JAXBContext.newInstance(UssdCenterResponse.class);
            Unmarshaller unMarsh = reqcxt.createUnmarshaller();
            centerResponse = (UssdCenterResponse) unMarsh.unmarshal(str);
            System.out.println("The Value is " + xmlStringResp);
            return centerResponse;

        } catch (Exception ex) {
            Logger.getLogger(UssdHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public String formatUssdResponse(UssdCenterResponse centerResponse) {
        StringBuilder sb = new StringBuilder();
        sb.append(centerResponse.getMessageTitle().replace("^", "\n"));
        centerResponse.getMenus().forEach(m -> {
            sb.append(m.replace("^", "\n"));
        });
        return sb.toString();
    }

    public UssdRequest getRequest() {
        return request;
    }

    public void setRequest(UssdRequest request) {
        this.request = request;
    }

}
