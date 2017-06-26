/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.ejbs;

import com.kira.beans.NewPurchase;
import com.kira.beans.PurchaseResponsePOS;
import com.kira.beans.SendParameter;
import com.kira.entities.PurchaseBean;
import com.kira.entities.PurchaseCommissionsDetail;
import com.kira.settings.ejb.CommissionsDistributionEjb;
import com.kira.settings.ejb.PartnerBrancheEjb;
import com.kira.settings.entities.CommissionsDistribution;
import com.kira.settings.entities.PartnerBranch;
import com.kira.ussd.utilities.CommonLibrary;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author AOS
 */
@Stateless

public class PurchasesEjb {
    @PersistenceContext
    EntityManager em;
   @EJB
   CardHolderEjb cardHolderEjb;
   @EJB
   PartnerBrancheEjb deviceEjb;
   @EJB
   MerchantContractEjb contractEjb;
   @EJB
   CommissionsDistributionEjb comdistEjb;
    public String  newTransaction(NewPurchase purchaseinfo)
    {
         try
         {
        PurchaseBean purchase = new PurchaseBean();
        PartnerBranch device= new PartnerBranch();
        device = deviceEjb.retrieveDevice(purchaseinfo.getPosSerial(),purchaseinfo.getDeviceImei());
       // System.out.println(device.getMerchantBean().getMerchantEmail());
        purchase.setClient(cardHolderEjb.getCardHolderByCardNumber(purchaseinfo.getCardNumber().trim()));
        purchase.setPurchaseAmount(purchaseinfo.getAmount());
        purchase.setPurchaseOn(new java.util.Date());
        purchase.setContract(contractEjb.activeContract(device.getMerchantBean().getMerchantId()));
        purchase.setGrandchild(purchase.getClient().getGrandChild());
        purchase.setChild(purchase.getClient().getChild());
        purchase.setParent(purchase.getClient().getParent());
        em.persist(purchase);
        em.flush();
      List<CommissionsDistribution> comdistributes= comdistEjb.allCommissionsDistribution();
      List<PurchaseCommissionsDetail> details = new ArrayList<>();
      double reduction = purchase.getPurchaseAmount()*purchase.getContract().getReduction()/100;
      double kiraamount=0;
      for(CommissionsDistribution codist:comdistributes)
      {
          PurchaseCommissionsDetail comdet= new PurchaseCommissionsDetail();
          comdet.setComm(codist);
          //double commissions =reduction*codist.getCommission()/100;
        //  int a=(int)commissions;
          comdet.setCommissionAmount((int)(reduction*codist.getCommission()/100));
          
          comdet.setPurchase(purchase);
          comdet.setDetailId(codist.getId().intValue());
        em.persist(comdet);
      }
     
      String smsurl ="http://localhost:8080/KiraVisionSms/smsnotification/newsms";
     SendParameter sendp = new SendParameter();
     sendp.setAccount("brd");
     sendp.setMessage(" Test Transaction ");
      sendp.setPhone("+250788499191");
      sendp.setPin("6m1z4d1o5x6o");
      sendp.setSender("BRD");
      
      String xml = CommonLibrary.marchalling(sendp, SendParameter.class);
      CommonLibrary.sendRESTRequest(smsurl, xml, MediaType.APPLICATION_XML,"POST");
      
      
      ObjectMapper mapper = new ObjectMapper();
      PurchaseResponsePOS rsp = new PurchaseResponsePOS();
        rsp.setPurchaseDesc("Success");
        rsp.setPurchaseStatus(200);
        return mapper.writeValueAsString(rsp);
         }
         catch(Exception e)
         {
             System.out.println("Erreur: "+e.getMessage());
             return null;
         }
       //PurchaseCommissionsDetail  det = new PurchaseCommissionsDetail();
       
       // purchase.setClient(cardHolder.getcardHolderbyPhone(phone));
    }
    
}
