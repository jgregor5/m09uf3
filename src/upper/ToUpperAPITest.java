package upper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author julian
 */
public class ToUpperAPITest {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("HOST> ");
        String host = br.readLine();
        
        ToUpperAPI api = null; // crea l'objecte adient
                
        String salutacio = api.connect(host);
        System.out.println("salutació: " + salutacio);
        
        while (true) {
            System.out.print("TEXT> ");
            String line = br.readLine();
            if (line.length() == 0) {
                break;
            }
            
            System.out.println(line + " => " + api.toUpper(line));
        }
        
        String comiat = api.disconnect();
        System.out.println("comiat: " + comiat);
    }
}
