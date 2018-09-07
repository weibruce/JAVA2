import java.awt.*;
import javax.swing.*;

/**
 * Perform data validation on each of three text fields when the user tabs to 
 * another field
 */
public class FocusClient extends JFrame
{
    private FocusGUI    gui;
    private Container   c;

    /**
     * Constructor for objects of class FocusClient
     */
    public FocusClient()
    {
        //create the instance of the GUI
        gui = new FocusGUI();
        
        c = getContentPane();
        c.add(gui);
        
        //set the frame size, title and make it show up
        setSize(400, 125); 
        setTitle("FocusListener Example");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * creates the instance of the frame
     */
    public static void main(String[] args)
    {
        FocusClient fc = new FocusClient();
    }
}
