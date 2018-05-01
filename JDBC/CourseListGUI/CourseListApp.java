import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

/**
 * Stereotype: is both a 'boundary' AND a 'control' class
 * Purpose: This class is the application client class.
 *      1 Provides a window GUI interface to the user. It will instantiate 
 *      itself as a JFrame application, and add the GUI component to its Container.
 *      2 It contains the main method that executes a DB query.
 *      3 It also closes the data base, gracefully, when it's window (JFrame) 
 *      is closed & exited.
 * Input: a database table
 * Output: Displays the the DB table in a GUI
 */
public class CourseListApp extends JFrame
{
    private final static String QUERY = "SELECT * FROM INFO";
    private Container           c = getContentPane();
    private CourseListGUI       gui;
    

    /**
     * Constructor for objects of class CourseListApp
     */
    public CourseListApp()
    {
        c.setLayout(new GridLayout(1,1));
        // Initialize the database connection
        CourseDatabase.initialize();
        // Run the passed in query to get the result set
        ResultSet rs = CourseDatabase.runQuery(QUERY);
        // Pass the retrieved result set as a constructor to the GUI panel to create the JTable
        gui = new CourseListGUI(rs);
        // Add the panel to the frame
        c.add(gui);
        
        //JFrame settings
        // Set the window to fit the GUI
        setTitle ("Course List - Add Record to SIN Table");
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public static void main(String[] args)
    {
        CourseListApp app = new CourseListApp();
        
        //Shut down the DB gracefuly, when the user closes this window (JFrame)
        app.addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                    CourseDatabase.close();
                    System.exit(0);
                }
            });
    }
}
