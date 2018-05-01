import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;

/** STARTER CODE
* Assignment #5 - JDBC - Question 1  (Book Query)
* Purpose:      Query a book inventory DB (MS Access) named "Books.mdb". It will select
*                   a book via its ISBN number (PK), to view the book's inventory status.
* Output:       Displays a selected book's inventory status: i.e..
*                   Book ISBN, Title, Qty on hand, unit Price, and calculuted Cost (Qty x Price)
*
* Class:        BookClient
* Inherits:     JFrame                  i.e.. BookClient "is a" JFrame
* Stereotype:   "Boundary" class        (appl'n interface to an external actor - the user)
* Purpose:      This class is the client component to run the Book Query application.
*               It creates a JFrame window object, then adds a GUI (BookGUI) object that
*   .           defines the user's active GUI (a JPanel allowing input / output).
*/

public class BookClient extends JFrame  //Starter file
{
    //Instance vars:
    // Get the reference to the container, and declare the GUI reference variable
    private Container c;
    private BookGUI   gui;
    
    //Instance method:
    /**
    Constructor to add the GUI JPanel to the JFrame
    */
    public BookClient()
    {
        c = getContentPane();
        gui = new BookGUI(); // Instantiate the GUI class
        // Add the GUI to the container
        c.add(gui);
        
        // conntect Books database
        BookDB.connect();
        BookDB.loadCombo(gui.isbn);
        
        BookDB.queryBook("1-55054-891-3");
    
        // Set the JFrame attributes
        setSize(450,200);
        setTitle("Book Query");
        setVisible(true);
    }

    //Class method main()
    /**
    * Instantiate the JFrame application in the main method
    */
    public static void main(String args[])
    {
        final BookClient app = new BookClient();
        app.addWindowListener
        (
            new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                    BookDB.close();
                    System.exit(0);
                }
            }
        );
    }// end main

}// end class BookClient