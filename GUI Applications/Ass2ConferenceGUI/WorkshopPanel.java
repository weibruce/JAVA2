import java.awt.*;
import javax.swing.*;

/**
 * WorkshopPanel that inherits from a JPanel
 */
public class WorkshopPanel extends JPanel
{
    final private double[]  workshopFees = {295, 295, 395, 395};
    final private String[]  workshopType = {"IT Trends in Manitoba",
                                            "Creating a Dream Career",
                                            "Advanced Java Programming",
                                            "Ethics: The Challenge Continues"};
    protected JList         workshopList;
    protected JScrollPane   listPane;
    /**
     * Constructor for objects of class WorkshopPanel
     */
    public WorkshopPanel()
    {
        setLayout(new FlowLayout());
        setBorder(BorderFactory.createTitledBorder("Workshops"));
        
        workshopList = new JList(workshopType);
        workshopList.setVisibleRowCount(4);
        workshopList.setSelectionMode(2);
        listPane = new JScrollPane(workshopList);
        add(listPane);
    }
    
    /**
     * This method is responsible for calculating the costs of one or more 
     * workshops that have been selected from the list. Retrieve the selected 
     * workshops into an object array and use a loop to total the charges. 
     * The method has no arguments and returns the total calculated workshop 
     * cost.
     */
    public double getWorkshopCost()
    {
        double workshopCost = 0;
        int[] selectedIndexes = workshopList.getSelectedIndices();
        for(int i = 0; i < selectedIndexes.length; i++)
        {
            workshopCost += workshopFees[selectedIndexes[i]];
        }
        return workshopCost;
    }

    /**
     * This method has no arguments and returns an object array containing 
     * the names of the selected workshops.
     */
    public String[] getWorkshopList()
    {
        int[] selectedIndexes = workshopList.getSelectedIndices();
        String[] workshopList = new String[selectedIndexes.length];
        for(int i = 0; i < selectedIndexes.length; i++)
        {
           workshopList[i] = workshopType[selectedIndexes[i]];
        }
        return workshopList;
    }
}
