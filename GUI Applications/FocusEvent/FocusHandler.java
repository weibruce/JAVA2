import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Handler for text field events
 */
public class FocusHandler implements FocusListener
{
    String      name;
    int         salary, 
                month;
    FocusGUI    gui;

    /**
     * Constructor for objects of class FocusHandler
     */
    public FocusHandler(FocusGUI gui)
    {
        this.gui = gui;
    }

    public void focusLost(FocusEvent e)
    {
        if (e.getSource() == gui.name)
        {
            // Must enter a name
            if (gui.name.getText().length() == 0) 
            {
                gui.status.setText("You must enter a name");
                gui.name.requestFocus();
            }
            else
            {
                gui.status.setText("");
            }
        }
        else if (e.getSource() == gui.salary)
        {
            if (gui.salary.getText().length() > 0) 
            {
                salary = Integer.parseInt(gui.salary.getText()); 
                if ( salary < 20000 || salary > 50000 )
                {
                    gui.status.setText("Salary must be between $20000 and $50000");
                    gui.salary.requestFocus();
                }
                else
                {
                    gui.status.setText("");
                }
            }
        }
        else
        {
            if (gui.mmHired.getText().length() > 0) 
            {
                month = Integer.parseInt(gui.mmHired.getText()); 
                if ( month < 1 || month > 12 )
                {
                    gui.status.setText("Month Hired must be between 1 and 12");
                    gui.mmHired.requestFocus();
                }
                else
                {
                    gui.status.setText("");
                }
            }
        }
    }
    
    public void focusGained(FocusEvent e)
    {
        // Select the text of the appropriate textfield object
        JTextField text = (JTextField) e.getSource();
        
        text.selectAll();
    }
}
