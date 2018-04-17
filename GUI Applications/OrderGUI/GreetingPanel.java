import java.awt.*;
import javax.swing.*;

/**
 * The GreetingPanel class displays a greeting in a panel.
 */
public class GreetingPanel extends JPanel
{
    private JLabel      iconLabel,
                        greeting;
    private ImageIcon   bagel;

    /**
     * Constructor for objects of class GreetingPanel
     */
    public GreetingPanel()
    {
        setLayout(new GridLayout(2, 1, 0, 0));
        // Create the image object
        bagel = new ImageIcon("images/coffee.jpg");
        iconLabel = new JLabel("");
        iconLabel.setIcon(bagel);
        iconLabel.setText(null);
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        greeting = new JLabel("Brandi's Bagel House");
        greeting.setHorizontalAlignment(SwingConstants.CENTER);
        //greeting.set
        // Add the label to this panel.
        add(greeting);
        add(iconLabel);
        
        // Add a raised bevel border around the panel
        setBorder(BorderFactory.createRaisedBevelBorder());
        // Set the background color of the panel
        setBackground(Color.GRAY);
    }
}
