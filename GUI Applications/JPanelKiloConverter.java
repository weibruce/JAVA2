import java.awt.*;
import javax.swing.*;

/**
 * The KiloConverterWindow class displays a JFrame that lets the user enter a 
 * distance in kilometers. When the Calculate button is clicked, a dialog box 
 * is displayed with the distance converted to miles.
 */
public class JPanelKiloConverter extends JFrame
{
    private final int   WINDOW_WIDTH = 310,
                        WINDOW_HEIGHT = 100;
    private JPanel      panel;
    private JLabel      messageLabel;
    private JTextField  kiloTextField;
    private JButton     calcButton;
    private Container   c;

    /**
     * Constructor for objects of class KiloConverterWindow
     */
    public JPanelKiloConverter()
    {
        c = getContentPane();
        // Set the window title by calling the JFrame one-arg constructor.
        setTitle("Kilometer Converter");
        // Set the size of the window.
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        // Center the window on the screen 
        setLocationRelativeTo(null);
        // Specify what happens when the close button is clicked.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Build the panel and add it to the frame.
        buildPanel();
        // Add the panel to the frame's content pane.
        c.add(panel);
        // Display the window.
        setVisible(true);
    }
    
    /**
     * The buildPanel method adds a label, text field, and and a button to a panel.
     */
    private void buildPanel()
    {
        // Create a label to display instructions.
        messageLabel = new JLabel("Enter a distance in kilometers");
        // Create a text field 10 characters wide.
        kiloTextField = new JTextField(10);
        // Create a button with the caption "Calculate".
        calcButton = new JButton("Calculate");
        // Create a JPanel object and let the panel field reference it.
        panel = new JPanel();
        // Add the label, text field, and button components to the panel.
        panel.add(messageLabel);
        panel.add(kiloTextField);
        panel.add(calcButton);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main (String[] arg)
    {
        JPanelKiloConverter app = new JPanelKiloConverter();
    }
}
