import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

/**
 * INPUT: The client sends his name and email information
 * PROCESSING: This class connects to a database and updates a table with the 
 *      submitted client information
 * OUTPUT: A confirmation HTML webpage is sent back to the client
 */
public class ServletJDBC extends HttpServlet
{
    // Declare the objects required for JDBC
    private final static String DRIVER = "com.mysql.jdbc.Driver",
                            URL = "jdbc:mysql://localhost:3306/JDBC?useSSL=true";
    private Connection      connect;
    private Statement       statement;
    private boolean         badConnection = false;
    private String          errorType = "";

    /**
     * This method will initialize the connection to the database
     */
    public void init(ServletConfig config) throws ServletException
    {
        // Be sure to run any init() code in the superclass HttPServlet
        super.init(config);
        
        // Declare the driver, and Connect to the database
        try
        {
            //Class.forName(DRIVER).newInstance();
            //connect = DriverManager.getConnection(URL,"root","J5z8e5r5");
            badConnection= false;
            Class.forName(DRIVER);
            System.out.println("Driver test success");
            // conencts to the database
            connect = DriverManager.getConnection(URL,"root","J5z8e5r5");
            System.out.println("Connection test success");
        }
        catch(Exception e)
        {
            System.out.println("ERROR: Problem connecting to database\n"+ e);
            e.printStackTrace();
            connect = null;
            badConnection = true;
            errorType = e.toString() + "Connection Error";
        }
    }

    /**
     * This method is called when the client submits their form data
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        final String    BEGIN_HTML = "<html>\n"+
                                    "<head>\n"+
                                    "<title>Mailing List Registration </title>\n"+
                                    "</head>\n"+
                                    "<body>\n"+
                                    "<center>\n",
                        END_HTML = "\n </center>\n"+
                                    "</body>\n"+
                                    "</html>";
        // Declare String to hold name and email information
        String          firstName,
                        lastName,
                        emailAddress;
        boolean         good = true;
        
        // Retrieve the parameters posted to the server. The NAME in "" refers to the name of the HTML form control
        firstName = request.getParameter("first");
        lastName = request.getParameter("last");
        emailAddress = request.getParameter("email");
        
        // Initialize the output writer to send HTML back to the client
        PrintWriter output = response.getWriter();
        response.setContentType("text/html");
        output.println(BEGIN_HTML);
        
        // If the user does leaves a field blank, send an error message
        if(emailAddress.equals("") || firstName.equals("") || lastName.equals(""))
        {
            output.println("<h3>Please press the back button and enter all information</h3>");
            output.println(END_HTML);
            output.close();
            return;
        }
        
        // If we couldn't connect to the database, send an error message
        if(badConnection)
        {
            output.println("<h3>Could not connect to the database</h3>\n" + errorType);
            output.println(END_HTML);
            output.close();
            return;
        }
        
        try
        {
            // Get a Statement object
            statement = connect.createStatement();
            // Create SQL INSERT statement to insert the info into the servlet table
            String info = "'" + firstName + "','" + lastName + "','" + emailAddress +"'";
            // Execute the statement
            statement.execute("INSERT INTO MailList (FirstName, LastName, Email)"+
                            "values(" + info + ");");
            // Close the statement
            statement.close();
        }
        catch(SQLException e)
        {
            System.err.println("ERROR: Problem with adding new entry");
            e.printStackTrace();
            good = false;
        }
        
        // Return a confirmation message to the client if the insert worked, or, an error message if the data wasn't successfully inserted into the database
        if(good)
        {
            output.println("<h1>Thanks for your information</h1><hr> \n" +
                    "<h2>You will receive your first flyer in a week</h2>");
            output.println(END_HTML);
        }
        else
        {
            output.println("<h1>Information not added to the email database</h1>");
            output.println(END_HTML);
        }
        
        output.close();
    }
    
    /**
     * When the Servlet is no longer needed, close the database connection
     */
    public void destroy()
    {
        try
        {
            connect.close();
        }
        catch(Exception e)
        {
            System.out.println("Problem closing the database");
            e.printStackTrace();
        }
    }
}
