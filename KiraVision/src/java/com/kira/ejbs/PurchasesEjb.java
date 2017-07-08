/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.ejbs;

import com.kira.beans.CommissionDetail;
import com.kira.beans.NewPurchase;
import com.kira.beans.PurchaseCommissions;
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
import javax.persistence.Query;
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
     
    // Asychroneous sms forwarding
      
      class sendingSMS implements Runnable
              {
               public void run()
               {
     String smsurl ="http://localhost:8080/KiraVisionSms/smsnotification/newsms";
     SendParameter sendp = new SendParameter();
     sendp.setAccount("kvl");
     sendp.setMessage("Patience with the SMS. We are testing kira Vision SMS system. Any inconvenience call 0788636644, Nzamutuma Ismael ");
     // sendp.setPhone(CommonLibrary.FormatPhone(purchase.getClient().getClientPhone()));
     sendp.setPhone("+250788636644");
     sendp.setPin("7d1q0u3l1n9a");
      sendp.setSender("KIRA VISION");
      /*
      SentMessages sendMessages = new SentMessages();
      sendMessages.setCardHolder(purchase.getClient());
      sendMessages.setPhone(sendp.getPhone());
      sendMessages.setMessage(sendp.getMessage());
      em.persist(sendMessages);
      em.flush();
      */
      String xml = CommonLibrary.marchalling(sendp, SendParameter.class);
      CommonLibrary.sendRESTRequest(smsurl, xml, MediaType.APPLICATION_XML,"POST");
   //  String smsresponsexml = response.readEntity(String.class);
  //   System.out.println(smsresponsexml);
   /*  SendResponseParameter sendResponseParameter=(SendResponseParameter)CommonLibrary.unmarshalling(smsresponsexml, SendResponseParameter.class);
     sendMessages.setBalance(Double.parseDouble(sendResponseParameter.getBalance()));
     sendMessages.setCost(Double.parseDouble(sendResponseParameter.getCost()));
     sendMessages.setSuccess(sendResponseParameter.getSuccess());
     em.merge(sendMessages);*/
     
               }
              } // end inner class for SMS sending
      Thread thread = new Thread(new sendingSMS()); // thread is created to send SMS
     thread.start(); // thread has started . the System will not wait until the sms is sent instead it i will return on its own.
     // Asychroneous sms forwarding 
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
   
   public PurchaseCommissions purchasesCommissions(java.util.Date from, java.util.Date to)
   {
    Query query = em.createQuery("select pd from PurchaseCommissionsDetail pd where cast(pd.purchase.purchaseOn as date) between :from and :to ");
  //  List<PurchaseCommissionsDetail> coms =query.getResultList();
    //CommissionsDetails comdes = new CommissionsDetails();
  //  System.out.println(query.getResultList().size());
  query.setParameter("from", from);
  query.setParameter("to", to);
  List<CommissionDetail> comdet = new ArrayList<>();
  List<PurchaseCommissionsDetail> coms = query.getResultList();
   coms.parallelStream()
                .map(com->{
                return new CommissionDetail(com);
                })
              .forEach(comdet::add);
        
        
        
      PurchaseCommissions comdets = new PurchaseCommissions();       
        comdets.setComdetails(comdet);
        
        System.out.println("in the service "+comdets.getComdetails().size());
   //  return    mapper.writeValueAsString(comdets);
     return  comdets;
  
    
    //return query.getResultList();
       
      
   }
    
    
    
}
