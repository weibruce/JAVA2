import java.awt.*;
import javax.swing.*;

/**
 * PROCESSING:
 * Creates a JList that contains a list of drinks 
 * Sets the number of items that will show 
 * Allows the user to select more than one option from the list
 * 
 * INPUT: none
 * OUTPUT: Displays a JList
 */
public class JListExample extends JFrame
{
    //declares a scroll pane used to house the list
    private JScrollPane     listPane; 
    private JList           drinkList;
    private Container       c;

    /**
     * Constructor for objects of class ListExample
     * 
     * setSelectionMode(modes);
     * 0: SINGLE_SELECTION
     * 1: INTERVAL_SELECTION - can only use shift key to select a range
     * 2: MULTIPLE_INTERVAL_SELECTION - Ctrl and Shift
     */
    public JListExample()
    {
        final String[] SOFT_DRINKS = {"Coke", "Pepsi", "Ginger Ale", "Orange", "RootBeer", "7 UP", "Dr. Pepper"};
        
        c = getContentPane();
        
        //creates the list
        drinkList = new JList(SOFT_DRINKS);
        //allows 4 items in the list to be shown at once
        drinkList.setVisibleRowCount(4);
        //allows the user to select more than one item
        drinkList.setSelectionMode(2);
        //adds the list to a scroll pane
        listPane = new JScrollPane(drinkList);
        //add the scroll pane to the container
        c.add(listPane, BorderLayout.NORTH);
        
        // Set JFrame parms and pack
        setTitle("List Example"); 
        setSize(200, 150);
        setVisible(true); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack();
    }

    /**
     * Creates a standard list of soft drinks to choose from.
     */
    public static void main(String[] args)
    {
        JListExample app = new JListExample();
    }
}
