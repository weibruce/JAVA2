import java.awt.*;
import javax.swing.*;

/**
 * RegPanel includes two panels. The first panel includes the registrant’s 
 * name textfield and registration type combobox with a titled border. The 
 * second panel contains the dinner and keynote speech checkbox.
 */
public class RegPanel extends JPanel
{
    final private String[]  typeOptions = {"Please select a type",
                                            "Business",
                                            "Student",
                                            "Complimentary"};
    final private double[]  typeFees = {0, 895, 495, 0};
    final private double    speechFee = 30;
    protected JPanel        typePanel,
                            speechPanel;
    protected JTextField    nameField;
    protected JComboBox     typeCombo;
    protected JCheckBox     speechCheck;
    protected int           customers = 0;
    
    /**
     * Constructor for objects of class RegPanel
     */
    public RegPanel()
    {
        setLayout(new GridLayout(2,1));
        
        //set name panel
        typePanel = new JPanel();
        typePanel.setLayout(new FlowLayout());
        typePanel.setBorder(BorderFactory.createTitledBorder("Registrant’s Name & Type"));
        nameField = new JTextField(20);
        typeCombo = new JComboBox(typeOptions);
        typePanel.add(nameField);
        typePanel.add(typeCombo);
        
        //set dinnerPanel
        speechPanel = new JPanel();
        speechCheck = new JCheckBox("Dinner and Keynote Speech");
        speechPanel.add(speechCheck);
        
        add(typePanel);
        add(speechPanel);
    }
    
    /**
     * This method is responsible for assigning the fee for the registration 
     * type. Use a switch statement to do this. The method has no arguments 
     * and returns the registration fee.
     */
    public double getRegistrationCost()
    {
        double regFee = typeFees[typeCombo.getSelectedIndex()];
        return regFee;
    }
    
    /**
     * This method has no arguments and returns the cost of the keynote dinner 
     * and speech.
     */
    public double getKeyNoteCost()
    {
        double keyNoteCost = 0;
        if (speechCheck.isSelected())
        {
            keyNoteCost = speechFee;
        }
        
        return keyNoteCost;
    }

    /**
     * This method has no arguments and returns the String registration type 
     * from the combo box.
     */
    public String getRegType()
    {
        String regType = typeCombo.getSelectedItem().toString();
        return regType;
    }
}
