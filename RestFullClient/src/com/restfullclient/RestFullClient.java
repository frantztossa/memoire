package com.restfullclient;
import java.net.ConnectException;
import java.net.URL;
import java.net.MalformedURLException;


public class RestFullClient {
    
    
    public static Command executeCommand(String url, String  method) throws MalformedURLException,ConnectException,Exception {
        URL a_Url = null;
        a_Url = new URL(url);       
        Command c = new Command(a_Url, method);
        
        return c;        
    }
}
