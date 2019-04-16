package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author julian
 */
public class ToUpperClient {
    
    static final int PORT = 6666;
    static final String HOST = "localhost";
 
    public static void main(String[] args) throws IOException {
        
        Socket clientSocket = new Socket(HOST, PORT);
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
        
        String salutacio = in.readLine();
        System.out.println("salutacio: " + salutacio);
        
        for (String text: new String[]{"u", "dos", "tres"}) {
            out.println(text);
            String resposta = in.readLine();
            System.out.println(text + " => " + resposta);
        }
        
        out.println();
        
        String comiat = in.readLine();
        System.out.println("comiat: " + comiat);
        
        in.close();
        out.close();
        clientSocket.close();
    }
}
