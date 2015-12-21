package com.restfullclient;


public class run {

    
    public static void main(String[] args) {
        try {
           Command c = RestFullClient.executeCommand("http://172.21.12.10:5000/api/v0.1/health",RestMethods.GET);
            System.out.println(c.getResult());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }       
    }    
}
