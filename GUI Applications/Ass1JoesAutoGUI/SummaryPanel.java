import java.awt.*;
import javax.swing.*;

/**
 * Create a decimal format object used to display the summary totals in the 
 * appropriate format
 * Use a GridLayout manager for the JPanel
 * Create the labels and textfields. Right-justify the contents of both.
 * Textfield contents are for display only
 * Initialize the textfields to “0”
 * Add the labels and textfields to the panel
 */
public class SummaryPanel extends JPanel
{
    private JLabel      customersLabel,
                        routineChargesLabel,
                        nonroutineChargesLabel,
                        taxesLabel,
                        chargesLabel;
    private JTextField  customersTextField,
                        routineChargesTextField,
                        nonroutineChargesTextField,
                        taxesTextField,
                        chargesTextField;

    /**
     * Constructor for objects of class SummaryPanel
     */
    public SummaryPanel()
    {
        setLayout(new GridLayout(5,2));
        
        customersLabel = new JLabel("Total Customers: ", JLabel.RIGHT);
        routineChargesLabel = new JLabel("Total Routine Charges: ", JLabel.RIGHT);
        nonroutineChargesLabel = new JLabel("Total Non-routine Charges: ", JLabel.RIGHT);
        taxesLabel = new JLabel("Total Taxes: ", JLabel.RIGHT);
        chargesLabel = new JLabel("Total Charges: ", JLabel.RIGHT);
        
        customersTextField = new JTextField("0");
        customersTextField.setHorizontalAlignment(JTextField.RIGHT);
        routineChargesTextField = new JTextField("0.00");
        routineChargesTextField.setHorizontalAlignment(JTextField.RIGHT);
        nonroutineChargesTextField = new JTextField("0.00");
        nonroutineChargesTextField.setHorizontalAlignment(JTextField.RIGHT);
        taxesTextField = new JTextField("0.00");
        taxesTextField.setHorizontalAlignment(JTextField.RIGHT);
        chargesTextField = new JTextField("0.00");
        chargesTextField.setHorizontalAlignment(JTextField.RIGHT);
        
        add(customersLabel);
        add(customersTextField);
        add(routineChargesLabel);
        add(routineChargesTextField);
        add(nonroutineChargesLabel);
        add(nonroutineChargesTextField);
        add(taxesLabel);
        add(taxesTextField);
        add(chargesLabel);
        add(chargesTextField);
    }

    /**
     * get/set methods for each of the private
     */
    public String getTotalCustomers()
    {
        return customersTextField.getText();
    }
    public void setTotalCustomers(String totalCustomers)
    {
        customersTextField.setText(totalCustomers);
    }
    
    public String getTotalRoutineCharges()
    {
        return routineChargesTextField.getText();
    }
    public void setTotalRoutineCharges(String totalRoutineCharges)
    {
        routineChargesTextField.setText(totalRoutineCharges);
    }
    
    public String getTotalNonroutineCharges()
    {
        return nonroutineChargesTextField.getText();
    }
    public void setTotalNonroutineCharges(String totalNonroutineCharges)
    {
        nonroutineChargesTextField.setText(totalNonroutineCharges);
    }
    
    public String getTotalTaxes()
    {
        return taxesTextField.getText();
    }
    public void setTotalTaxes(String totalTaxes)
    {
        taxesTextField.setText(totalTaxes);
    }
    
    public String getTotalCharges()
    {
        return chargesTextField.getText();
    }
    public void setTotalCharges(String totalCharges)
    {
        chargesTextField.setText(totalCharges);
    }
}
