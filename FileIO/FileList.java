import java.io.*;
import javax.swing.*;

/**
 * Program: "FileTest.java"
 */
public class FileList
{
    public static void main(String[] args)
    {
        // Prompt User for Director
        String dirName = JOptionPane.showInputDialog("Enter Directory Name");
        // Instantiate the File Class (Directory)
        File directory = new File(dirName);
        
        if (directory.isDirectory())
        {
            System.out.println(dirName + " is a directory");
            // Retrieve the list of files in the directory as an array of Strings
            String[] files = directory.list();
            // Loop through the array, printing all files to the screen 
            for (int i=0 ; i < files.length; i++)
            {
                System.out.println(files[i]);
            }
        }
        else
        {
            System.out.println(dirName + "is not an existing directory");
        }
    }
}
