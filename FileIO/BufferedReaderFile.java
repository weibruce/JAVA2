import java.io.*;

/**
 * Read ASCII text from a file, one line at a time, and display it to the screen.
 */
public class BufferedReaderFile
{
    public static void main(String[] args) throws IOException
    {
        // Declare a File object for the file we want to read from
        File file = new File("ascii.txt");
        // Instantiate a FileReader class and link it to the ascii.data file
        FileReader fileReader = new FileReader(file);
        // Overlay the FileReader class with a BufferedReader, to optimize reading from the hard drive
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        //String that will contain record read in
        String recordData;
        // Read in the record
        // Note: This assumes there is only 1 line in the file as this will read 1 line of data 
        // (Until a carraige return / new line character is found)
        recordData = bufferedReader.readLine();
        //recordData = bufferedReader.readLine();
        
        //prints out the record
        System.out.println(recordData);
        // closes the reader (automatically flushes the buffer as well)
        bufferedReader.close();
    }
}
