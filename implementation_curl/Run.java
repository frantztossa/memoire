package implementation_curl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Run {
	
	public static void main(String[] args)  {
		BufferedReader reader = null;
		//String url = args[0];
		//String a_Method = args[1];
		String url = "http://172.21.12.10:5000/api/v0.1/health";
		String a_Method = "GET";
        URL a_Url = null;
        
		try {
			a_Url = new URL(url);
		} catch (MalformedURLException e1) {
			
			e1.printStackTrace();
		}
       
 
      
 
      try{
         HttpURLConnection o_oUrlConn = (HttpURLConnection) a_Url.openConnection();
         o_oUrlConn.setRequestMethod(a_Method);
         o_oUrlConn.setAllowUserInteraction(false);
         
         reader = new BufferedReader(new InputStreamReader(o_oUrlConn.getInputStream()));
         String ligne;
         while ((ligne = reader.readLine()) != null) {
            System.out.println(ligne);
         }
       
        
         //deconnection
         o_oUrlConn.disconnect();
      }
      catch(ConnectException ctx)
      {
       // Log.fatal(this, "Connection lost : server may be down");
        ctx.printStackTrace();
      }
      catch (Exception e)
      {
        // Log.error(this,"postURL : "+e.getMessage());
         e.printStackTrace();
      }finally{
          
          try{reader.close();}catch(Exception e){}
          
       }
      
    }

}
