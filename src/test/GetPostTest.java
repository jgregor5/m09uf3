
package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * see https://docs.postman-echo.com/
 *
 * @author julian
 */
public class GetPostTest {
    
    private static final String USER_AGENT = "Mozilla/5.0";
    
    public static void main(String[] args) {
        
        System.out.println(">>>> GET");
        get("https://postman-echo.com/get?propietat1=valor1&propietat2=valor2");        
        System.out.println(">>>> POST");
        post("https://postman-echo.com/post");
    }    
    
    static void get(String urlText) {

        try {
            URL url = new URL(urlText);
            HttpURLConnection httpConn = ((HttpURLConnection) url.openConnection());
            
            httpConn.setRequestMethod("GET"); // optional
            httpConn.setRequestProperty("User-Agent", USER_AGENT);
            
            int responseCode = httpConn.getResponseCode();
            System.out.println("response code: " + responseCode);
            
            String contentType = httpConn.getContentType();
            System.out.println("content type: " + contentType);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
            
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            
            in.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    static void post(String urlText) {
        
        try {            
            URL url = new URL(urlText);
            HttpURLConnection httpConn = ((HttpURLConnection) url.openConnection());
            
            httpConn.setRequestMethod("POST");
            httpConn.setDoOutput(true);
            
            OutputStreamWriter out = new OutputStreamWriter(httpConn.getOutputStream());
            out.write("propietat1=valor1&propietat2=valor2");
            out.close();
            
            int responseCode = httpConn.getResponseCode();
            System.out.println("response code: " + responseCode);
            
            String contentType = httpConn.getContentType();
            System.out.println("content type: " + contentType);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
            
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            
            in.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
}
