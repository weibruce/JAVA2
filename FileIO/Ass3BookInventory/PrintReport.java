import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;
import java.text.DecimalFormat;

/**
 * This class reads in a comma-delimited text file called “Books.txt” one 
 * line at a time. Output will be displayed and formatted according to Figure 2.
 */
public class PrintReport
{
    public static void main(String[] args)
    {
        File file;
        FileReader fileReader;
        BufferedReader bufferedReader;
        ArrayList<BookInventory> bookInventorys = new ArrayList<BookInventory>();
        StringTokenizer tokenizer;
        String recordData = "";
        int recordNumber = 0;
        double totalCost = 0;
        DecimalFormat df = new DecimalFormat("#,##0.00");
        
        System.out.println("Print Book Inventory Records");
        System.out.println("\nRec #\tInput Record");
        System.out.println();
        
        try
        {
            // Read book inventory records from file
            file = new File("Books.txt");
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            recordData = bufferedReader.readLine();
            recordNumber++;
            while (recordData != null)
            {
                // Use the StringTokenizer to pull out all fields frorm the String
                tokenizer = new StringTokenizer(recordData, ",");
                String ISBN = tokenizer.nextToken();
                String title = tokenizer.nextToken();
                int qoh = Integer.parseInt(tokenizer.nextToken());
                double price = Double.parseDouble(tokenizer.nextToken());
                // create BookInventory instance
                BookInventory bi = new BookInventory(ISBN, title, qoh, price);
                // add BookInventory instance to bookInventorys list
                bookInventorys.add(bi);
                
                System.out.println(recordNumber + "\t" + recordData);
                recordNumber++;
                recordData = bufferedReader.readLine();
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        
        // Print Sorted Book Inventory Records
        System.out.println("\nPrint Sorted Book Inventory Records");
        System.out.println();
        Collections.sort(bookInventorys);
        
        for(BookInventory bi : bookInventorys)
        {
            System.out.println(bi);
            System.out.println();
            totalCost += bi.getInvCost();
        }
        
        // calculate inventory total cost
        System.out.println("Inventory Cost TOTAL = " + df.format(totalCost));
        
        System.out.println("\n*** Program executed successfully.***");
    }
}
