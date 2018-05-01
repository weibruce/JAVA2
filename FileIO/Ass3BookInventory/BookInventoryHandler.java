import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DecimalFormat;
import javax.swing.*;

/**
 * This class implements an ActionListener to handle the GUI button events: 
 * Write, Clear, and Exit and implements a FocusListener to handle all 
 * data-entry text field events.
 */
public class BookInventoryHandler implements ActionListener, FocusListener
{
    private BookInventoryGUI    gui;
    private File                file;
    private ObjectOutputStream  outputStream;
    private DecimalFormat       df;
    private boolean             isbnValidated,
                                titleValidated,
                                qohValidated,
                                priceValidated;

    /**
     * Constructor for objects of class BookInventoryHandler
     */
    public BookInventoryHandler(BookInventoryGUI gui)
    {
        this.gui = gui;
        df = new DecimalFormat("$#,##0.00");
        isbnValidated = titleValidated = qohValidated = priceValidated = false;
        gui.writeButton.setEnabled(false);
        
        try
        {
            file = new File("Books.dat");
            outputStream = new ObjectOutputStream(new FileOutputStream(file));
        }
        catch(IOException e)
        {
            gui.centerArea.setText(e.getMessage());
        }
    }

    /**
     * ActionListener method
     */
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == gui.writeButton)
        {
            //create a BookInventory object by calling the appropriate method
            BookInventory bi;
            double cost = 0;
            bi = gui.getBookValues();
            cost = bi.getInvCost();
            //Calculate the Inventory cost
            gui.costField.setText(df.format(cost));
            
            //Write the object to the file
            try
            {
                outputStream.writeObject(bi);
                outputStream.flush();
                gui.centerArea.setText("Write the object to file successful.");
            }
            catch(IOException exce)
            {
                gui.centerArea.setText(exce.getMessage());
            }
        }
        else if(e.getSource() == gui.clearButton)
        {
            //Call the appropriate GUI method to clear all text-fields
            gui.clearValues();
            isbnValidated = titleValidated = qohValidated = priceValidated = false;
            gui.writeButton.setEnabled(false);
        }
        else if(e.getSource() == gui.exitButton)
        {
            //Close the data stream before exiting the application
            System.exit(0);
        }
    }
    
    /**
     * FocusListener method
     */
    public void focusLost(FocusEvent e)
    {
        if(e.getSource() == gui.isbnField)
        {
            //gui.centerArea.setText("isbnField focusLost");
            try
            {
                String isbn = gui.isbnField.getISBN();
                gui.centerArea.setText("Validate ISBN Successful");
                isbnValidated = true;
            }
            catch(ISBNException exce)
            {
                gui.centerArea.setText(exce.getMessage());
                isbnValidated = false;
            }
        }
        else if(e.getSource() == gui.titleField)
        {
            //gui.centerArea.setText("titleField focusLost");
            String title = gui.titleField.getText();
            if(title.equals(""))
            {
                gui.centerArea.setText("Please Enter Title");
                titleValidated = false;
            }
            else
            {
                gui.centerArea.setText("Validate Title Successful");
                titleValidated = true;
            }
        }
        else if(e.getSource() == gui.qohField)
        {
            //gui.centerArea.setText("qohField focusLost");
            try
            {
                int qoh = Integer.parseInt(gui.qohField.getText());
                gui.centerArea.setText("Validate QOH Successful");
                qohValidated = true;
            }
            catch(NumberFormatException exce)
            {
                gui.centerArea.setText("QOH must be numeric");
                qohValidated = false;
            }
        }
        else if(e.getSource() == gui.priceField)
        {
            //gui.centerArea.setText("priceField focusLost");
            try
            {
                double price = Double.parseDouble(gui.priceField.getText());
                gui.centerArea.setText("Validate Price Successful");
                priceValidated = true;
            }
            catch(NumberFormatException exce)
            {
                gui.centerArea.setText("Price must be numeric");
                priceValidated = false;
            }
        }
        validatedAll();
    }
    
    private void validatedAll()
    {
        if(isbnValidated && titleValidated && qohValidated && priceValidated)
        {
            gui.writeButton.setEnabled(true);
        }
        else
        {
            gui.writeButton.setEnabled(false);
        }
    }
    
    public void focusGained(FocusEvent e)
    {
        if(e.getSource() == gui.isbnField)
        {
            //gui.centerArea.setText("isbnField focusGained");
            gui.isbnField.selectAll();
        }
        else if(e.getSource() == gui.titleField)
        {
            //gui.centerArea.setText("titleField focusGained");
            gui.titleField.selectAll();
        }
        else if(e.getSource() == gui.qohField)
        {
            //gui.centerArea.setText("qohField focusGained");
            gui.qohField.selectAll();
        }
        else if(e.getSource() == gui.priceField)
        {
            //gui.centerArea.setText("priceField focusGained");
            gui.priceField.selectAll();
        }
    }
}
