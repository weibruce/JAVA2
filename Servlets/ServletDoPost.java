import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.DecimalFormat;

/**
 * INPUT: The Favorite Car Manufacturer is sent to the servlet via the POST 
 *      method of the website.
 * PROCESSING: This class will update a text file with the favorite car 
 *      manufacturer sent to it. It will then compile statistics on ALL 
 *      choices up to date.
 * OUTPUT: The current calculated statistics will be sent back to the client 
 *      via a custom HTML web page.
 */
public class ServletDoPost extends HttpServlet
{
    private final static String SURVEY_FILE = "SurveyResults.dat",
                                CAR_MANUFACTURERS[] = {"Chrysler",
                                    "GM",
                                    "Ford",
                                    "Honda",
                                    "Nissan",
                                    "Saturn"};
    
    /**
     * the doPost method will be called when the POST method is called from 
     * the client web page
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // File where favCarTotals is currently stored
        File surveyFile = new File(SURVEY_FILE);
        
        // Parallel arrays for keeping statistics
        double  percentages[] = new double[CAR_MANUFACTURERS.length];
        //total survey selections per car vendor.(Saved to survey-file)
        int     favCarTotals[] = null;
        // grand total survey reponses
        int     total = 0;
        
        // Instantiate favCarTotals[], or read it in from the statistics file
        if(!surveyFile.exists())
        {
            //If the file does not exist, no previous stats are held
            //create array, initialized to 0s
            favCarTotals = new int[CAR_MANUFACTURERS.length];
        }
        else
        {
            // If the File exists, then read in the todate survey totals from file
            try
            {
                // Declare & open the ObjectInputStream to read in the survey results File
                ObjectInputStream input = new ObjectInputStream(new FileInputStream(surveyFile));
                // Read from the file, casting the returned object into an array of integers. 
                // Store this in favCarTotals[]
                favCarTotals = (int[]) input.readObject();
                // Close the input stream
                input.close();
            }
            catch(ClassNotFoundException e)
            {
                System.out.println(e);
                e.printStackTrace();
            }
        }
            
        // Get the current survey response
        // In this example, "car" is the name given to the HTML radio button form
        String value = request.getParameter("car");
        
        // Determine which car was selected and update its selected total
        for(int i = 0; i < CAR_MANUFACTURERS.length; i++)
        {
            if(value.equals(CAR_MANUFACTURERS[i]))
            {
                favCarTotals[i]++;
            }
        }
        
        // Write updated totals out to disk. This will overwrite the existing file
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(surveyFile));
        output.writeObject(favCarTotals);
        output.flush();
        output.close();
        
        //Count TOTAL number of selected CAR_MANUFACTURERS. ( to calculate %ages)
        // If Chrysler has been chosen 3 times, and GM twice, then the total sum here will be 5
        for(int i = 0; i < favCarTotals.length; i++)
        {
            total += favCarTotals[i];
        }
        
        // Calculate the percentages that each car was chosen
        for(int i = 0; i < percentages.length; i++)
        {
            percentages[i] = (double) favCarTotals[i] / (double) total;
        }
        
        // Send a thank you message to client
        response.setContentType("text/html");
        
        // Use the PrintWrite to send HTML back to the client
        PrintWriter webOutput = response.getWriter();
        webOutput.println("<html>\n" +
                            "<head> <title>Thank you!</title> </head>\n" +
                            "<body>\n" +
                            "<center>\n" +
                            "<h1>Red River College Automotive</h1>\n" +
                            "<h2>Thanks you for your response.</h2>\n" +
                            "<h3>Survey Results:</h3>\n" +
                            "<b>\n" +
                            "<pre>\n" +
                            "Car Vendor\tResponses\n"+
                            "\tPercent\t\tTotal");
        DecimalFormat   percent = new DecimalFormat("#,##0.0%"),
                        integer = new DecimalFormat("#,##0");
                        
        
        for(int i = 0; i < CAR_MANUFACTURERS.length; i++)
        {
            webOutput.println(fmtString(CAR_MANUFACTURERS[i] + ":", 12, " ", 'L') + 
                            fmtString(percent.format(percentages[i]),8, " ", 'R') + 
                            fmtString(integer.format(favCarTotals[i]),10, " ", 'R'));
        }
        
        webOutput.print("</pre>\n" +
                    "Total responses: " + total + "\n" +
                    "</b>" +
                    " </body>\n" + 
                    "</html>" );
        
        // returns custom web page to the survey participant (user)
        webOutput.close();
    }
    
    /**
     * Method: fmtString() formats (places & aligns) a String in a fixed-size field
     * @parm s      String to be aligned in a field
     */
    private String fmtString(String s, int fieldSize, String space, char alignment)
    {
        final char  LEFT_ALIGN = 'L',
                    RIGHT_ALIGN = 'R';
        String      sFormatted = s;
        
        if(s.length() < fieldSize)
        {
            int numSpaces = fieldSize - s.length();
            if(alignment == LEFT_ALIGN)
            {
                for(int i = 1; i <= numSpaces; i++)
                {
                    sFormatted += space;
                }
            }
            else
            {
                for(int i = 1; i <= numSpaces; i++)
                {
                    sFormatted = space+sFormatted;
                }
            }
        }
        return sFormatted;
    }
}
