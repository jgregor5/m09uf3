package http;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author julian
 */
public class HTTPProcessor {
    
    public void process(HTTPRequest req, HTTPResponse res) {       
                
        switch (req.getRequestURI()) {
            default:
                defaultProcess(req, res);           
        }
    }
    
    private void defaultProcess(HTTPRequest req, HTTPResponse res) {
        
        // PROCESS
            
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body><h1>");
        sb.append(req.getMethod()).append(" ").append(req.getRequestURI()).append("?").append(req.getQueryString());
        sb.append("</h1><ul>");
        
        Set<String> names = req.getHeaderNames();
        for (String name: names) {
            sb.append("<li>").append(name).append(": ").append(req.getHeader(name)).append("</li>");
        }
        
        sb.append("</ul>");
        
        String body = req.getBody();
        if (body != null && body.length() > 0) {
            sb.append("<h2>body</h2><p>").append(body).append("</p>");
        }
        
        sb.append("</body></html>");
        
        // WRITE
        
        PrintWriter out = res.getWriter();
        String html = sb.toString();
        
        out.println("HTTP/1.1 200 Ok");
        out.println("Server: jgregor5");
        out.println("Date: " + new Date());
        out.println("Content-type: text/html");
        out.println("Content-length: " + html.length());        
        out.println(); // blank line!
        out.println(html);
        out.flush();
    }
    
}
