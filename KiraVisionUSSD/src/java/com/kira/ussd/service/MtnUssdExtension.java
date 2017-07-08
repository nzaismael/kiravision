/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kira.ussd.service;

import com.kira.ussd.utilities.CommonLibrary;
import com.kira.utils.UssdRequest;
import com.kira.utils.UssdResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author AOS
 */
@WebServlet(name = "MtnUssdExtension", urlPatterns = {"/ussd/Kira"})
public class MtnUssdExtension extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         String inputxml =CommonLibrary.inputStream2String(request.getInputStream());
  //  response.sendRedirect("http://localhost:8080/KiraVisionUSSD/kiravision/ussd/kira");
      //response.sendRedirect("http://yahoo.com");
      System.out.println(request.getQueryString().toString());
      String query=request.getQueryString().toString();
      UssdRequest urb = new UssdRequest();
      urb.setAgentId(2);
      urb.setInput(request.getParameter("input"));
      urb.setMsisdn(request.getParameter("msisdn"));
      urb.setNew_request(request.getParameter("newRequest"));
      urb.setSessionId(request.getParameter("sessionId"));
      urb.setSpId("2");
     
     String requestxml = CommonLibrary.marchalling(urb, UssdRequest.class);
      Response ussdresponse =CommonLibrary.sendRESTRequest("http://localhost:8080/KiraVisionUSSD/kiravision/ussd/kira", requestxml, MediaType.APPLICATION_XML, "POST");
      UssdResponse urs = new UssdResponse();
      String ussdresponsexml=ussdresponse.readEntity(String.class);
      urs=(UssdResponse)CommonLibrary.unmarshalling(ussdresponsexml, UssdResponse.class);
      
      String ussdresponseString =this.formatUssdResponse(urs);
      String freeFlow = "FC";
            if (urs.getFreeFlow().equals("C")|| urs.getFreeFlow().equals("FC")) {
                freeFlow = "FC";
            } else {
                freeFlow = "FB";
            }
      

      response.addHeader("FreeFlow", freeFlow);
      response.addIntHeader("Expires", -1);
      response.addHeader("Pragma", "no-cache");
      response.addHeader("Cache-Control", "max-age=0");
      PrintWriter out = response.getWriter();
      out.println(ussdresponseString);
        
    }

    public String formatUssdResponse(UssdResponse urs) {
        StringBuilder sb = new StringBuilder();
        sb.append(urs.getMenuTitle().replace("^", "\n"));
        urs.getMenus().forEach(m -> {
            sb.append(m.replace("^", "\n"));
        });
        return sb.toString();
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

}
