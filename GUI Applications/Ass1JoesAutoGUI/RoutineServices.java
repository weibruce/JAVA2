import java.awt.*;
import javax.swing.*;
import java.text.DecimalFormat;

/**
 * Use a GridLayout manager for the JPanel
 * Create the array of checkboxes
 * Create the appropriate border for the panel
 * Add the checkboxes to the panel
 */
public class RoutineServices extends JPanel
{
    // These parallel arrays represent the routine types and their corresponding costs
    protected final String[]    ROUTINE_TYPE = {
                                    "Oil Change",
                                    "Lube Job",
                                    "Radiator Flush",
                                    "Transmission Flush",
                                    "Inspection",
                                    "Muffler Replacement",
                                    "Tire Rotation"};
    protected final double[]    ROUTINE_COSTS={ 
                                    26.0, 
                                    18.0, 
                                    30.0, 
                                    30.0, 
                                    15.0, 
                                    100.0, 
                                    20.0};
    // This stores an array of JCheckBox objects
    protected JCheckBox[]     routineOptions = new JCheckBox[ROUTINE_TYPE.length];

    /**
     * Constructor for objects of class RoutineServices
     */
    public RoutineServices()
    {
        DecimalFormat   df = new DecimalFormat("$#,##0.00");
        
        setLayout(new GridLayout(7, 1));
        setBorder(BorderFactory.createTitledBorder("Routine Services"));
        
        routineOptions = new JCheckBox[ROUTINE_TYPE.length];
        
        for (int i = 0; i < routineOptions.length; i++)
        {
            routineOptions[i] = new JCheckBox(ROUTINE_TYPE[i] + " (" + df.format(ROUTINE_COSTS[i]) + ")");
            add(routineOptions[i]);
        }
    }

    /**
     * This method is responsible for using the appropriate looping structure 
     * to accumulate all charges based on which checkboxes are selected. The 
     * method has no arguments and returns the total charges.
     */
    public double getCharges()
    {
        double totleCharges = 0.0;
        for (int i = 0; i < routineOptions.length; i++)
        {
            if(routineOptions[i].isSelected())
            {
                totleCharges += ROUTINE_COSTS[i];
            }
        }
        //System.out.println("Routine Services Charges: " + totleCharges);
        return totleCharges;
    }
}
