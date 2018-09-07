import java.awt.*;
import javax.swing.*;

/**
 * The CoffeePanel class allows the user to select coffee.
 */
public class CoffeePanel extends JPanel
{
    // These parallel arrays represent the coffee options and their corresponding costs.
    private final String[] COFFEE_TYPE = {"no coffee","regular coffee","decaf coffee","cappuccino"};
    private final double[]COFFEE_COSTS={ 0.0, 1.25, 1.25, 2.00};
    
    // The following array will store the JRadioButton options, one for each coffee price in the array COFFEE_COSTS
    private JRadioButton[] coffeeOptions;
    private ButtonGroup bg;

    /**
     * Constructor for objects of class CoffeePanel
     */
    public CoffeePanel()
    {
        // Create a GridLayout manager with four rows and one column.
        setLayout(new GridLayout(4, 1));
        
        // Create the radio buttons and add them into the array coffeeOptions // Pre-select the second radio button in the array
        // Add the radio buttons to the group
        // Add the radio buttons to the panel
        coffeeOptions = new JRadioButton[COFFEE_COSTS.length];
        bg = new ButtonGroup();
        
        for (int i = 0; i < coffeeOptions.length; i++)
        {
            coffeeOptions[i] = new JRadioButton(COFFEE_TYPE[i]);
            if (i == 1)
            {
                coffeeOptions[i].setSelected(true);
            }
            bg.add(coffeeOptions[i]);
            add(coffeeOptions[i]);
        }
        
        // Add a border around the panel.
        setBorder(BorderFactory.createTitledBorder("Coffee"));
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public double getCoffeeCost()
    {
        double coffeeCost = 0.0;
        for (int i = 0; i < coffeeOptions.length; i++)
        {
            if (coffeeOptions[i].isSelected())
            {
                coffeeCost = COFFEE_COSTS[i];
            }
        }
        return coffeeCost;
    }
}
