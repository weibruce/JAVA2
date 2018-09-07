import java.io.*;

/**
 * writes one comma-delimited text record to a file 
 * (also known as, “comma separated values”)
 */
public class PrintWriterFile
{
    public static void main(String[] args) throws IOException
    {
        // Define the FILE to wich we want to write
        File file = new File("ascii.txt");
        // Declare the FileOutputStream class and link it to the FILE we want to write to
        FileOutputStream output =  new FileOutputStream(file);
        // Overlay the FileOutputStream with a PrintWriter class so that String data may be written to the stream
        PrintWriter outputWriter = new PrintWriter(output);
        
        //Writes strings(fields) to file
        outputWriter.print("John Doe");
        outputWriter.print(",");
        outputWriter.print("123 Anywhere Street");
        outputWriter.print("\n");
        outputWriter.print("Winnipeg");
        outputWriter.print(",");
        outputWriter.print("Manitoba");
        outputWriter.print(",");
        outputWriter.print("R4C 5F5");
        outputWriter.print(",");
        outputWriter.print("2042244345");
        // Close the connection to the file
        outputWriter.close();
    }
}
