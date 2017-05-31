/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.services;

import com.kira.ejbs.CardHolderEjb;
import com.kira.entities.CardHolder;
import com.kira.entities.CardHolders;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Hp
 */
@Stateless
@Path("cardholder")
public class CardHolderREST {
    @EJB
    private CardHolderEjb clientEjb;

    @Path("allcardholders")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public CardHolders allCardHolders()
    {
        CardHolders cardholders = new CardHolders();
        cardholders.setCustomers(this.getClientEjb().allCardHolders());
        //System.out.println(cardholders.getCustomers().size());
        
      return  cardholders;
   // return this.getClientEjb().allCardHolders();
    }
    
    @Path("activecardholders")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<CardHolder> activeCardHolders()
    {
        return this.getClientEjb().activeCardHolders();
                
    }
    @Path("cardholderphone/{phone}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public CardHolder getcardholderbyPhone(@PathParam("phone")String phone)
    {
        return this.getClientEjb().getcardHolderbyPhone(phone);
    }
    @Path("cardholderphonepin/{phone}/{pin}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public CardHolder getcardholderbyPhone(@PathParam("phone")String phone,@PathParam("pin")String pin)
    {
        return this.getClientEjb().getCardHolderbyPhonepin(phone,pin);
    } 
    
    @Path("newcardholder")
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public boolean addNewCardHolder(CardHolder cardHolder)
    {
      return this.getClientEjb().addCardHolder(cardHolder);
    }
    
     @Path("editcardholder")
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public boolean editCardHodler(CardHolder cardholder)
    {
        return this.getClientEjb().editcardholder(cardholder);
    }
    
    /**
     * @return the clientEjb
     */
    public CardHolderEjb getClientEjb() {
        return clientEjb;
    }

    /**
     * @param clientEjb the clientEjb to set
     */
    public void setClientEjb(CardHolderEjb clientEjb) {
        this.clientEjb = clientEjb;
    }
    
    
}
