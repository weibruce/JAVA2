import java.awt.*;
import javax.swing.*;

/**
 * Use a GridLayout manager for the JPanel
 * Create the array of checkboxes
 * Create the appropriate border for the panel
 * Add the checkboxes to the panel.
 */
public class NonRoutineServices extends JPanel
{
    final double            LABOR_RATE = 85.00;
    private JLabel          chargeLabel,
                            hourLabel;
    private JTextField      chargeTextField,
                            hourTextField;

    /**
     * Constructor for objects of class NonRoutineServices
     */
    public NonRoutineServices()
    {
        setLayout(new GridLayout(2, 2));
        setBorder(BorderFactory.createTitledBorder("Nonroutine Services"));
        
        chargeLabel = new JLabel("Parts Charges:");
        hourLabel = new JLabel("Hours of Labor:");
        
        chargeTextField = new JTextField("0", 10);
        chargeTextField.setHorizontalAlignment(JTextField.RIGHT);
        hourTextField = new JTextField("0", 10);
        hourTextField.setHorizontalAlignment(JTextField.RIGHT);
        
        add(chargeLabel);
        add(chargeTextField);
        add(hourLabel);
        add(hourTextField);
    }

    /**
     * This method is responsible for calculating the non-routine charges 
     * (parts + (labor hours x labor rate). The method has no arguments and 
     * returns the total calculated charges.
     */
    public double getCharges()
    {
        double  totalCharges = 0.0;
        String  parts = chargeTextField.getText();
        String  hours = hourTextField.getText();
        
        //totalCharges = parts + (labor hours x labor rate)
        totalCharges = Double.parseDouble(parts) + Double.parseDouble(hours) * LABOR_RATE;
        //System.out.println("NonRoutine Services Charges: "+totalCharges);
        return totalCharges;
    }
}
