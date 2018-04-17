import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * The ColorCheckBoxWindow class demonstrates how check boxes can be used.
 */
public class JCheckBoxWindow extends JFrame
{
    private final int   WINDOW_WIDTH = 300,
                        WINDOW_HEIGHT = 150;
    private JLabel      messageLabel;
    private JButton     button;
    private JCheckBox   yellowCheckBox,
                        redCheckBox;
    private CheckBoxListener cbl;
    private Container   c;

    /**
     * Constructor for objects of class ColorCheckBoxWindow
     */
    public JCheckBoxWindow()
    {
        c = getContentPane();
        
        // Create a label.
        messageLabel = new JLabel("Select the check boxes to change colors.");
        button = new JButton("Button Border");
        Border raisedBevelBorder    = BorderFactory.createRaisedBevelBorder();
        Border LineBorder           = BorderFactory.createLineBorder(Color.RED);
        Border titledBorder         = BorderFactory.createTitledBorder("Enter Name:");
        Border matteBorder          = BorderFactory.createMatteBorder(1,2,4,8, Color.red);
        //button.setBorder(raisedBevelBorder);
        //button.setBorder(LineBorder);
        //button.setBorder(titledBorder);
        button.setBorder(matteBorder);
        
        // Create the check boxes.
        yellowCheckBox = new JCheckBox("Yellow background");
        redCheckBox = new JCheckBox("Red foreground");
        
        //Instantiate an ItemListener event handler object
        cbl= new CheckBoxListener();
        // Add an item listener to the check boxes.
        yellowCheckBox.addItemListener(cbl);
        redCheckBox.addItemListener(cbl);
        
        // Select the yellow check box and execute the itemStateChanged event
        yellowCheckBox.doClick();
        
        // Add a FlowLayout manager to the content pane.
        c.setLayout(new FlowLayout());
        // Add the label and check boxes to the content pane.
        c.add(messageLabel);
        c.add(yellowCheckBox);
        c.add(redCheckBox);
        c.add(button);
        
        // Set JFrame parms:
        // Set the title, visibility, size and action to perform upon close button clicked 
        setTitle("Color Check Boxes");
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * Private inner class that handles the event when the user clicks one of 
     * the check boxes.
     */
    private class CheckBoxListener implements ItemListener
    {
        public void itemStateChanged(ItemEvent e)
        {
            // Determine which check box was clicked.
            if (e.getSource() == yellowCheckBox)
            {
                // Is the yellow check box selected? If so, we want to set the background color to yellow.
                if (yellowCheckBox.isSelected())
                {
                    // The yellow check box was selected. Set the background color for the content pane and the two check boxes to yellow. 
                    getContentPane().setBackground(Color.YELLOW);
                    yellowCheckBox.setBackground(Color.YELLOW);
                    redCheckBox.setBackground(Color.YELLOW);
                }
                else
                {
                    // The yellow check box was deselected. Set the background color for the content pane and the two check boxes to light gray. 
                    getContentPane().setBackground(Color.LIGHT_GRAY);
                    yellowCheckBox.setBackground(Color.LIGHT_GRAY);
                    redCheckBox.setBackground(Color.LIGHT_GRAY);
                }
            }
            else if (e.getSource() == redCheckBox)
            {
                // Is the red check box selected? If so, we want to set the forground color to red.
                if (redCheckBox.isSelected())
                {
                    // The red check box was selected. Set the foreground color for the label and the two check boxes to red.
                    messageLabel.setForeground(Color.RED);
                    yellowCheckBox.setForeground(Color.RED);
                    redCheckBox.setForeground(Color.RED);
                }
                else
                {
                    // The red check box was deselected. Set the foreground color for the label and the two check boxes to black.
                    messageLabel.setForeground(Color.BLACK);
                    yellowCheckBox.setForeground(Color.BLACK);
                    redCheckBox.setForeground(Color.BLACK);
                }
            }
        }
    }

    /**
     * The main method creates an instance of the ColorCheckBoxWindow class, 
     * displaying its window.
     */
    public static void main(String[] args)
    {
        JCheckBoxWindow app = new JCheckBoxWindow();
    }
}
