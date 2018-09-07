import java.awt.*;
import javax.swing.*;

/**
 * Input:       None
 * Processing:  Creates a JTable populated with a 2 dimensional array
 * Output:      Displays a JTable in a JFrame window
 */
public class TableFrame extends JFrame
{
    private Container   c;
    private JScrollPane displayPane;
    private JTable      sinTable;

    /**
     * Constructor for objects of class FrameTable
     */
    public TableFrame()
    {
        c = getContentPane();
        
        // Create arrays to populate the table’s column headings, and data
        String  colHeaders[] = {"First Name","Last Name","Age", "SIN"},
                tableData[][] = {{"Dewey",  "Cheatum",  "25",   "634789987"},
                                {"Anna",    "Konda",    "32",   "634589987"},
                                {"Miss",    "Treeman",  "55",   "634789123"},
                                {"Robin",   "Steele",   "16",   "658789987"},
                                {"Beau",    "Gus",      "76",   "634789987"},
                                {"Heidi",   "Ho",       "29",   "634679987"},
                                {"Daryl",   "Lect",     "47",   "634671124"},
                                {"Hazel",   "Nutt",     "39",   "634279824"},
                                {"Oliver",  "Sudden",   "64",   "634789987"},
                };
                
        // Creates the table
        sinTable = new JTable(tableData, colHeaders);
        
        // Adds the table to the scroll pane
        displayPane = new JScrollPane (sinTable);
        // Adds the scroll pane to the container
        c.add(displayPane,BorderLayout.CENTER);
        // Sets the frame size, title and makes it show up.
        setTitle("Table in a Frame");
        setSize(400,150);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * creates an instance of the frame
     */
    public static void main(String[] args)
    {
        TableFrame app = new TableFrame();
    }
}
