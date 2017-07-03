/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import controller.UssdRequestBeanJpaController;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
import javax.naming.InitialContext;
import ussd.entities.UssdRequestBean;
import java.net.URI;
import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import sp.ussd.posting.PostingData;

import ussd.entities.ServiceProviderBean;
import ussd.entities.ServiceProviderKey;

/**
 *
 * @author ismaelnzamutuma
 */
@Path("centerUssd")
public class UssdRequestBeanRESTFacade {

    private EntityManagerFactory getEntityManagerFactory() throws NamingException {
        return (EntityManagerFactory) new InitialContext().lookup("java:comp/env/persistence-factory");
    }

    private UssdRequestBeanJpaController getJpaController() {
        try {
            UserTransaction utx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
            return new UssdRequestBeanJpaController(utx, getEntityManagerFactory());
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public UssdRequestBeanRESTFacade() {
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public Response create(UssdRequestBean entity) {
        try {
            getJpaController().create(entity);
            return Response.created(URI.create(entity.getSessionId().toString())).build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public Response edit(UssdRequestBean entity) {
        try {
            getJpaController().edit(entity);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") String id) {
        try {
            getJpaController().destroy(id);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public UssdRequestBean find(@PathParam("id") String id) {
        return getJpaController().findUssdRequestBean(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<UssdRequestBean> findAll() {
        return getJpaController().findUssdRequestBeanEntities();
    }

    @GET
    @Path("{max}/{first}")
    @Produces({"application/xml", "application/json"})
    public List<UssdRequestBean> findRange(@PathParam("max") Integer max, @PathParam("first") Integer first) {
        return getJpaController().findUssdRequestBeanEntities(max, first);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String count() {
        return String.valueOf(getJpaController().getUssdRequestBeanCount());
    }
   
   @POST
    @Path("ussdRequest")
   // @Produces("text/xml")
    public String requestUSSD(InputStream is) {
      StringBuilder sb = new StringBuilder();
      
      try{
          
          BufferedReader in = new BufferedReader(new InputStreamReader(is));
          String line = null;
          while((line=in.readLine())!=null)
          {
              sb.append(line);
          }
     
       
      
 XMLInputFactory fc = XMLInputFactory.newFactory();
 StreamSource xml = new StreamSource(new StringReader(sb.toString()));
 
 XMLStreamReader sr = fc.createXMLStreamReader(xml);
 
 JAXBContext jc =JAXBContext.newInstance(UssdRequestBean.class);
 Unmarshaller um =jc.createUnmarshaller();
 JAXBElement<UssdRequestBean> je = um.unmarshal(sr,UssdRequestBean.class);
 sr.close();
 UssdRequestBean urb = new UssdRequestBean();
 urb=je.getValue();
 EntityManager spintma = this.getEntityManagerFactory().createEntityManager();
 ServiceProviderBean sp = new ServiceProviderBean();
 sp = spintma.find(ServiceProviderBean.class, new ServiceProviderKey(urb.getAgentId(),urb.getSpId()));
 
 System.out.println("data sent to sp :"+ sb.toString());
 String response = new PostingData().sendXML(sp.getSpUssdUrl(), sb.toString());
 
 
 /*
 UssdResponseBean usb = new UssdResponseBean();
 
usb.setAgentId(urb.getAgentId());
usb.setFreeFlow("C");
List<String> list = new ArrayList<String>();




list.add("1.Indangamuntu yawe");
list.add("2.Kwishyura ubwisungane");
usb.setMenus(list);
usb.setMsisdn(urb.getMsisdn());
usb.setNew_request(urb.getNew_request());
usb.setSessionId(urb.getSessionId());
usb.setSpId(urb.getSpId());
usb.setMenuTitle("Ubwisungane mu kwivuza.");
 Marshaller marshal =JAXBContext.newInstance(UssdResponseBean.class).createMarshaller();
        marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshal.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        StringWriter sw = new StringWriter();
        marshal.marshal(usb, sw);
        System.out.println("The data to send to agent: "+sw.toString());
     
 return sw.toString();*/
          //  res.
 /*
 if(!response.contains("MENUS"))
 {
     response.replace("<MESSAGE>", "<MESSAGE> <!MESSAGE><MENUS><MENU>");
     response.replace("</MESSAGE>", "</MENU></MENUS>");
     response.replace("<!MESSAGE", "</MESSAGE>");
 }*/
 System.out.println(response);
return response;
 

   
//return Response.ok(usb).build();
    }
      
      catch(Exception e){
          System.out.println(e.getMessage());
          return null;
      }
  
        
       
    }  
    
    
}
