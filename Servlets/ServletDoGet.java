import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * INPUT: Request from client browser, calling doGet
 * PROCESSING: This class demonstrates how a simple servlet works.
 *      The request is sent by the client, which invokes the doGet method. 
 *      The doGet method then sends a response to the client, by sending HTML 
 *      to a stream that is linked to the client
 * OUTPUT: a custom web page is sent to client browser.
 */
public class ServletDoGet extends HttpServlet
{
    /**
     * This method is called by the client when they click on the form button
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Declare a PrintWriter, which will be used to write custom HTML back to the client
        PrintWriter output;
        
        // Initialize the writer stream, set it to send back HTML
        // sets content type
        response.setContentType("text/html");
        // get writer
        output = response.getWriter();
        
        // custom html sent back to the client
        output.println("<html> \n" +
                        "<head> <title> Simple Page </title> </head> \n" +
                        "<body> \n" +
                        "<body> \n" +
                        " <h1>Red River College</h1> \n" +
                        " <hr> \n" +
                        " <blink><h2>Computer Education Department</h2></blink>\n" +
                        " <p> \n" +
                        " <h3><u>Advanced Java / Advanced OOP</u></h3> \n" +
                        " </p> \n" +
                        " <p> \n" +
                        " <b><h2>Servlet Created using the Get Method</b></h2> \n" + 
                        " </p> \n" +
                        " </center> \n" +
                        "</body> \n" +
                        "</html>");
        
        // close PrintWriter stream
        output.close();
    }
}
