import java.awt.*;
import javax.swing.*;

/**
 * The JoesAutoClient class creates the instance of the JFrame to display the 
 * GUI for Joe’s Automotive application.
 */
public class JoesAutoClient extends JFrame
{
    final int               WINDOW_WIDTH = 300,
                            WINDOW_HEIGHT = 300;
    protected JoesAutoGUI   gui;
    protected Container     c;

    /**
     * Constructor for objects of class JoesAutoClient
     */
    public JoesAutoClient()
    {
        c = getContentPane();
        gui = new JoesAutoGUI();
        c.add(gui);
        
        // Set JFrame parms:
        // Set the title bar text. JFrajme visibility, its window size, an action for the close button
        setTitle("Joe’s Automotive");
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    /**
     * Declares and creates one instance of the JoesAutoClient class
     */
    public static void main(String[] args)
    {
        JoesAutoClient jac = new JoesAutoClient();
    }
}
