import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

/**
 * Accept a variable referencing the JoesAutoGUI object
 * be responsible for storing the passed reference as a class variable
 */
public class JoesAutoHandler implements ActionListener
{
    final double            GST = 0.05;
    protected JoesAutoGUI   gui;
    
    private int             customers = 0;
    private double          routineCharges = 0.0;
    private double          nonroutineCharges = 0.0;
    private double          subTotal = 0.0;
    private double          tax = 0.0;
    private double          totalCharges = 0.0;

    /**
     * Constructor for objects of class JoesAutoHandler
     */
    public JoesAutoHandler(JoesAutoGUI gui)
    {
        this.gui = gui;
    }

    /**
     * This method that will handle all button events. Since there is more 
     * than one JButton invoking the handler, you must write a decision 
     * structure to determine which JButton was pressed.
     */
    public void actionPerformed(ActionEvent e)
    {
        DecimalFormat   df = new DecimalFormat("$#,##0.00");
        String          message = "";
        int             response;
        double          curRoutineCharges,
                        curNonroutineCharges,
                        curSubTotal,
                        curTax,
                        curTotalCharges;
        if (e.getSource() == gui.calculateButton)
        {
            curRoutineCharges = gui.routinePanel.getCharges();
            curNonroutineCharges = gui.nonRoutinePanel.getCharges();
            curSubTotal = curRoutineCharges + curNonroutineCharges;
            curTax = curSubTotal * GST;
            curTotalCharges = curSubTotal + curTax;
            message = "Routine Charges: " + df.format(curRoutineCharges) + "\n"+
                "Non-routine Charges: " + df.format(curNonroutineCharges) + "\n"+
                "Sub-total: " + df.format(curSubTotal) + "\n"+
                "Tax: " + df.format(curTax) + "\n"+
                "Total: " + df.format(curTotalCharges) + "\n";
            
            //showConfirmDialog
            //DEFAULT_OPTION        for a single OK button
            //OK_CANCEL_OPTION      for OK and Cancel buttons
            //YES_NO_CANCEL_OPTION  for Yes, No, and Cancel buttons
            //YES_NO_OPTION         for Yes and No buttons
            response = JOptionPane.showConfirmDialog(null, message, 
                "Confirm Customer Receipt", 
                JOptionPane.OK_CANCEL_OPTION, 
                JOptionPane.INFORMATION_MESSAGE);
            
            if (response == JOptionPane.OK_OPTION)
            {
                //System.out.println("ok");
                customers ++;
                routineCharges += curRoutineCharges;
                nonroutineCharges += curNonroutineCharges;
                tax += curTax;
                totalCharges += curTotalCharges;
                gui.summaryPanel.setTotalCustomers(Integer.toString(customers));
                gui.summaryPanel.setTotalRoutineCharges(df.format(routineCharges));
                gui.summaryPanel.setTotalNonroutineCharges(df.format(nonroutineCharges));
                gui.summaryPanel.setTotalTaxes(df.format(tax));
                gui.summaryPanel.setTotalCharges(df.format(totalCharges));
                gui.tabbedPane.setSelectedIndex(1);
            }
        }
        else if (e.getSource() == gui.exitButton)
        {
            System.exit(0);
        }
    }
}
