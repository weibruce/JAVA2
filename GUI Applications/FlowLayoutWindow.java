import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class demonstrates how to use a FlowLayout manager with the content pane.
 */
public class FlowLayoutWindow extends JFrame
{
    private final int   WINDOW_WIDTH = 250,
                        WINDOW_HEIGHT = 100;
    private Container   c;

    /**
     * Constructor for objects of class FlowWindow
     */
    public FlowLayoutWindow()
    {
        c = getContentPane();
        //c.setLayout(new FlowLayout());
        // Additional constructor to right align and change the
        // horizontal and vertical gaps between buttons
        c.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
        
        // Create three buttons.
        JButton button1 = new JButton("Button 1"),
                button2 = new JButton("Button 2"),
                button3 = new JButton("Button 3");
        // Add the three buttons to the content pane.
        c.add(button1);
        c.add(button2);
        c.add(button3);
        
        // Set JFrame parms:
        // Set the title bar text. JFrajme visibility, its window size, an action for the close button
        setTitle("Flow Layout ");
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * The main method creates an instance of the FlowWindow class, causing it 
     * to display its window.
     */
    public static void main(String[] args)
    {
        FlowLayoutWindow app = new FlowLayoutWindow();
    }
}
