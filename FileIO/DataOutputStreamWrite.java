import java.io.*;

/**
 * Write a description of class WriteBinaryFile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DataOutputStreamWrite
{
    public static void main(String[] args) throws IOException
    {
        // An array to write to the file
        int[] numbers = {97, 98, 99, 100, 101, 102, 103, 104, 105};
        
        // Create the binary output objects.
        FileOutputStream fos = new FileOutputStream("Numbers.txt");
        DataOutputStream outputFile = new DataOutputStream(fos);
        
        System.out.println("Writing the numbers to the file...");
        
        // Write the array elements to the file.
        for(int i = 0; i < numbers.length; i++)
        {
            outputFile.writeInt(numbers[i]);
            System.out.print(numbers[i]);
        }
        
        System.out.println("\nDone.");
        // Close the file.
        outputFile.close();
    }
}
