package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author julian
 */
public class ToUpperServer {
    
    static final int PORT = 6666;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket clientSocket = serverSocket.accept();
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        out.println("hola!");
        
        String text;
        while ((text = in.readLine()).length() > 0)        
            out.println(text.toUpperCase());

        out.println("adeu!");

        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}
