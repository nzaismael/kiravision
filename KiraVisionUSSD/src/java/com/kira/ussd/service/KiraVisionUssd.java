/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.ussd.service;

import com.kira.ussd.beans.CardHolder;
import com.kira.ussd.beans.CommercialAgent;
import com.kira.ussd.utilities.CommonLibrary;
import com.kira.utils.KiraSessionManager;
import com.kira.utils.KiraUssdNavigation;
import com.kira.utils.UssdRequest;
import com.kira.utils.UssdResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ussd.kira.messageResources.BundleResourceManager;

/**
 *
 * @author Hp
 */
@WebServlet(name = "KiraVisionUssdServlet", urlPatterns = {"/kiravision/ussd/kira"})
public class KiraVisionUssd extends HttpServlet {

    @EJB
    private KiraSessionManager kirasessionManager;
    private String nextValue;
    @EJB
    private BundleResourceManager messagesmanager;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<String> emptylist = new ArrayList();
        emptylist.add(" ");
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String line = null;

            while ((line = in.readLine()) != null) {

                sb.append(line);

            }
            System.out.println("this is the data sent" + line);
            UssdRequest urb = (UssdRequest) CommonLibrary.unmarshalling(sb.toString(), UssdRequest.class);
            // System.out.println("Request from TELCOM : "+sb.toString());
            KiraUssdNavigation un = new KiraUssdNavigation();
            UssdResponse urs = new UssdResponse();
            PrintWriter out = response.getWriter();
            un = (KiraUssdNavigation) this.getKirasessionManager().checkMsisdnSession(urb.getMsisdn());

            long diff = 0;
            if (un != null) {
                diff = (new java.util.Date().getTime() - un.getLastAccessed().getTime()) / 1000;
            }
            // System.out.println("The time that has elapsed since last access. "+diff);
            if (diff > 60) // of more than one minutes without trying, the session is zero
            {
                getKirasessionManager().terminateMisdnSession(urb.getMsisdn(), un);
            }

