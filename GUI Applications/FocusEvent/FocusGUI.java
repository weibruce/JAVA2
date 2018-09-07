import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Class that creates the GUI
 */
public class FocusGUI extends JPanel
{
    protected JTextField    name,
                            salary,
                            mmHired,
                            status;
    protected JPanel        center;

    /**
     * Constructor for objects of class FocusDemo
     */
    public FocusGUI()
    {
        setLayout(new BorderLayout());
        center = new JPanel(new GridLayout(3,2)); 
        
        name = new JTextField(30);
        salary = new JTextField();
        mmHired = new JTextField();
        center.add(new JLabel("Enter Name: ", JLabel.RIGHT)); 
        center.add(name);
        center.add(new JLabel("Enter yearly salary: ", JLabel.RIGHT)); 
        center.add(salary);
        center.add(new JLabel("Enter 2-digit month hired: ", JLabel.RIGHT)); 
        center.add(mmHired);
        
        add(center,     BorderLayout.CENTER);
        status = new JTextField(); 
        status.setEditable(false); 
        add(status,     BorderLayout.SOUTH);
        
        //Calls a separate class to handle textfield events.
        // create a handler object sending it a reference to this object 
        FocusHandler fh = new FocusHandler(this);
        
        // register (with the JVM) the handler for each textfield
        name.addFocusListener(fh); 
        salary.addFocusListener(fh); 
        mmHired.addFocusListener(fh);
    }
}
