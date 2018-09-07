import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Stereotype: Control class (handles business logic)
 * INPUT: None
 * PROCESSING: class SINHandler
 *      This “control” class is the Event handler component of the SINApp 
 *      Application. It contains the code that will execute when the command 
 *      button is clicked. It will instantiate a SinRecord class based on the 
 *      data retrieved from the SWING components on the SinAddRecordGUI class 
 *      and pass the SinRecord object to the SINDatabase class for insert into 
 *      the SIN2000.mdb ACCESS database.
 * OUTPUT: None
 */
public class SINHandler implements ActionListener
{
    // Declare a reference to the GUI class
    private SINAddRecordGUI gui;
    // Declare a reference to a SINRecord object
    private SINRecord       sinRec;

    /**
     * The constructor will:
     * 1. Acccept a SinAddRecordGUI object so it can link to the GUI class
     * 2. Initialize the database class
     */
    public SINHandler(SINAddRecordGUI gui)
    {
        this.gui = gui;
    }

    /**
     * This method will be called when the JButton is clicked on the GUI class
     */
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == gui.addRecordButton)
        {
            int result = 0;
            // Determine which Gender radio button is selected
            String gender = gui.maleButton.isSelected() ? "M" : "F";
            
            // Create a new SINRecord based on the data contained in the GUI class. 
            // No error handling is done here, so it is assumed that all data is correct.
            sinRec = new SINRecord(Long.parseLong(gui.sin.getText()),
                            gui.firstName.getText(), gui.lastName.getText(),
                            gui.address.getText(), gui.city.getText(), 
                            gui.province.getText(), gui.pCode.getText(), 
                            Integer.parseInt(gui.age.getText()), gender,
                            gui.bDay.getText(), Integer.parseInt(gui.noOfDepends.getText()));
                            
            //Perform update query to add new SIN record
            SINDatabase.initialize();
            result = SINDatabase.addRecord(sinRec);
            
            //checks to see if the record was added.
            gui.statusmsg.setText(result == 1 ? "Record Added" : "Record not Added");
        }
    }
}
