import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class MyCatImage here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ImageLabelButton extends JFrame
{
    private JPanel  imagePanel,
                    buttonPanel;
    private JLabel  imageLabel;
    private JButton button;
    private Container c;

    /**
     * Constructor for objects of class MyCatImage
     */
    public ImageLabelButton()
    {
        c = getContentPane();
        // Create a BorderLayout manager.
        c.setLayout(new BorderLayout());
        // Build the panels.
        buildImagePanel();
        buildButtonPanel();
        // Add the panels to the content pane.
        c.add(imagePanel, BorderLayout.CENTER);
        c.add(buttonPanel, BorderLayout.SOUTH);
        
        // Set title bar text, JFrame’s visibility, location on screen, action for close button & pack
        setTitle("My Cat");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
    
    /**
     * The buildImagePanel method adds a label to a panel.
     */
    private void buildImagePanel()
    {
        // Create a panel & a label. Then add the label to the panel.
        imagePanel = new JPanel();
        imageLabel = new JLabel("Click the button to see an image of my cat.");
        imagePanel.add(imageLabel);
    }
    
    /**
     * The buildButtonPanel method adds a button to a panel.
     */
    private void buildButtonPanel()
    {
        //ImageIcon smileyImage = new ImageIcon("Smiley.gif");
        // Create a panel.
        buttonPanel = new JPanel();
        
        // Create a button.
        button = new JButton("Get Image");
        //button.setIcon(smileyImage);
        // Register an action listener with the button.
        button.addActionListener(new ButtonListener());
        // Add the button to the panel.
        buttonPanel.add(button);
    }
    
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // Read the image file into an ImageIcon object.
            ImageIcon catImage = new ImageIcon("images/prize_5.png");
            // Display the image in the label.
            imageLabel.setIcon(catImage);
            // Remove the text from the label.
            imageLabel.setText(null);
            // Pack the frame again to accomodate the new size of the label.
            pack();
        }
    }

    /**
     * The main method creates an instance of the MyCatImage class which 
     * causes it to display its window.
     */
    public static void main(String[] args)
    {
        ImageLabelButton app = new ImageLabelButton();
    }
}
