import java.io.*;

/**
 * This program opens a binary file, reads and displays the contents.
 */
public class DataInputStreamFile
{
    public static void main(String[] args) throws IOException
    {
        // A number read from the file 
        int number;
        // EOF flag
        boolean endOfFile = false;
        
        // Create the binary file input objects.
        FileInputStream fis = new FileInputStream("Encrypted.txt");
        DataInputStream inputFile = new DataInputStream(fis);
        System.out.println("Reading numbers from the file:");
        
        // Read the contents of the file.
        while (!endOfFile)
        {
            try
            {
                number = inputFile.readInt();
                System.out.print(number + " ");
            }
            catch(EOFException e)
            {
                System.out.println("\n" + e);
                endOfFile = true;
            }
        }
        
        System.out.println("Done.");
        
        // Close the file.
        inputFile.close();
    }
}
