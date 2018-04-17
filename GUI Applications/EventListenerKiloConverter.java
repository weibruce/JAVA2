import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
 * The KiloConverterEvent class displays a JFrame that lets the user enter a 
 * distance in kilometers. When the Calculate button is clicked, a dialog box 
 * is displayed with the distance converted to miles.
 */
public class EventListenerKiloConverter extends JFrame
{
    private final int   WINDOW_WIDTH = 310,
                        WINDOW_HEIGHT = 100;
    private JPanel      panel;
    private JLabel      messageLabel;
    private JTextField  kiloTextField;
    private JButton     calcButton;
    private Container   c;

    /**
     * Constructor for objects of class KiloConverterEvent
     */
    public EventListenerKiloConverter()
    {
        c = getContentPane();
        
        // Build the panel and add it to the frame.
        buildPanel();
        // Add the panel to the frame's content pane.
        c.add(panel);
        
        // Set JFrame parms:
        // Set the title bar text, JFrame's visibility, its size
        setTitle("Kilometer Converter");
        setVisible(true);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        // Set action to perform when close is clicked
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * The buildPanel method adds a label, text field, and a button to a panel.
     */
    private void buildPanel()
    {
        // Create a label to display instructions.
        messageLabel = new JLabel("Enter a distance in kilometers");
        // Create a text field 10 characters wide.
        kiloTextField = new JTextField(10);
        // Create a button with the caption "Calculate".
        calcButton = new JButton("Calculate");
        // Add an action listener to the button. i.e. Register the button for event handling
        calcButton.addActionListener(new CalcButtonHandler());
        // Create a JPanel object and let the panel field reference it.
        panel = new JPanel();
        // Add the label, text field, and button components to the panel.
        panel.add(messageLabel);
        panel.add(kiloTextField);
        panel.add(calcButton);
    }
    
    /**
     * The actionPerformed method executes when the user clicks on the Calculate button.
     * @param e The event object.
    */
    private class CalcButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            final double    KM_TO_MILES = 0.6214;
            String          input;
            double          miles;
            DecimalFormat   df = new DecimalFormat("#,##0.00");
            
            // Get the text entered by the user into the text field.
            input = kiloTextField.getText();
            // For debugging, display the text entered, and its value converted to a double.
            System.out.println("Reading " + input + " from the text field.\n" + "Converted value: " + Double.parseDouble(input));
            // Convert the input to miles.
            miles = Double.parseDouble(input) * KM_TO_MILES;
            // Display the result.
            JOptionPane.showMessageDialog(null, input + " kilometers is " + df.format(miles) + " miles.");
            // For debugging, display a message indicating the application is ready for more input.
            System.out.println("Ready for the next input.");
        }
    }
    
    public static void main(String[] arg)
    {
        EventListenerKiloConverter app = new EventListenerKiloConverter();
    }
}
