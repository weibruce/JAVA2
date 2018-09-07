import java.io.*;

/**
 * The program prompts the user to input lines of text and press CTRL-C when done.
 * When the user presses CRTL-C the value equals –1
 * The text the user types is stored in a file called lines.txt
 */
public class OutInputStream
{
    public static void main(String[] args) throws IOException
    {
        // Declare the parent Stream classes for input and output
        InputStream inputStream;
        OutputStream outputStream;
        //input is from the keyboard
        inputStream = System.in;
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Decare the File object to where we want to write
        // Since no directory is declared, the file will be created in the current directory 
        File outFile = new File ("lines.txt");
        
        // Instantiate the OutputStream as a FileOutputStream linked to the line.txt File
        outputStream = new FileOutputStream(outFile);
        System.out.println("Enter text and end with a Crtl- c:");
        int c;
        
        try
        {
            // Create a WHILE loop that will read each character as it is typed in the DOS window, and send it to the OUTPUT stream.
            // An integer value of -1 will be returned when <CTRL>-C is pressed
            
            //while ( (c = inputStream.readLine()) != -1)
            while ( (c = inputStream.read()) != -1)
            {
                System.out.println(inputStream.read());
                // Convert the read value into an ASCII Char
                c = (char)c;
                // Write the character to the file
                outputStream.write(c);
            }
            
            // Flush will force any characters still in the OutputStream Buffer to be sent to the file
            outputStream.flush();
            
            // Close both the INPUT and OUTPUT stream connections
            inputStream.close();
            outputStream.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}
