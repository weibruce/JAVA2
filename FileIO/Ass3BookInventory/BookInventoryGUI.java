import java.awt.*;
import javax.swing.*;

/**
 * Write a description of class BookInventoryGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BookInventoryGUI extends JPanel
{
    protected String        ISBNNumber = "",
                            bookTitle = "";
    protected int           qoh = 0;
    protected double        bookPrice = 0;
    protected JPanel        northPanel,
                            southPanel;
    protected ISBNTextField isbnField;
    protected JTextField    titleField,
                            qohField,
                            priceField,
                            costField;
    protected JTextArea     centerArea;
    protected JButton       writeButton,
                            clearButton,
                            exitButton;
    protected BookInventoryHandler biHandler;

    /**
     * Constructor for objects of class BookInventoryGUI
     */
    public BookInventoryGUI()
    {
        setLayout(new BorderLayout());
        
        buildNorthPanel();
        buildSouthPanel();
        centerArea = new JTextArea(5,10);
        add(northPanel, BorderLayout.NORTH);
        add(centerArea, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
        
        biHandler = new BookInventoryHandler(this);
        writeButton.addActionListener(biHandler);
        clearButton.addActionListener(biHandler);
        exitButton.addActionListener(biHandler);
        
        isbnField.addFocusListener(biHandler);
        titleField.addFocusListener(biHandler);
        qohField.addFocusListener(biHandler);
        priceField.addFocusListener(biHandler);
    }
    
    private void buildNorthPanel()
    {
        northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(5,2));
        isbnField = new ISBNTextField();
        isbnField.setHorizontalAlignment(JTextField.RIGHT);
        titleField = new JTextField();
        titleField.setHorizontalAlignment(JTextField.RIGHT);
        qohField = new JTextField("0");
        qohField.setHorizontalAlignment(JTextField.RIGHT);
        priceField = new JTextField("0");
        priceField.setHorizontalAlignment(JTextField.RIGHT);
        costField = new JTextField();
        costField.setHorizontalAlignment(JTextField.RIGHT);
        costField.setEditable(false);
        
        northPanel.add(new JLabel("Enter ISBN-10 #:", JLabel.RIGHT));
        northPanel.add(isbnField);
        northPanel.add(new JLabel("Enter Title:", JLabel.RIGHT));
        northPanel.add(titleField);
        northPanel.add(new JLabel("Enter QOH:", JLabel.RIGHT));
        northPanel.add(qohField);
        northPanel.add(new JLabel("Enter Price:", JLabel.RIGHT));
        northPanel.add(priceField);
        northPanel.add(new JLabel("Inventory Cost:", JLabel.RIGHT));
        northPanel.add(costField);
    }
    
    private void buildSouthPanel()
    {
        southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        writeButton = new JButton("Write");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");
        southPanel.add(writeButton);
        southPanel.add(clearButton);
        southPanel.add(exitButton);
    }

    /**
     * This method calls a four-arg constructor of the BookInventory class 
     * passing the contents of the GUI textfields.
     */
    public BookInventory getBookValues()
    {
        //Create a BookInventory object
        BookInventory bi;
        ISBNNumber = isbnField.getText();
        bookTitle = titleField.getText();
        qoh = Integer.parseInt(qohField.getText());
        bookPrice = Double.parseDouble(priceField.getText());
        bi = new BookInventory(ISBNNumber, bookTitle, qoh, bookPrice);
        return bi;
    }
    
    /**
     * This method clears the contents of all data areas on the GUI. 
     */
    public void clearValues()
    {
        //Clear all text-fields
        isbnField.setText("");
        titleField.setText("");
        //Move zeros to the quantity and price fields
        qohField.setText("0");
        priceField.setText("0");
        costField.setText("");
        centerArea.setText("");
    }
}
