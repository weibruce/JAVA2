import java.io.*;
import java.util.Scanner;

/**
 * This application can be used to make copies of any type of file.
 */
public class Copy
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String inputSource = "";
        String inputTarget = "";
        String inputYes = "";
        boolean isCopy = false;
        File sourceFile;
        File targetFile;
        FileInputStream inputStream;
        FileOutputStream outputStream;
        //InputStream 
        
        
        
        System.out.println("File Copy Utility");
        //Prompt the user to enter a source file and target file.
        System.out.print("Source File: ");
        inputSource = keyboard.nextLine();
        System.out.print("Target File: ");
        inputTarget = keyboard.nextLine();
        
        try
        {
            sourceFile = new File(inputSource);
            targetFile = new File(inputTarget);
            if(targetFile.exists())
            {
                System.out.println("Target file " + inputTarget + " already exists");
                System.out.print("Do you wish to delete " + inputTarget + "?(Y/N)");
                inputYes = keyboard.nextLine();
                if(inputYes.equalsIgnoreCase("y"))
                {
                    isCopy = true;
                }
                else
                {
                    System.out.println("Source file not copied.");
                    isCopy = false;
                }
            }
            else
            {
                isCopy = true;
            }
            
            if(isCopy)
            {
                inputStream = new FileInputStream(sourceFile);
                outputStream = new FileOutputStream(targetFile);
                byte[] bytes = new byte[1024];
                int i = 0;
                while((i = inputStream.read(bytes)) != -1)
                {
                    outputStream.write(bytes, 0, i);
                    outputStream.flush();
                }
                
                System.out.println("\nThe file " + inputSource + " had " + sourceFile.length() + " bytes copied");
                System.out.println("The file path is " + targetFile.getAbsolutePath());
                System.out.println("\nCopy done!");
            }
            
            
        }
        catch(IOException e)
        {
            //System.out.println(e);
            System.out.println("Source file " + inputSource + " does not exist");
            System.out.println("Source file not copied.");
        }
    }
}
