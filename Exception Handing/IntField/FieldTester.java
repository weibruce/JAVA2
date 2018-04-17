import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * INPUT: 
 * User will enter an integer into a textfield. (Must be less than 100)
 *
 * PROCESSING:
 * This class will instantiate a JFrame object with a custom TextField on it. 
 * Exception handling is used to catch errors that are thrown when String data
 * in the text field is converted to an integer
 */
public class FieldTester extends JFrame implements ActionListener
{
    // Declare variables for the GUI application
    private final int   WIDTH = 300,
                        HEIGHT = 300;
    private JPanel      panel;
    private JLabel      prompt;
    private IntField    intField;
    private int         userInt;
    private String      message = "Welcome to Field Tester!";
    private JTextField  messageTextField;
    private Container   c;

    /**
     * Constructor for objects of class FieldTester
     */
    public FieldTester()
    {
        c = getContentPane();
        
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        prompt = new JLabel("Enter an integer <= 100: ");
        intField = new IntField(12, 100); //length, max value
        messageTextField = new JTextField(20);
        messageTextField.setEditable(false);
        
        panel.add(prompt);
        panel.add(intField);
        panel.add(messageTextField);
        c.add(panel);
        
        intField.addActionListener(this);
        
        //set the frame size, title and make it show up
        setSize(400, 125); 
        setTitle("Field Tester");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent evt)
    {
        // Attempt to get the keyed in value by calling the custom getInt() method of the custome Text field
        try
        {
            userInt = intField.getInt();
            message = "You entered " + userInt + ". Thank you.";
            messageTextField.setText(message);
        }
        
        // Check for entered String data
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, 
                e.toString() + "The number must be an integer. Please re-enter.",
                "Error Message",
                JOptionPane.ERROR_MESSAGE);
        }
        
        // Check for the custom out of range excepetion
        catch(IntOutOfRangeException e)
        {
            JOptionPane.showMessageDialog(this, 
                e.toString(),
                "Warning Message",
                JOptionPane.WARNING_MESSAGE);
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, 
                e.toString(),
                "Warning Message",
                JOptionPane.WARNING_MESSAGE);
        }
        
        // Repaint the frame to allow the JLabel to show up
        finally
        {
            //clearText();
        }
    }

    /**
     * Instantiate a JFrame and place the panel on it.
     */
    public static void main(String[] args)
    {
        FieldTester app = new FieldTester();
    }
}
