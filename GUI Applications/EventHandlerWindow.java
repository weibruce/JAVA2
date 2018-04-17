import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * This class demonstrates how to retrieve the action command from an event object.
 */
public class EventHandlerWindow extends JFrame
{
    private final int   WINDOW_WIDTH = 300,
                        WINDOW_HEIGHT = 70;
    private JPanel      panel;
    private JButton     button1,
                        button2,
                        button3;
    private Container   c;
    private ButtonHandler bh;

    /**
     * Constructor for objects of class EventObjectWindow
     */
    public EventHandlerWindow()
    {
        c = getContentPane();
        
        // Create the three buttons.
        button1 = new JButton("Button 1");
        button2 = new JButton("Button 2");
        button3 = new JButton("Button 3");
        // Register an event listener with all 3 buttons.
        bh = new ButtonHandler();
        button1.addActionListener(bh);
        button2.addActionListener(bh);
        button3.addActionListener(bh);
        
        // Create a panel and add the buttons to it.
        panel = new JPanel();
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        
        // Add the panel to the content pane.
        c.add(panel);
        
        // Set JFrame parms:
        // Set the title bar text. JFrame visibility, its window size, 
        // an action for the close button
        setTitle("Event Object Demonstration");
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * An example of a method - replace this comment with your own
     */
    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // Determine which button was clicked and display a message.
            if (e.getSource() == button1)
            //if (e.getActionCommand().equals("Button 1"))
            {
                JOptionPane.showMessageDialog(null, "You clicked the first button.");
            }
            else if (e.getSource() == button2)
            //else if (e.getActionCommand().equals("Button 2"))
            {
                JOptionPane.showMessageDialog(null, "You clicked the second button.");
            }
            else if (e.getSource() == button3)
            //else if (e.getActionCommand().equals("Button 3"))
            {
                JOptionPane.showMessageDialog(null, "You clicked the third button.");
            }
        }
    }
    
    public static void main(String[] args)
    {
        EventHandlerWindow app = new EventHandlerWindow();
    }
}
