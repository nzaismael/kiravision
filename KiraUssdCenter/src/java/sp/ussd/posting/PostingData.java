/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.ussd.posting;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author ismaelnzamutuma
 */
public class PostingData {
    public String sendXML(String url1,String xmlData)
    {
    
        try
        {
            URL url = new URL(url1);
           HttpURLConnection con =(HttpURLConnection)url.openConnection();
           con.setRequestMethod("POST");
          // con.setRequestProperty("Content-type", "text/xml,charset=utf-8");
           con.setDoOutput(true);
           con.setDoInput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(xmlData);
            wr.flush();
            wr.close();
            
           
            
         //InputStream response = con.getInputStream();
       // String response = con.;
       //  con.disconnect();
      //return    response;
         
        BufferedReader in1 = new BufferedReader(new InputStreamReader(con.getInputStream()));
         String inputLine;
         StringBuffer response = new StringBuffer();
         while((inputLine=in1.readLine())!=null)
         {
             response.append(inputLine);
         }
      // response.
         in1.close();
         con.disconnect();
          return response.toString();  
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
           return null;
        }
            
        
    }
    
}
