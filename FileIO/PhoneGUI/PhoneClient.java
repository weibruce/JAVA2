import java.awt.*;
import javax.swing.*;

/**
 * Declare SWING and GUI components
 */
public class PhoneClient extends JFrame
{
    private PhoneGUI    gui;
    private JButton     createObjectButton;
    private Container   c;

    /**
     * Constructor for objects of class PhoneList
     */
    public PhoneClient()
    {
        // Instantiate the GUI object
        super("Creating phone List");
        c = getContentPane();
        c.setLayout(new BorderLayout());
        // Instantiate the GUI component
        gui = new PhoneGUI();
        
        // Set the properties of the Frame
        c.add(gui,  BorderLayout.CENTER);
        setSize(300,200);
        setVisible(true);
    }

    /**
     * Use the Main method to create the phone list application
     */
    public static void main(String[] args)
    {
        PhoneClient app = new PhoneClient();
    }
}
