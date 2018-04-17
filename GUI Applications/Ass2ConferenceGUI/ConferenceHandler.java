import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

/**
 * This class implements the ActionListener , ItemListener and FocusListener 
 * interfaces. The class will consist of a one one-arg constructor, four 
 * public methods, and one private method.
 */
public class ConferenceHandler implements ActionListener, ItemListener, FocusListener
{
    private ConferenceGUI   gui;
    private DecimalFormat   df;

    /**
     * Constructor for objects of class ConferenceHandler
     */
    public ConferenceHandler(ConferenceGUI gui)
    {
        this.gui = gui;
        df = new DecimalFormat("$#,##0.00");
    }
    
    // ActionListener motheds
    public void actionPerformed(ActionEvent e)
    {
        String  message = "";
        String  type = gui.regPanel.typeCombo.getSelectedItem().toString();
        String  name = gui.regPanel.nameField.getText();
        
        if(e.getSource() == gui.calculateButton)
        {
            //System.out.println(gui.regPanel.getRegType());
            if(gui.regPanel.typeCombo.getSelectedIndex() == 0)
            {
                //did not select the business type
                JOptionPane.showMessageDialog(null, 
                    "Please select a registration type", 
                    "Type Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                message = name + " is a " + type + " registration \n";
                //show keynote message
                if(gui.regPanel.getKeyNoteCost() == 0)
                {
                    message += "Keynote address will not be attended \n";
                }
                else
                {
                    message += "Keynote address will be attended \n";
                }
                
                //show workshops message
                String[] workshopList = gui.workshopPanel.getWorkshopList();
                if(workshopList.length == 0)
                {
                    message += ("\n" + name + " isn't registered any workshops. \n");
                }
                else
                {
                    message += ("\n" + name + " is registered in these workshops: \n");
                    for(int i = 0; i < workshopList.length; i++)
                    {
                        message += (workshopList[i] + "\n");
                    }
                }
                message += "\nTotal charges for " + name + " are " + df.format(calcTotalCharges());
            }
            gui.informationTextArea.setText(message);
        }
        else if(e.getSource() == gui.clearButton)
        {
            //clear message
            gui.regPanel.nameField.setText("");
            gui.regPanel.typeCombo.setSelectedIndex(0);
            gui.regPanel.speechCheck.setSelected(false);
            gui.workshopPanel.workshopList.clearSelection();
            gui.informationTextArea.setText("");
        }
    }
    
    private double calcTotalCharges()
    {
        double totalCharges = 0;
        totalCharges =  gui.regPanel.getRegistrationCost() + 
                        gui.regPanel.getKeyNoteCost() +
                        gui.workshopPanel.getWorkshopCost();
                        
        return totalCharges;
    }
    
    // ItemListener motheds
    public void itemStateChanged(ItemEvent e)
    {
        String  message = "";
        String  name = gui.regPanel.nameField.getText();
        String  type = gui.regPanel.typeCombo.getSelectedItem().toString();
        if(gui.regPanel.typeCombo.getSelectedIndex() != 0)
        {
            message = name + " is a " + type + " registration \n";
            gui.informationTextArea.setText(message);
        }
        else
        {
            gui.informationTextArea.setText("");
        }
    }
    
    // FocusListener motheds
    public void focusLost(FocusEvent e)
    {
        Font nameFont = new Font("Helvetica", Font.PLAIN, 14);
        gui.regPanel.nameField.setFont(nameFont);
        if(e.getSource() == gui.regPanel.nameField)
        {
            if(gui.regPanel.nameField.getText().length() == 0)
            {
                gui.regPanel.nameField.setText("Please enter a name");
                gui.regPanel.nameField.requestFocus();
                gui.regPanel.nameField.selectAll();
            }
        }
    }
    
    public void focusGained(FocusEvent e)
    {
        Font nameFont = new Font("Helvetica", Font.BOLD, 14);
        if(e.getSource() == gui.regPanel.nameField)
        {
            gui.regPanel.nameField.setFont(nameFont);
            gui.regPanel.nameField.selectAll();
        }
    }
}
