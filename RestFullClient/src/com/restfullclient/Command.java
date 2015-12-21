package com.restfullclient;
import java.io.BufferedReader;
import java.net.URL;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;

public class Command {
    private BufferedReader reader = null;
    private String result= "";
    

    public Command(URL url, String method) throws ConnectException,Exception {
        
         HttpURLConnection o_oUrlConn = (HttpURLConnection) url.openConnection();
         o_oUrlConn.setRequestMethod(method);
         o_oUrlConn.setAllowUserInteraction(false);
         
         reader = new BufferedReader(new InputStreamReader(o_oUrlConn.getInputStream()));
         String line;
         while ((line = reader.readLine()) != null) {
            result+=line+"\n";
         }
        
         //deconnection
         o_oUrlConn.disconnect();        
    }
    
    public String getResult(){
        return result;
    }
    
    public String getResultToJSON(){
        throw new UnsupportedOperationException();
    }
    
    public String getResultToXML(){
       throw new UnsupportedOperationException(); 
    }
    
}
