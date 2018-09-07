import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class demonstrates the BorderLayout manager.
 */
public class BorderLayoutWindow extends JFrame
{
    private final int   WINDOW_WIDTH = 400,
                        WINDOW_HEIGHT = 300;
    private Container   c;

    /**
     * Constructor for objects of class BorderWindow
     */
    public BorderLayoutWindow()
    {
        c = getContentPane();
        c.setLayout(new BorderLayout());
        
        // Create five buttons.
        JButton button1 = new JButton("North Button"),
                button2 = new JButton("South Button"),
                button3 = new JButton("East Button"),
                button4 = new JButton("West Button"),
                button5 = new JButton("Center Button");
                
        // Add the five buttons to the content pane.
        c.add(button1, BorderLayout.NORTH);
        c.add(button2, BorderLayout.SOUTH);
        c.add(button3, BorderLayout.EAST);
        c.add(button4, BorderLayout.WEST);
        c.add(button5, BorderLayout.CENTER);
        
        // Set JFrame parms:
        // Set the title bar text. JFrajme visibility, its window size, an action for the close button
        setTitle("Border Layout ");
        setVisible(true);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * The main method creates an instance of the BorderWindow class, causing 
     * it to display its window.
     */
    public static void main(String[] args)
    {
        BorderLayoutWindow app = new BorderLayoutWindow();
    }
}
