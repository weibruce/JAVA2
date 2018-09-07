import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class demonstrates a combo box.
 */
public class JComboBoxWindow extends JFrame
{
    private JPanel      coffeePanel,
                        selectedCoffeePanel;
    private JComboBox   coffeeBox;
    private JLabel      label;
    private JTextField  selectedCoffee;
    
    // The following array holds the values that will be displayed in the coffeeBox combo box.
    private String[]    coffee = {"Choose a Specialty Coffee", 
                                    "Guatemalan Antigua", 
                                    "Columbian Supremo", 
                                    "Indian Monsoon Malabar", 
                                    "Ethiopian Yirgacheffe", 
                                    "Sumatra Mandehling", 
                                    "Tanzanian Peaberry"};
    private Container   c;
    
    /**
     * Constructor for objects of class ComboBoxWindow
     */
    public JComboBoxWindow()
    {
        c = getContentPane();
        // Create a BorderLayout manager.
        c.setLayout(new BorderLayout());
        
        // Build the panels.
        buildCoffeePanel();
        buildSelectedCoffeePanel();
        
        // Add the panels to the content pane.
        c.add(coffeePanel,          BorderLayout.CENTER); 
        c.add(selectedCoffeePanel,  BorderLayout.SOUTH);
        
        // Set JFrame parms and pack
        setTitle("Combo Box Demo"); 
        setVisible(true); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
    
    /**
     * The buildCoffeePanel method adds a combo box with the types of coffee 
     * to a panel.
     */
    private void buildCoffeePanel()
    {
        // Create a panel to hold the list.
        coffeePanel = new JPanel(); 
        // Create the combo box
        coffeeBox = new JComboBox(coffee); 
        // Register an item listener.
        coffeeBox.addItemListener(new ComboBoxListener());
        // Add the combo box to the panel.
        coffeePanel.add(coffeeBox);
    }
    
    private class ComboBoxListener implements ItemListener
    {
        public void itemStateChanged(ItemEvent e)
        {
            // Get the selected coffee, and index location.
            String selection = coffeeBox.getSelectedItem().toString(); 
            int index = coffeeBox.getSelectedIndex();
            // Display the selected coffee in the text field.
            selectedCoffee.setText(index + ": " + selection);
        }
    }
    
    /**
     * The buildSelectedCoffeePanel method adds a read-only text field to a 
     * panel.
     */
    private void buildSelectedCoffeePanel()
    {
        // Create a panel to hold the list. 
        selectedCoffeePanel = new JPanel();
        // Create the label.
        label = new JLabel("You selected: "); 
        // Create the uneditable text field.
        selectedCoffee = new JTextField(20);
        // Add the label and text field to the panel.
        selectedCoffeePanel.add(label); 
        selectedCoffeePanel.add(selectedCoffee);
    }
    
    /**
     * The main method creates an instance of the ComboBoxWindow class which 
     * causes it to display its window.
     */
    public static void main(String[] args)
    {
        JComboBoxWindow app = new JComboBoxWindow();
    }
}
