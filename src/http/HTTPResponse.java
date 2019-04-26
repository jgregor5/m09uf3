package http;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author julian
 */
public class HTTPResponse {

    private final PrintWriter out;
    private final BufferedOutputStream dataOut;
 
    HTTPResponse(PrintWriter out, BufferedOutputStream dataOut) {
        this.out = out;
        this.dataOut = dataOut;
    }
    
    public PrintWriter getWriter() {        
        return out;
    }
    
    public BufferedOutputStream getOutputStream() {
        return this.dataOut;
    }
}
