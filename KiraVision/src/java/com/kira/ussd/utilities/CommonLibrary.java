/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.kira.ussd.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import static java.lang.System.out;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author manzi
 */
public class CommonLibrary {
      static public Object unmarshalling(InputStream inputStream, Class className) {
        Object object=null;
        try{
            String inputXML=inputStream2String(inputStream);
            XMLInputFactory xmlFactory = XMLInputFactory.newFactory();
            StreamSource streamSource = new StreamSource(new StringReader(inputXML));
            XMLStreamReader streamReader= xmlFactory.createXMLStreamReader(streamSource);
            
            JAXBContext jc = JAXBContext.newInstance(className);
            Unmarshaller unMarshaller = jc.createUnmarshaller();
            object= unMarshaller.unmarshal(streamReader);
            
            inputStream.close();
            return object;
            
        }catch(Exception ex){
            return object;
        }
        finally{
            try{
                inputStream.close();
                
            }
            catch(IOException ex){
                String message="ERROR ON INPUT STREAM RECEPTION OF CENTER REQUEST: MESSAGE: "+ex.getMessage()+" | TRACE :";
                StringWriter errors = new StringWriter();
                ex.printStackTrace(new PrintWriter(errors));
                message+=errors.toString();
                out.print(message);
            }
        }
    }
    
     static public Object unmarshalling(String inputXML, Class className) {
        Object object=null;
        try{
           // String inputXML=inputStream2String(inputStream);
            XMLInputFactory xmlFactory = XMLInputFactory.newFactory();
            StreamSource streamSource = new StreamSource(new StringReader(inputXML));
            XMLStreamReader streamReader= xmlFactory.createXMLStreamReader(streamSource);
            
            JAXBContext jc = JAXBContext.newInstance(className);
            Unmarshaller unMarshaller = jc.createUnmarshaller();
            object= unMarshaller.unmarshal(streamReader);
            
           
            return object;
            
        }catch(Exception ex){
            return object;      
        
        }
    }
    
    static public String marchalling(Object object, Class className){
        
        try{
            JAXBContext ctx = JAXBContext.newInstance(className);
            Marshaller msh = ctx.createMarshaller();
            msh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter writer = new StringWriter();
            msh.marshal(object, writer);
            return writer.toString();
            
        }catch(Exception ex){
            return null;
        }
              
    }
    
    static public String inputStream2String(InputStream stream ){
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(stream));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
        
    }
    
    /*
    
    */
    
    public static Response sendRESTRequest(String url,String requestStr, String MediaType, String method)
    {
        try
        {
            Response response=null;
            Client client =ClientBuilder.newClient();
            WebTarget target =client.target(url);
            switch (method){
                case "POST":
                    response = target.request().header("Content-type", "text/xml").header("Signature", "43AD232FD45FF").post(Entity.entity(requestStr, MediaType));
                    
                    break;
                    
                case "GET":
                    response = target.request().get();
                    break;
                    
            }
            
            return response;
        }
        catch(Exception e)
        {
            System.out.println("Error send request: "+e.getMessage());
            return null;
        }
        
        
    }
    
  public static String FormatPhone(String phone)
  {
      if(phone.trim().startsWith("07"))
      {
        return "+25"+phone ; 
      }
      else if(phone.trim().startsWith("02507"))
      {
          return "+0"+phone.trim().substring(1);
      }
      else if(phone.trim().startsWith("00250"))
      {
          return "+"+phone.trim().substring(2);
      }
      else
      {
          return phone;
      }
     
  }
    
}
