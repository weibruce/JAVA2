import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


/**
 * INPUT: The client is asked to choose a post secondary college of interest.
 *      This selection is sent to the server. This class processes it.
 * PROCESSING: Send a cookie onto the client machine that stores the college 
 *      they selected
 * OUTPUT: Based on the area of selection selected, send an appropriate HTML 
 *      page back to the client
 */
public class ServletCookies extends HttpServlet
{
    // Declare constant parallel arrays that stores western province codes, and their corresponding recommended college's name, motto & html web link
    private final String[]   PROV_CODES = {"BC", "AB", "SK", "MB"},
                                    COLLEGES = {"BCIT", "SAIT", "SIAST", "RRC"},
                                    MOTTOES = {"Technology-Changes-Everything.",
                                            "Real_World_Training",
                                            "Offering_You_Real_Choices",
                                            "Setting_the_Standard_Meeting_the_Demand."},
                                    COLLEGE_WEB_LINKS = {
                                        "<a href=http://www.bcit.ca> British Columbia Institute of Technology </a><p>",
                                        "<a href=http://www.sait.ca> Southern Alberta Institute of Technology </a><p>",
                                        "<a href=http://www.siast.sk.ca> Saskatchewan Institute of Applied Science and Technology </a><p>",
                                        "<a href=http://www.rrc.mb.ca> Red River College of Applied Arts, Science and Technology</a><p>"};
    
    /**
     * doPost method is called when the client SENDS information to the server.
     * The information being sent will be the area of interest. 
     * This method will then create a COOKIE with the province chosen, and 
     * send that cookie back to the client machine
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Declare the output stream which will write HTML back to the client
        PrintWriter output;
        // Retrieve the province code. The province is the name of the chosen radio button on the HTML form
        String  provCode = request.getParameter("province"),
                college = getSchool(provCode);
        // Create a cookie setting its name to the province and its text to the recommended college name
        Cookie c = new Cookie(provCode, college);
        
        // Set the age of the cookie. It will expire in this many seconds
        c.setMaxAge(120);
        // Send the cookie to the client. This must precede any HTML sent via the writer and before the getWriter() method is called
        response.addCookie(c);
        // Initialize the stream to send HTML to the client
        response.setContentType("text/html");
        output = response.getWriter();
        // send HTML page to client
        output.print("<html> \n"+
                    "<head><title> Cookies Example </title></head> \n"+
                    "<body> \n" +
                    "<center> \n" +
                    "<p><h2>Recommended College Links</h2></p><br/>\n"+
                    "<hr/>\n"+
                    "<p><h3><u><b>\n"+ college + "</h3></u></b></p> \n"+
                    "</center>\n" +
                    "</body>\n" +
                    "</html>");
        // close stream
        output.close();
    }

    /**
     * Given an province code of interest, this method will find the college 
     * name and motto in the appropriate arrays.
     */
    private String getSchool(String provCode)
    {
        String college = "";
        for(int i = 0; i < COLLEGES.length; i++)
        {
            if(provCode.equals(PROV_CODES[i]))
            {
                college = COLLEGES[i]+":"+MOTTOES[i];
            }
        }
        return college;
    }
    
    /**
     * This method is called when the client requests information from the 
     * server with "GET". It will retrieve the cookie on the client machine 
     * and send back HTML based on what is stored in the cookie
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Declare the output stream to write HTML
        PrintWriter output;
        // Delcare an array to store all cookies
        Cookie[] cookies;
        // Store the clients cookies in the array
        cookies = request.getCookies();
        
        // Initialize the stream to send HTML to the client
        response.setContentType("text/html");
        output = response.getWriter();
        // Print out HTML headers
        output.println("<html>\n" + 
                    " <head>\n" +
                    " <title> Colleges you are interested in </title>\n"+
                    " </head>\n"+
                    " <body>" );
                    
        // If there were cookies that were returned
        if(cookies != null)
        {
            output.println(" <h1>Canadian Colleges</h1><hr>\n" +
                        " <h1>Recommended Links</h1><p>");
                        
            // For each cookie in the array, if its name is equal to one of the provinces of interest that were set up, print out the html link to the college web page for course information
            for(int i = 0; i < cookies.length; i++)
            {
                for(int j = 0; j < PROV_CODES.length; j++)
                {
                    if(cookies[i].getName().equals(PROV_CODES[j]))
                    {
                        output.println(" " + COLLEGE_WEB_LINKS[j]);
                    }
                }
            }
        }
        else
        {
            // If no cookies were found, no areas of interest were chosen, So display an appropriate message
            output.println("<h1>No Recommendations</h1>\n" +
                        "You did not select a college of interest, or the cookies have expired" +
                        " </body>\n"+
                        "</html>");
            // close stream
            output.close();
        }
    }
}
