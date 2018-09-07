import java.io.*;
import javax.swing.*;

/**
 * Demo Program for the Crypto class
 * Input: An input file is selected using a JFileChooser
 * Process: This program makes an encrypted copy of an existing file. 
 * Output: The encrypted copy is stored as "Encrypted.txt".
 */
public class FileChooserEncryption
{
    public static void main(String[] args)
    {
        System.out.println("Open a text *.txt file to encrypt\n" +
            "The encrypted file is saved as 'Encrypted.txt'");
        
        try
        {
            //Create a file chooser
            final JFileChooser fc = new JFileChooser();
            int value = fc.showOpenDialog(null);
            //JFileChooser.CANCEL_OPTION    user clicked on the Cancel button.
            //JFileChooser.APPROVE_OPTION   user clicked on Open or Save.
            //JFileChooser.ERROR_OPTION     user clicked on the window close icon.
            if (value == JFileChooser.APPROVE_OPTION)
            {
                File file = fc.getSelectedFile();
                String fname = file.getAbsolutePath();
                JOptionPane.showMessageDialog(null, "You selected " + fname);
                Crypto.encryptFile(fname, "Encrypted.txt");
                System.out.println("Done. Use Notepad to inspect the encrypted file.");
            }
            else
            {
                System.out.println("Open command cancelled by user.\n" + 
                    "Program terminated.");
                System.exit(0);
            }
        }
        catch(IOException e)
        {
            System.out.println("Error - " + e.getMessage());
        }
    }
}