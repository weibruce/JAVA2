import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Vector;

/**
 * STEREOTYPE: 'Boundary' class. It creates a GUI to I/F the appl'n to the user
 * INPUT: None
 * PROCESSING: This class is the GUI component of the CourseListAPP Application.
 *      It uses the ParseResultSet class to parse the Columns and Row 
 *      information, from a ResultSet object, to create a JTable component 
 *      on a Frame 
 * OUTPUT: Displays the result set in a JTable
 */
public class CourseListGUI extends JPanel
{
    // Declare reference variables to the JTable and ParseResultSet class
    JTable          resultTable;
    ParseResultSet  parseResultSet;

    /**
     * Constructor for objects of class CourseListGUI
     */
    public CourseListGUI(ResultSet rs)
    {
        setLayout(new BorderLayout());
        
        // Create a ParseResultSet object to get the column heading and row Vectors
        parseResultSet = new ParseResultSet(rs);
        
        // Retrieve the vectors from the ParseResultSet object
        Vector  heading = parseResultSet.getColHeadings(),
                rows = parseResultSet.getRows();
        
        // Instantiate the JTable based on the retrieved Vectors
        resultTable = new JTable(rows, heading);
        // Add Scroll Bars to the JTable
        JScrollPane resultScrollPane = new JScrollPane(resultTable);
        
        // Add the JTable to the Panel
        add(resultScrollPane,   BorderLayout.CENTER);
    }
}
