import java.io.*;

/**
 * The encryptFile method makes an encrypted copy of an existing file.
 * 
 * @param existing The name of the existing file to encrypt. 
 * @param encrypted The name of the encrypted file to create. 
 * @exception IOException When an IO error occurs.
 */
public class Crypto
{
    public static void encryptFile(String existing, String encrypted) throws IOException
    {
        int input;
        // Open the files.
        FileReader fr = new FileReader(existing);
        FileWriter fw = new FileWriter(encrypted);
        
        // Read the first character from the file.
        input = fr.read();
        
        // Process the file.
        while (input != -1)
        {
            //System.out.println(input);
            // Encrypt the character.
            input += 10;
            // Write the character to the new file. 
            fw.write(input);
            // Read the next character to encrypt.
            input = fr.read();
        }
        
        // Close the files.
        fr.close();
        fw.close();
    }
}