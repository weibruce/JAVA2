import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class demonstrates the GridLayout manager.
 */
public class GridLayoutWindow extends JFrame
{
    private final int   WINDOW_WIDTH = 400,
                        WINDOW_HEIGHT = 200;
    private Container   c;

    /**
     * Constructor for objects of class GridWindow
     */
    public GridLayoutWindow()
    {
        c = getContentPane();
        // Add a GridLayout manager to the content pane.
        //c.setLayout(new GridLayout(2, 1));
        c.setLayout(new GridLayout(2, 3, 5, 5));
        
        // Create six buttons.
        JButton button1 = new JButton("Button 1"),
                button2 = new JButton("Button 2"),
                button3 = new JButton("Button 3"),
                button4 = new JButton("Button 4"),
                button5 = new JButton("Button 5"),
                button6 = new JButton("Button 6");
        
        // Add the six buttons to the content pane.
        // go into row 1, columns 1, 2, 3
        c.add(button1);
        c.add(button2);
        c.add(button3);
        // go into row 2, columns 1, 2, 3
        c.add(button4);
        c.add(button5);
        c.add(button6);
        
        // Set JFrame parms:
        // Set the title bar text. JFrajme visibility, its window size, an action for the close button
        setTitle("Grid Layout");
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * The main method creates an instance of the GridWindow class, causing it 
     * to display its window.
     */
    public static void main(String[] args)
    {
        GridLayoutWindow app = new GridLayoutWindow();
    }
}
