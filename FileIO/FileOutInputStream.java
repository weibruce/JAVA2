import java.io.*;

/**
 * reading and writing bytes from a file
 * ASCII code
 * 100:d, 101:e, 102:f, 103:g, 104:h, 105:i, 106:j, 107:k, 
 */
public class FileOutInputStream
{
    public static void main(String[] args)
    {
        try
        {
            File file = new File("datasamp.txt");
            FileOutputStream output = new FileOutputStream(file);
            byte[] byteArrayOut = {100, 101, 102, 103, 104, 105, 106, 107};
            output.write(byteArrayOut);
            output.close();
            
            FileInputStream input = new FileInputStream(file);
            int size = byteArrayOut.length;
            byte[] byteArrayIn = new byte[size];
            input.read(byteArrayIn);
            
            for(int i = 0; i < size; i++)
            {
                System.out.println(byteArrayIn[i]);
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}
