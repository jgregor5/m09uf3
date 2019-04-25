package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 *
 * @author julian
 */
public class ToUpperMultiServer {

    static final int PORT = 6666;
    private static final int NFILS = 100;
    private static final Executor executor = Executors.newFixedThreadPool(NFILS);

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(PORT);

        while (true) {
            
            Socket clientSocket = serverSocket.accept();
            Runnable tasca = new Runnable() {
                @Override
                public void run() {
                    atendrePeticio(clientSocket);
                }
            };
            executor.execute(tasca);
        }

        // serverSocket.close(); <= this is unreachable
    }

    private static void atendrePeticio(Socket clientSocket) {

        try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); 
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            
            out.println("hola!");
            
            String text;
            while ((text = in.readLine()).length() > 0) {
                out.println(text.toUpperCase());
            }
            
            out.println("adeu!");
            
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        finally {
            try {
                clientSocket.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
