import javax.swing.JOptionPane;
import java.text.DecimalFormat;

/**
 * Message Type:
 * JOptionPane.ERROR_MESSAGE        X StopSign  Displays a dialog indicating an error.
 * JOptionPane.INFORMATION_MESSAGE  ! Mark      Information message.
 * JOptionPane.WARNING_MESSAGE      ! Yieldsign Warns of potential problem.
 * JOptionPane.QUESTION_MESSAGE     ? Mark      Poses a question. User selects yes or no.
 * JOptionPane.PLAIN_MESSAGE        No icon     Message.
 * 
 * Option Type:
 * JOptionPane.DEFAULT_OPTION       for a single OK button
 * JOptionPane.OK_CANCEL_OPTION     for OK and Cancel buttons
 * JOptionPane.YES_NO_OPTION        for Yes and No buttons
 * JOptionPane.YES_NO_CANCEL_OPTION for Yes, No, and Cancel buttons
 */
public class JOptionPanePayroll
{
    
    public static void main2 (String[] arg)
    {
        JOptionPane.showMessageDialog(null, "Have a Good day", 
            "Message title", JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showInputDialog("Enter your name");
        JOptionPane.showConfirmDialog(null, "Choose one", 
            "Confirm title", JOptionPane.CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        //System.exit(0);
    }
    
    public static void main (String[] arg)
    {
        String  inputString,    // For reading input
                name;           // The user's name
        int     hours;          // The number of hours worked
        double  payRate,        // The user's hourly pay rate
                grossPay;       // The user's gross pay
        int     response;       // Enter more payroll info
        
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        
        do
        {
            // Get the user's name.
            name = JOptionPane.showInputDialog("Enter your name: ");
            // Get the hours worked.
            inputString = JOptionPane.showInputDialog("Enter hours worked: ");
            // Convert the input to an int.
            hours = Integer.parseInt(inputString);
            // Get the hourly pay rate.
            inputString = JOptionPane.showInputDialog("Enter hourly rate of pay: ");
            // Convert the input to a double.
            payRate = Double.parseDouble(inputString);
            // Calculate the gross pay.
            grossPay = hours * payRate;
            
            // Display the results.
            JOptionPane.showMessageDialog(null,
                "Hello " + name + ".\n\n Your gross pay is " + df.format(grossPay),
                "Calculated Pay",
                JOptionPane.INFORMATION_MESSAGE);

            response = JOptionPane.showConfirmDialog(null,
                "Do you wish to enter more payroll data?",
                "Confirm entry",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        }
        while(response == JOptionPane.OK_OPTION);
        
        // End the program if the user does not click OK button.
        System.exit(0);
    }
}
