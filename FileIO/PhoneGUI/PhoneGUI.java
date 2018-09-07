import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Declare all SWING components for the JPanel
 */
public class PhoneGUI extends JPanel
{
    // Separate the Panel into 2 sub panels
    protected JPanel        inCenterPanel,
                            inSouthPanel;
    protected JLabel        firstNameLabel,
                            lastNameLabel,
                            phoneNumberLabel;
    protected JTextField    firstNameField,
                            lastNameField,
                            phoneNumberField;
    protected JButton       doTask;
    protected ButtonGroup   readwriteGroup;
    protected JRadioButton  readRadioButton,
                            writeRadioButton;
    
    // Declare the event handling class
    protected PhoneHandler  eventHandler;

    /**
     * Constructor for objects of class PhoneGUI
     */
    public PhoneGUI()
    {
        this(5);
    }
    public PhoneGUI(int size)
    {
        //Sets up the GUI
        firstNameLabel = new JLabel("First Name");
        lastNameLabel = new JLabel("Last Name");
        phoneNumberLabel = new JLabel("Phone Number");
        firstNameField = new JTextField(15);
        lastNameField = new JTextField(15);
        phoneNumberField = new JTextField(15);
        
        readwriteGroup = new ButtonGroup();
        readRadioButton = new JRadioButton("Read Object");
        writeRadioButton = new JRadioButton("Write Object");
        readwriteGroup.add(readRadioButton);
        readwriteGroup.add(writeRadioButton);
        
        doTask = new JButton("Write Object");
        
        inCenterPanel = new JPanel();
        inCenterPanel.setLayout(new GridLayout(size, 2));
        inCenterPanel.add(firstNameLabel);
        inCenterPanel.add(firstNameField);
        inCenterPanel.add(lastNameLabel);
        inCenterPanel.add(lastNameField);
        inCenterPanel.add(phoneNumberLabel);
        inCenterPanel.add(phoneNumberField);
        inCenterPanel.add(readRadioButton);
        inCenterPanel.add(writeRadioButton);
        
        inSouthPanel = new JPanel();
        inSouthPanel.add(doTask);
        
        // Register the event handlers
        eventHandler = new PhoneHandler(this);
        readRadioButton.addActionListener(eventHandler);
        writeRadioButton.addActionListener(eventHandler);
        doTask.addActionListener(eventHandler);
        
        // Trigger Clicked the write radio button by default
        readRadioButton.doClick();
        
        setLayout(new BorderLayout());
        add(inCenterPanel,  BorderLayout.CENTER);
        add(inSouthPanel,   BorderLayout.SOUTH);
        // Validates this container and all of its subcomponents.
        validate();
    }
    
    /**
     * Provide a method which will clear all fields on the form
     */
    public void clearFields()
    {
        firstNameField.setText("");
        lastNameField.setText("");
        phoneNumberField.setText("");
        
    }
    
    /**
     * Create a method which will return a PhoneNumber Object, based upon the 
     * current values in the fields of the GUI
     */
    public PhoneNumber getVals()
    {
        String fname = firstNameField.getText();
        String lname = lastNameField.getText();
        String pnumber = phoneNumberField.getText();
        return  new PhoneNumber(fname, lname, pnumber);
    }
}
