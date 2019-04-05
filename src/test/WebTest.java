package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author julian
 */
public class WebTest {
    
    private static final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) {
        
        System.out.println(">>>> READ STREAM");
        readWebPageStream("http://web.inslaferreria.cat/");
        System.out.println(">>>> READ CONNECTION");
        readWebPageConnection("http://web.inslaferreria.cat/");
    }

    static void readWebPageStream(String urlText) {

        BufferedReader in = null;
        try {
            URL url = new URL(urlText);
            in = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }

            in.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    
    static void readWebPageConnection(String urlText) {

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
}

