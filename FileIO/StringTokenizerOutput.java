import java.io.*;
import java.util.StringTokenizer;

/**
 * Reads in the following comma-delimited text file one line at a time.
 * Splits the line into separate fields and prints the fields out.
 */
public class StringTokenizerOutput
{
    public static void main(String[] args)
    {
        // Variables which will hold the delimited fields from one line read from the file
        String          recordData,
                        firstName,
                        lastName,
                        sinNumber;
        int             age;
        // The StringTokenizer will parse the data from the read String
        StringTokenizer tokenizer;
        
        try
        {
            // Overlay a BufferedReader class over a FileReader to optimize reading from the hard drive
            BufferedReader bufferedReader = new BufferedReader(new FileReader("sin.txt"));
            // Read the first record from the File
            recordData = bufferedReader.readLine();
            
            System.out.println("FirstName LastName SIN Age");
            // When EOF (End Of File) is hit, a NULL value will be returned. We therefore use the following WHILE loop toprocess all lines in the text file
            while(recordData != null)
            {
                // Instantiate a StringTokenizer based on the entire line read in from the file The default delimeter is a space
                tokenizer = new StringTokenizer(recordData, ",");
                // Use the StringTokenizer to pull out all fields frorm the String
                firstName = tokenizer.nextToken();
                //System.out.println(firstName);
                lastName = tokenizer.nextToken();
                sinNumber = tokenizer.nextToken();
                age = Integer.parseInt(tokenizer.nextToken());
                
                // Print out the read fields
                System.out.println(firstName+" "+lastName+" "+sinNumber+" "+age+"");
                
                // Read the next line from the file for the next iteration of the WHILE loop
                recordData = bufferedReader.readLine();
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}
