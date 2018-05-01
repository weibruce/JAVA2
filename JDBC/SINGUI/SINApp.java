import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * INPUT: None
 * PROCESSING: class SINApp
 *      This class is the Application component of the SINApp Application.
 *      It will instantiate the JFrame application and add the JPanel component.
 * OUTPUT: None
 */
public class SINApp extends JFrame
{
    private Container       c = getContentPane();
    private SINAddRecordGUI gui;

    /**
     * Constructor for objects of class SINApp
     */
    public SINApp()
    {
        // Instantiate the GUI class
        gui = new SINAddRecordGUI();
        // Add the GUI to the container
        c.add(gui);
        
        // Set JFrame parms & then pack
        setTitle("Add Record to SIN Table");
        setSize(450,550);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Instantiate the JFrame application in the main method
     */
    public static void main(String[] args)
    {
        SINApp app = new SINApp();
        
        //Shut down the DB when the user closes the application window
        app.addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                    SINDatabase.close();
                    System.exit(0);
                }
            });
    }
}