            if (urb.getNew_request().equals("1")) {
                if (un == null) // nothing in the session
                {
                    urs.setAgentId(urb.getAgentId());
                    urs.setMsisdn(urb.getMsisdn());
                    urs.setMenuTitle(" ^");
                    List<String> languages = new ArrayList<>();
                    languages.add("1. ENGLISH^");
                    languages.add("2. FRANCAIS^");
                    languages.add("3. KINYARWANDA^");
                    urs.setMenus(languages);
                    urs.setFreeFlow("FC");
                    urs.setSessionId(urb.getSessionId());
                    urs.setNew_request("0");
                    urs.setSpId(urb.getSpId());

                    un = new KiraUssdNavigation();
                    un.setAgentid(urb.getAgentId());

                    un.setLastAccessed(new java.util.Date());
                    un.setMsisdn(urb.getMsisdn());
                    un.setSessionid(urb.getSessionId());
                    un.setNextValue("language");
                    un.setPreviousValue("language");
                    un.setLanguage("en");
                    un.setLastAccessed(new java.util.Date());
                    //un.setSessionid(line);
                    //  String responsexml = CommonLibrary.marchalling(urs, UssdResponse.class);

                    getKirasessionManager().addmisdnSession(urb.getMsisdn(), un);
                    String message = CommonLibrary.marchalling(urs, UssdResponse.class);

                    //   System.out.println("This is the response from vision USSD: \n "+message);
                    out.println(message);
                }// nothing in the session. we can resume or restart
                else {
                    urs.setAgentId(urb.getAgentId());
                    urs.setFreeFlow("FC");
                    urs.setMenuTitle("");
                    List<String> list = new ArrayList();

                    list.add(getMessagesmanager().getMessage("stoppedresume", un.getLanguage()));
                    list.add(getMessagesmanager().getMessage("stoppedrestart", un.getLanguage()));
                    // list.add("1. Resume^");
                    //list.add("2. Restart^");
                    urs.setMenus(list);
                    urs.setMenuTitle(getMessagesmanager().getMessage("stoppedtitle", un.getLanguage()));

                    // urs.setMenuTitle("HITAMO ICYO GUKORA^^");
                    urs.setMsisdn(urb.getMsisdn());
                    urs.setSessionId(urb.getSessionId());
                    urs.setSpId(urb.getSpId());

                    un.setAgentid(urb.getAgentId());
                    un.setLastAccessed(new java.util.Date());
                    un.setNextValue("restarting");

                    //System.out.println("the current language "+un.getLanguage());
                    //un.setUssdResponse(urs);
                    // un.setLanguage("en");
                    getKirasessionManager().addmisdnSession(urb.getMsisdn(), un);
                    out.println(CommonLibrary.marchalling(urs, UssdResponse.class));

                }

            } // new Request is not 0 (not 1)   
            else {
                un = (KiraUssdNavigation) getKirasessionManager().checkMsisdnSession(urb.getMsisdn());
                //   System.out.println(un.getLanguage());
                this.setNextValue(un.getNextValue());
                switch (this.getNextValue()) {
                    case "language":
                        Map map = new HashMap();
                        map.put("1", "en");
                        map.put("2", "fr");
                        map.put("3", "kin");
                        String languageinput = (String) map.get(urb.getInput());
                        un = new KiraUssdNavigation();
                        un.setLanguage(languageinput);
                        un.setLastAccessed(new java.util.Date());
                        un.setMsisdn(urb.getMsisdn());
                        un.setNextValue("pin");
                        un.setPreviousValue("language");
                        un.setSessionid(urb.getSessionId());
                        un.setAgentid(urb.getAgentId());
                        // un.setUssdResponse(urs);
                        urs.setAgentId(urb.getAgentId());
                        urs.setFreeFlow("FC");
                        urs.setMenuTitle(getMessagesmanager().getMessage("pin", un.getLanguage()));
                        List<String> menus = new ArrayList();
                        menus.add(" ^");
                        urs.setMenus(menus);
                        urs.setMsisdn(urb.getMsisdn());
                        urs.setSessionId(urb.getSessionId());
                        urs.setNew_request(urb.getNew_request());
                        urs.setSpId(urb.getSpId());

                        this.getKirasessionManager().addmisdnSession(urb.getMsisdn(), un);
                        // ussdNextValue="insuranceType";
                        out.println(CommonLibrary.marchalling(urs, UssdResponse.class));

                        break;
                    case "pin":
                        un = this.getKirasessionManager().checkMsisdnSession(urb.getMsisdn());
                        System.out.println(urb.getMsisdn().substring(2));
                        String agenturl = "http://localhost:8080/KiraVision/commercialagent/agentbyphone/" + urb.getMsisdn().substring(2) + "/" + urb.getInput();
                        Response responseagent = CommonLibrary.sendRESTRequest(agenturl, "", MediaType.APPLICATION_XML, "GET");
                        CommercialAgent coa = new CommercialAgent();
                        if (responseagent.getStatus() == 200) {
                            String coxml = responseagent.readEntity(String.class);
                            coa = (CommercialAgent) CommonLibrary.unmarshalling(coxml, CommercialAgent.class);
                        /*    if(coa!=null&&coa.getAgentPin().trim().equals("00000"))
                            {
                                urs.setAgentId(urb.getAgentId());
                                urs.setFreeFlow("FC");
                                urs.setMenuTitle("Change your passoward:");
                                urs.setMenus(emptylist);
                                urs.setMsisdn(urb.getMsisdn());
                                urs.setNew_request(urb.getNew_request());
                                urs.setSessionId(urb.getSessionId());
                                urs.setSpId(urb.getSpId());
                                
                                un.setLastAccessed(new java.util.Date());
                                un.setPreviousValue(un.getNextValue());
                                
                                un.setNextValue("changePassword");
                                this.getKirasessionManager().addmisdnSession(urb.getMsisdn(), un);
                              out.println(CommonLibrary.marchalling(urs, UssdResponse.class));  
                            }*/
                        } else {
                            coa = null;
                        }

                        String clienturl = "http://localhost:8080/KiraVision/cardholder/cardholderphonepin/" + urb.getMsisdn().substring(2) + "/" + urb.getInput();
                        Response responseclient = CommonLibrary.sendRESTRequest(clienturl, "", MediaType.APPLICATION_XML, "GET");
                        CardHolder cardholder;
                        if (responseclient.getStatus() == 200) {
                            String clixml = responseclient.readEntity(String.class);
                            cardholder = (CardHolder) CommonLibrary.unmarshalling(clixml, CardHolder.class);
                          /*  if(cardholder!=null && cardholder.getClientPin().equals("00000"))
                            {
                                urs.setAgentId(urb.getAgentId());
                                urs.setFreeFlow("FC");
                                urs.setMenuTitle("Change your passoward:");
                                urs.setMenus(emptylist);
                                urs.setMsisdn(urb.getMsisdn());
                                urs.setNew_request(urb.getNew_request());
                                urs.setSessionId(urb.getSessionId());
                                urs.setSpId(urb.getSpId());
                                
                                un.setLastAccessed(new java.util.Date());
                                un.setPreviousValue(un.getNextValue());
                                
                                un.setNextValue("changePassword");
                                this.getKirasessionManager().addmisdnSession(urb.getMsisdn(), un);
                              out.println(CommonLibrary.marchalling(urs, UssdResponse.class));  
                            }
                            */
                            
                        } else {

                            cardholder = null;
                        }

                        if (cardholder != null && coa != null && cardholder.isStatus() && coa.isStatus()) {
                            List<String> ageclis = new ArrayList<>();
                            ageclis.add(getMessagesmanager().getMessage("asclient", un.getLanguage()));
                            ageclis.add(getMessagesmanager().getMessage("asagent", un.getLanguage()));
                            urs.setAgentId(urb.getAgentId());
                            urs.setFreeFlow("FC");
                            urs.setMenuTitle(getMessagesmanager().getMessage("whoyouare", un.getLanguage()));
                            urs.setMenus(ageclis);
                            urs.setMsisdn(urb.getMsisdn());
                            urs.setNew_request("0");
                            urs.setSessionId(urb.getSessionId());
                            out.println(CommonLibrary.marchalling(urs, UssdResponse.class));
                            break;
                        }
                        if (cardholder != null && cardholder.isStatus() && coa.equals(null)) {
                               un.setLastAccessed(new java.util.Date());
                                un.setNextValue("clientactive");
                                List<String> list2 = new ArrayList();
                                list2.add("1. Change Pin^");
                                list2.add("1. Current month Commissions^");
                                list2.add("2. Previous Month Commissions^");
                                list2.add("3. Declare EBM Bill^");
                                urs.setMenus(list2);
                                urs.setAgentId(urb.getAgentId());
                                urs.setFreeFlow("FC");
                                urs.setMenuTitle("Choose ^^ ");
                                urs.setMsisdn(urb.getMsisdn());
                                urs.setNew_request("0");
                                urs.setSessionId(urb.getSessionId());
                                urs.setSpId(urb.getSpId());
                                un.setNextValue("clientmenu");
                                this.getKirasessionManager().addmisdnSession(urb.getMsisdn(), un);
                                
                                out.println(CommonLibrary.marchalling(urs, UssdResponse.class));
                                break;
                        }

                        if (coa != null && coa.isStatus() && cardholder.equals(null)) {
                        
                        String urbxml = CommonLibrary.marchalling(urb, UssdRequest.class);
                        String activeagenturl = "http://localhost:8080/KiraVisionUSSD/agentsactions/actions";
                        Response agentactiveResponse = CommonLibrary.sendRESTRequest(activeagenturl, urbxml, MediaType.APPLICATION_XML, "POST");
                        String agentactivexml = agentactiveResponse.readEntity(String.class);
                        un.setOperationUrl("http://localhost:8080/KiraVisionUSSD/agentsactions/actions");
                        un.setLastAccessed(new java.util.Date());
                        this.getKirasessionManager().addmisdnSession(urb.getMsisdn(), un);
                        out.println(agentactivexml);
                        break;
                        }
                        
                        

                        break;

                    case "restarting":
                        un = this.getKirasessionManager().checkMsisdnSession(urb.getMsisdn());
                        if (urb.getInput().trim().equals("1")) // resume
                        {
                         if(un.getOperationUrl()!=null)
                         {
                        String urbxml = CommonLibrary.marchalling(urb, UssdRequest.class);
                        String activeagenturl = un.getOperationUrl();
                        Response agentactiveResponse = CommonLibrary.sendRESTRequest(activeagenturl, urbxml, MediaType.APPLICATION_XML, "POST");
                        String agentactivexml = agentactiveResponse.readEntity(String.class);
                       un.setLastAccessed(new java.util.Date());
                        this.getKirasessionManager().addmisdnSession(urb.getMsisdn(), un);
                        out.println(agentactivexml);
                        break;
                         }
                        else
                         {
                             nextValue=un.getPreviousValue();
                             un.setNextValue(nextValue);
                             un.setLastAccessed(new java.util.Date());
                             List<String> yesno =new ArrayList<>();
                             yesno.add(getMessagesmanager().getMessage("yes", un.getLanguage()));
                             yesno.add(getMessagesmanager().getMessage("no", un.getLanguage()));
                             un.setNextValue("yesno");
                             urs.setAgentId(urb.getAgentId());
                             urs.setFreeFlow("FC");
                             urs.setMenuTitle("Continue?^");
                             urs.setMenus(yesno);
                             urs.setMsisdn(urb.getMsisdn());
                             urs.setNew_request("0");
                             urs.setSessionId(urb.getMsisdn());
                             urs.setSpId(urb.getSpId());
                             this.getKirasessionManager().addmisdnSession(urb.getMsisdn(), un);
                             out.println(CommonLibrary.marchalling(urs, UssdResponse.class));
                         }
                            
                        } else /// restarting
                        {
                            urs.setAgentId(urb.getAgentId());
                            urs.setMsisdn(urb.getMsisdn());
                            urs.setMenuTitle(" ^");
                            List<String> languages = new ArrayList<>();
                            languages.add("1. ENGLISH^");
                            languages.add("2. FRANCAIS^");
                            languages.add("3. KINYARWANDA^");
                            urs.setMenus(languages);
                            urs.setFreeFlow("FC");
                            urs.setSessionId(urb.getSessionId());
                            urs.setNew_request(urb.getNew_request());
                            urs.setSpId(urb.getSpId());
                            un.setPreviousValue("language");
                            un.setNextValue("language");
                            un.setLastAccessed(new java.util.Date());
                            un.setOperationUrl(null);
                            this.getKirasessionManager().addmisdnSession(urb.getMsisdn(), un);
                            out.println(CommonLibrary.marchalling(urs, UssdResponse.class));
                        }

                         urs.setFreeFlow("FB");
                            urs.setSessionId(urb.getSessionId());
                            urs.setNew_request(urb.getNew_request());
                            urs.setSpId(urb.getSpId());
                            urs.setMenuTitle("We Could not authenticated. See Kira Vision.^");
                            urs.setMenus(emptylist);
                            out.println(CommonLibrary.marchalling(urs, UssdResponse.class));
                        break;

                    

                    case "agentactive": // the agent is active and he needs to enter as commercial agent or client
                        //  un.setLastAccessed(new java.util.Date());
                        //  un.setNextValue2("agentMenu");
                        //  un.setOperationUrl("http://localhost:8080/KiraVisionUssd/agent/actions");
                        //activeagenturl = ""      
                        String urbxml = CommonLibrary.marchalling(urb, UssdRequest.class);
                        String activeagenturl = "http://localhost:8080/KiraVisionUSSD/agentsactions/actions";
                        Response agentactiveResponse = CommonLibrary.sendRESTRequest(activeagenturl, urbxml, MediaType.APPLICATION_XML, "POST");
                        String agentactivexml = agentactiveResponse.readEntity(String.class);
                        out.println(agentactivexml);
                        break;

                } /// switch for nextValue. Meaning Next menu

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    /**
     * @return the kirasessionManager
     */
    public KiraSessionManager getKirasessionManager() {
        return kirasessionManager;
    }

    /**
     * @param kirasessionManager the kirasessionManager to set
     */
    public void setKirasessionManager(KiraSessionManager kirasessionManager) {
        this.kirasessionManager = kirasessionManager;
    }

    /**
     * @return the nextValue
     */
    public String getNextValue() {
        return nextValue;
    }

    /**
     * @param nextValue the nextValue to set
     */
    public void setNextValue(String nextValue) {
        this.nextValue = nextValue;
    }

    /**
     * @return the messagesmanager
     */
    public BundleResourceManager getMessagesmanager() {
        return messagesmanager;
    }

    /**
     * @param messagesmanager the messagesmanager to set
     */
    public void setMessagesmanager(BundleResourceManager messagesmanager) {
        this.messagesmanager = messagesmanager;
    }

}
