import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

/**
 * The MetricConverterWindow class lets the user enter a distance in 
 * kilometers. Radio buttons can be selected to convert the kilometers to 
 * miles, feet, or inches.
 */
public class JRadioButtonMetricConverter extends JFrame
{
    private final int   WINDOW_WIDTH = 420,
                        WINDOW_HEIGHT = 150;
    private JPanel      panel;
    private JLabel      messageLabel;
    private JTextField  kiloTextField;
    private JButton     submitButton;
    private JRadioButton    milesButton,
                            feetButton,
                            inchesButton;
    private ButtonGroup    radioButtonGroup;
    private RadioButtonListener rbl;
    private Container   c;

    /**
     * Constructor for objects of class MetricConverterWindow
     */
    public JRadioButtonMetricConverter()
    {
        c = getContentPane();
        // Build the panel and add it to the frame.
        buildPanel();
        // Add the panel to the frame's content pane.
        c.add(panel);
        
        // Set JFrame parms:
        // Set title bar text. JFrame visibility, location, its window size, & action for the close button
        setTitle("Metric Converter ");
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * The buildPanel method adds a label, text field, and three buttons to a panel.
     */
    private void buildPanel()
    {
        // Create the label, text field, and radio buttons.
        messageLabel = new JLabel("Enter a distance in kilometers");
        kiloTextField = new JTextField(10);
        
        milesButton = new JRadioButton("Convert to miles", true); // Selected
        feetButton = new JRadioButton("Convert to feet");
        inchesButton = new JRadioButton("Convert to inches");
        
        // Group the radio buttons.
        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(milesButton);
        radioButtonGroup.add(feetButton);
        radioButtonGroup.add(inchesButton);
        
        //Create RadioButton action event listener object, and add it to the radio buttons 
        rbl = new RadioButtonListener();
        milesButton.addActionListener(rbl);
        feetButton.addActionListener(rbl);
        inchesButton.addActionListener(rbl);
        
        // Create a panel and add the components to it.
        panel = new JPanel();
        panel.add(messageLabel);
        panel.add(kiloTextField);
        panel.add(milesButton);
        panel.add(feetButton);
        panel.add(inchesButton);
    }
    
    /**
     * Private inner class that handles the event when the user clicks one of 
     * the radio buttons.
     */
    private class RadioButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            final double    KM_TO_MILE= 0.6214,
                            KM_TO_FEET= 3281.0,
                            KM_TO_INCH= 39370.0;
            String          input,          // To hold the user's input
                            convertTo = ""; // The units we're converting to 
            double          result = 0.0;   // To hold the conversion
            
            DecimalFormat df = new DecimalFormat("#,##0.00");
            
            // Get the kilometers entered.
            input = kiloTextField.getText();
            
            // Determine which radio button was clicked.
            if (e.getSource() == milesButton) // Convert to miles.
            {
                convertTo = " miles."; result = Double.parseDouble(input) * KM_TO_MILE;
            }
            else if (e.getSource() == feetButton) // Convert to feet.
            {
                convertTo = " feet."; result = Double.parseDouble(input) * KM_TO_FEET;
            }
            else if (e.getSource() == inchesButton) // Convert to inches.
            {
                convertTo = " inches."; result = Double.parseDouble(input) * KM_TO_INCH;
            }
            
            // Display the conversion.
            JOptionPane.showMessageDialog(null, input + " kilometers is " + df.format(result) + convertTo);
        }
    }
    
    /**
     * The main method creates an instance of the MetricConverterWindow class, 
     * displaying its window.
     */
    public static void main(String[] args)
    {
        JRadioButtonMetricConverter app = new JRadioButtonMetricConverter();
    }
}
