import java.awt.*;
import javax.swing.*;

/**
 * JFrame Application to test your application
 */
public class BookInventoryClient extends JFrame
{
    private Container           c;
    private BookInventoryGUI    gui;

    /**
     * Constructor for objects of class BookInventoryClient
     */
    public BookInventoryClient()
    {
        c = getContentPane();
        gui = new BookInventoryGUI();
        c.add(gui);
        
        // Set JFrame parms & then pack
        setTitle("Write Book Inventory Objects");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public static void main(String[] args)
    {
        BookInventoryClient app = new BookInventoryClient();
    }
}
