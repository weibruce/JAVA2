import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Catches exceptions thrown when a user tries to enter a non-integer in a 
 * text field.
 */
public class TextFieldException extends JFrame implements ActionListener
{
    // Declare the AWT and Swing components
    Container   c = getContentPane();
    JTextField  integerTextField;

    /**
     * Constructor for objects of class TextFieldException
     */
    public TextFieldException()
    {
        // Set the layout to FlowLayout
        c.setLayout(new FlowLayout());
        //create a text field, right justified.
        integerTextField = new JTextField("14", 15); 
        integerTextField.setHorizontalAlignment(JTextField.RIGHT);
        // Add a label and the textfiield to the JFrame
        c.add( new JLabel("Enter an Integer")); 
        c.add(integerTextField); 
        
        //Register the textfield with an Action Listener
        integerTextField.addActionListener(this); 
        
        // Set the properties of the JFrame
        setTitle("Labels in Frames"); 
        setSize(400,400); setVisible(true);
    }
    
    /**
     * Declare the actionPerformed event
     * Pressing <ENTER> in the textbox will trigger this event
     */
    public void actionPerformed(ActionEvent e)
    {
        //int num1 = Integer.parseInt( integerTextField.getText() );
        // All code that is to be tested for exception MUST be in a try block
        try
        {
            // May throw an exception when converting to an integer 
            int num = Integer.parseInt( integerTextField.getText() );
        }
        // If the textfield contains non-numeric data, a NumberFormatException will be thrown. We must catch it.
        catch( NumberFormatException nf) // Display an error message
        {
            // Display an error message
            integerTextField.setText("You must enter an Integer"); 
            integerTextField.selectAll(); 
        }
    }

    /**
     * Declare the main method and instantiate the class
     */
    public static void main(String[] args)
    {
        TextFieldException app = new TextFieldException();
    }
}
