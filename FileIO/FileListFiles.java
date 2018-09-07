import java.io.*;
import java.util.Date;

/**
 * Displays the contents of C:\\Program Files folder.
 * Uses additional methods of the File object.
 * Uses examples of the conditional ternary operator (?:) and Date class
 */
public class FileListFiles
{
    public static void main(String[] args)
    {
        // Create an object that is a directory
        File directory = new File("/Users/Bruce/Desktop");
        System.out.println(directory.getAbsolutePath() + 
                            (directory.isDirectory()?" is ":" is not ") + 
                            "directory");
        System.out.println("The parent of " + directory.getName() + 
                            " is " + directory.getParent());
        
        // Get the contents of the directory
        File[] contents = directory.listFiles();
        
        // List the contents
        if(contents != null)
        {
            System.out.println("\nThe " + contents.length + 
                                " matching items in the directory '" + 
                                directory.getName() + "' are:");
            for(int i = 0; i < contents.length; i++)
            {
                System.out.println(contents[i] + " is a " + 
                                (contents[i].isDirectory() ? "directory":"file") +
                                " last modified " + new Date(contents[i].lastModified() ));
            }
        }
        else
        {
            System.out.println(directory.getName() + " is not a directory");
        }
        
        return;
    }
}