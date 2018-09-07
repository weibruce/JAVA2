import java.awt.*;
import javax.swing.*;

/**
 * INPUT: User enters data into this GUI
 * PROCESSING: This class is the GUI component of the SINApp Application. It 
 *      contains the SWING components required to retrieve data from the user for 
 *      insert into the SIN2000.mdb ACCESS database
 * OUTPUT: Registers the "Add New Record" button,with the JVM, to invoke the SINHandler.
 */ 
public class SINAddRecordGUI extends JPanel
{
    protected JButton       addRecordButton;
    protected JTextField    firstName,
                            lastName,
                            age,
                            sin,
                            address,
                            city,
                            province,
                            pCode,
                            gender,
                            bDay,
                            noOfDepends,
                            statusmsg;
    protected ButtonGroup   genderGroup;
    protected JRadioButton  maleButton,
                            femaleButton;

    /**
     * Constructor for objects of class SinAddRecordGUI
     */
    public SINAddRecordGUI()
    {
        //Set the JPanel's Layout as 2 column GridLayout & populate with GUI components
        setLayout(new GridLayout(0, 2));
        add(new JLabel("First Name"));
        add(firstName = new JTextField());
        add(new JLabel("Last Name"));
        add(lastName = new JTextField());
        add(new JLabel("Address"));
        add(address = new JTextField());
        add(new JLabel("City"));
        add(city = new JTextField());
        add(new JLabel("Province"));
        add(province = new JTextField());
        add(new JLabel("Postal Code"));
        add(pCode = new JTextField());
        add(new JLabel("Age"));
        add(age = new JTextField());
        add(new JLabel("Birthday (mm/dd/yyyy)"));
        add(bDay = new JTextField());
        add(new JLabel("NumberDependents"));
        add(noOfDepends = new JTextField());
        add(new JLabel("SIN"));
        add(sin = new JTextField());
        add(new JLabel("Gender(M/F)"));
        add(maleButton = new JRadioButton("Male"));
        add(new JLabel(""));
        add(femaleButton = new JRadioButton("Female"));
        add(new JLabel(""));
        add(new JLabel(""));
        add(statusmsg = new JTextField());
        add(addRecordButton = new JButton("Add new Record"));
        
        statusmsg.setEditable(false);
        genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        
        addRecordButton.addActionListener(new SINHandler(this));
    }
}
