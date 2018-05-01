import java.io.*;
import java.text.DecimalFormat;
import javax.swing.*;

/**
 * This clas will input the file “Books.dat” from the previous question.
 */
public class PrintBookObjects
{
    public static void main(String[] args)
    {
        ObjectInputStream inputStream;
        //File file = new File("Books.dat");
        boolean endOfFile = false;
        double totalCost = 0;
        BookInventory bi;
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        
        try
        {
            //Use a JFileChooser to select the above file
            JFileChooser fc = new JFileChooser();
            int status = fc.showOpenDialog(null);
            if (status == JFileChooser.APPROVE_OPTION)
            {
                File selectedFile = fc.getSelectedFile();
                selectedFile = fc.getSelectedFile();
                String fname = selectedFile.getName();
                if(!fname.equals("Books.dat"))
                {
                    System.out.println("Please choose the 'Books.dat' file.\n" + 
                        "And try again.");
                    System.exit(0);
                }
                else
                {
                    // Print Book Inventory Records
                    System.out.println("Print Book Inventory Records");
                    System.out.println();
                    
                    inputStream = new ObjectInputStream(new FileInputStream(selectedFile));
                    
                    while(!endOfFile)
                    {
                        try
                        {
                            bi = (BookInventory) inputStream.readObject();
                            // print it’s contents using its toString() method
                            System.out.println(bi);
                            System.out.println();
                            //accumulate the inventory cost total
                            totalCost += bi.getInvCost();
                        }
                        catch(EOFException e)
                        {
                            // After all records have been read, print out the total inventory cost of all objects
                            System.out.println("Inventory Cost TOTAL = " + df.format(totalCost));
                            endOfFile = true;
                        }
                        catch(ClassNotFoundException e)
                        {
                            System.out.println(e);
                        }
                    }
                }
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
            System.out.println(e);
        }
    }
}
