import java.awt.*;
import javax.swing.*;

/**
 * The ToppingPanel class allows the user to select the toppings for the bagel.
 */
public class ToppingPanel extends JPanel
{
    // These parallel arrays represent the topping types and their corresponding costs
    private final String[] TOPPING_TYPE = {"Cream Cheese","Butter","Peach Jelly","Blueberry jam"};
    private final double[] TOPPING_COSTS={ 0.50, 0.25, 0.75, 0.75};
    // This stores an array of JCheckBox objects
    private JCheckBox[] toppingOptions = new JCheckBox[TOPPING_TYPE.length];

    /**
     * Constructor for objects of class ToppingPanel
     */
    public ToppingPanel()
    {
        // Create a GridLayout manager with four rows and one column.
        setLayout(new GridLayout(4, 1));
        // Create the check boxes and add them into the array toppingOptions // Add the check boxes to the panel
        for (int i = 0; i < toppingOptions.length; i++)
        {
            toppingOptions[i] = new JCheckBox(TOPPING_TYPE[i]);
            add(toppingOptions[i]);
        }
        // Add a border around the panel.
        setBorder(BorderFactory.createTitledBorder("Toppings"));
    }
    
    /**
     * getToppingCost method
     * @return The cost of the selected toppings.
     */
    public double getToppingCost()
    {
        double toppingCost = 0.0;
        for (int i = 0; i < toppingOptions.length; i++)
        {
            if (toppingOptions[i].isSelected())
            {
                toppingCost += TOPPING_COSTS[i];
            }
        }
        return toppingCost;
    }
}
