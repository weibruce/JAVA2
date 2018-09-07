import java.awt.*; 
import javax.swing.*;

/** STARTER CODE
 * Assignment #5 - JDBC   Question 1  (Book Query)
 * Class:       BookGUI
 * Inherits:    JPanel                   i.e. BookGUI "is a" JPanel
 * Stereotype:  "Boundary" class        (appl'n interface to an actor - the user)
 * Purpose:     Provides a GUI  which allows a user to select a book from a Book
 *                  Inventory DB, via the book's ISBN, and view the book's inventory
 *                  status.
 *                  It also instantiates the event handler, BookHandler (a "Control" class),
 *                  that will perform the business logic -  opening & closing the DB,
 *                  accessing a book from the book inventory DB & updating BookGUI's display.
 * Input:       Selecting a book via its ISBN, from a JComboBox list.
 * Output:      Display book's inventory status:
 *              ISBN, Title, Qty on hand, unit Price, calculated Cost (Qty x unit Price)
 */

public class BookGUI extends JPanel   //starter file
{
    //Instance vars
    protected JComboBox  isbn;
    protected JTextField title, qoh, price, invCost;

    //Instance methods
    /**
      * Default constructor to setup the JPanel
      */
    public BookGUI()
    {
        // create combobox & text fields & make nonEditable
        isbn     = new JComboBox();
        isbn.setEditable(false);
    
        title  = new JTextField();
        title.setEditable(false);
        qoh    = new JTextField();
        qoh.setEditable(false);
        qoh.setHorizontalAlignment(JTextField.RIGHT);
        price  = new JTextField();
        price.setEditable(false);
        price.setHorizontalAlignment(JTextField.RIGHT);
        invCost= new JTextField();
        invCost.setEditable(false);
        invCost.setHorizontalAlignment(JTextField.RIGHT);
    
        //set JPanel layout & populate with components
        setLayout(new GridLayout(5,2));
    
        add(new JLabel("ISBN #: ",        JLabel.RIGHT));
        add(isbn);
        add(new JLabel("Title:  ",        JLabel.RIGHT));
        add(title);
        add(new JLabel("Quantity: ",      JLabel.RIGHT));
        add(qoh);
        add(new JLabel("Price:  ",        JLabel.RIGHT));
        add(price);
        add(new JLabel("Inventory Cost: ",JLabel.RIGHT));
        add(invCost);
    }// end constructor

}  // end method

