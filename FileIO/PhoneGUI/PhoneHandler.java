import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 * Declare reference link back to the GUI application
 */
public class PhoneHandler implements ActionListener
{
    // Declare reference link back to the GUI application
    private PhoneGUI            gui;
    // Declare the Input and Output object streams
    private ObjectOutputStream  outputStream;
    private ObjectInputStream   inputStream;
    // Declare the File class to connect to
    private File                phoneFile;

    /**
     * Constructor for objects of class PhoneHandler
     */
    public PhoneHandler(PhoneGUI gui)
    {
        // Link back to the GUI Application
        this.gui = gui;
        // Declare the File object to connect to
        phoneFile = new File("phone.txt");
    }

    /**
     * Declare the actionPerformed event for the event listener
     */
    public void actionPerformed(ActionEvent e)
    {
        // When the Write Radio Button is clicked
        if(e.getSource() == gui.writeRadioButton)
        {
            // Set the text of the JButton
            gui.doTask.setText("Write New Object");
            // to update the window with the text change
            gui.repaint();
            // to setup the ObjectOutputStream object
            initWriter();
        }
        else if(e.getSource() == gui.readRadioButton)
        {
            // Set the text of the JButton
            gui.doTask.setText("Read Next Object");
            // to update the window with the text change
            gui.repaint();
            // to setup the ObjectInputStream Object
            initReader();
        }
        else if(e.getSource() == gui.doTask)
        {
            // Determine if we are in "READ" or "WRITE" mode
            if(gui.writeRadioButton.isSelected())
            {
                // Call the Write Object method
                writeNewObject();
            }
            else if (gui.readRadioButton.isSelected())
            {
                // Call the Read Object method
                readNewObject();
            }
        }
    }
    
    /**
     * This method is called to close any existing Read streams and 
     * initialize the Write Stream
     */
    public void initWriter()
    {
        try
        {
            // Reset the fields on the GUI panel
            gui.clearFields();
            // If the InputStream is a valid object, close it so that it releases any lock it may have on the file
            if(inputStream != null)
            {
                inputStream.close();
            }
            // Create the OutputStream so that it is ready for writing
            outputStream = new ObjectOutputStream(new FileOutputStream(phoneFile));
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(gui,
                                "Error opening file",
                                "ERROR",
                                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * This method is called to close any existing Write streams and 
     * initialize the Read Stream
     */
    public void initReader()
    {
        try
        {
            // Reset the fields on the GUI panel
            gui.clearFields();
            //If the OutputStream is a valid object, close it so that it releases any lock it may have on the file
            if(outputStream != null)
            {
                outputStream.close();
            }
            inputStream = new ObjectInputStream(new FileInputStream(phoneFile));
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(gui,
                                "Error opening file",
                                "ERROR",
                                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * This method will write one object to the file
     */
    public void writeNewObject()
    {
        // Declare a reference to hold a PhoneNumber Object
        PhoneNumber phoneObject;
        // Retrieve the PhoneNumber Object from the GUI. The GUI will instantiate a PhoneNumber object, based upon the values in its components
        phoneObject = gui.getVals();
        
        try
        {
            // Write the Object to the file
            outputStream.writeObject(phoneObject);
            // Flush the Field to ensure it goes to the file and doesn't reside in a buffer
            outputStream.flush();
            // Clear the Fields on the GUI
            gui.clearFields();
            // Display a message to confirm that the Object was written
            gui.firstNameField.setText("Object added to file");
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(gui,
                                "Error opening file",
                                "ERROR",
                                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * This method will read one object from the file
     */
    public void readNewObject()
    {
        // Declare a reference to hold a PhoneNumber Object
        PhoneNumber phoneObject;
        
        try
        {
            // The readObject method returns an object of the default Object type. We must CAST it back into a PhoneNumber object
            phoneObject = (PhoneNumber) inputStream.readObject();
            
            // Based on the values stored in the PhoneNumber object, retrieve the data attributes, and display them on the GUI
            gui.firstNameField.setText(phoneObject.getFirstName());
            gui.lastNameField.setText(phoneObject.getLastName());
            gui.phoneNumberField.setText(phoneObject.getPhoneNumber());
        }
        catch(ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(gui,
                                "Error in file",
                                "ERROR",
                                JOptionPane.ERROR_MESSAGE);
        }
        catch(EOFException e)
        {
            gui.clearFields();
            gui.firstNameField.setText("It's the last object");
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(gui,
                                "ERROR opening file",
                                "ERROR",
                                JOptionPane.ERROR_MESSAGE);
                                
        }
    }
}
