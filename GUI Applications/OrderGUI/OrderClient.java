import java.awt.*;
import javax.swing.*;

/**
 * The OrderClient class creates the instance of the JFrame to display the GUI
 * for Brandi's Bagel House application.
 */
public class OrderClient extends JFrame
{
    private OrderGUI gui;   // OrderGUI panel
    private Container c;

    /**
     * Constructor for objects of class OrderClient
     */
    public OrderClient()
    {
        // Add the OrderGUI panel
        gui = new OrderGUI();
        c = getContentPane();
        c.add(gui);
        
        // Set JFrame parms & then pack
        setTitle("Order Calculator");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    /**
     * Creates the instance of the JFrame to display the GUI
     */
    public static void main(String[] args)
    {
        OrderClient bagelApp = new OrderClient();
    }
}
