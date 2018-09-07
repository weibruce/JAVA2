import java.awt.*;
import java.util.Vector;
import java.sql.*;
import javax.swing.*;

/**
 * INPUT: table from the SIN2000 Database
 * PROCESSING: This class demonstrates how to create a JTable object populated
 * by data from a database. This application connects to an ACCESS database 
 * named SIN2000.mdb
 * OUTPUT: GUI showing a JTable that displays the result set of a DB sql query
 */
public class SINExample extends JFrame
{
    //connection object
    private Connection  connect;
    //used to display results of query
    private JTable      resultTable;

    /**
     * Constructor for objects of class SinExample
     */
    public SINExample()
    {
        final String    DRIVER = "com.mysql.jdbc.Driver",
                        //DRIVER= "sun.jdbc.odbc.JdbcOdbcDriver",
                        URL = "jdbc:mysql://localhost:3306/JDBC?useSSL=true";
                        //URL = "jdbc:odbc:sin2000";
                        
        try
        {
            // loads the driver
            Class.forName(DRIVER);
            System.out.println("Driver test success");
            // conencts to the database
            connect = DriverManager.getConnection(URL,"root","J5z8e5r5");
            System.out.println("Connection test success");
        }
        //catches error if driver does not load
        catch(ClassNotFoundException e)
        {
            System.err.println("Did not load JDBC/ODBC driver.");
            e.printStackTrace();
            System.exit(1);
        }
        //catches error if can not connect to database
        catch(SQLException e)
        {
            System.err.println("Unable to connect");
            e.printStackTrace();
            System.exit(1);
        }
        
        // Retrieve the database information
        getData();
        
        // Set JFrame parms & then pack
        setTitle("SIN table");
        setSize(450,150);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * defines the query and executes it
     */
    private void getData()
    {
        final String    SQL_QUERY = "SELECT FIRST,LAST,AGE,SIN FROM INFO";
        Statement       statement;
        ResultSet       resultSet;
        
        try
        {
            // Retrieve a statement object from the Connection object
            statement = connect.createStatement();
            
            // Get a ResultSet object from the Statement object by running the query
            resultSet = statement.executeQuery(SQL_QUERY);
            System.out.println("Run query test success");
            
            // translate the result set into a JTable
            showResult(resultSet);
            System.out.println("Show result test success");
            // Close the statement object
            statement.close();
        }
        catch(SQLException e)
        {
            System.out.println("Get Data");
            e.printStackTrace();
        }
    }
    
    /**
     * This method will accept a ResultSet object and transform the data in 
     * it into a JTable
     */
    private void showResult(ResultSet rs) throws SQLException
    {
        // The database pointer inside a ResultSet always starts BEFORE the first record. We must move to the next recorde
        boolean moreResult = rs.next();
        
        // If the next() call returns FALSE, no records were returned from the database
        if(!moreResult)
        {
            //JOptionPane.showMessageDialog(this, "No records");
            System.out.println("No records");
            return;
        }
        
        // Declare 2 Vectors which will be used to store the column headers and row information
        //heading for result table
        Vector  headings = new Vector();
        //rows of records from result set
        Vector  rows = new Vector();
        
        // Populate the headings Vector with the names of the Columns from the database
        headings.add("FIRST");
        headings.add("LAST");
        headings.add("AGE");
        headings.add("SIN");
        
        // Add JDBC commands must be in TRY / CATCH blocks to check for SQL Exceptions
        try
        {
            // Begin looping through ALL rows contained in the ResultSet object
            do
            {
                // The one line of code below performs a number of tasks
                // In the inner brackets, the custom getrow() method is called passing in the ResultSet object.
                // The getRow() method (see below) will create a Vector object with the column data of the CURRENT row of the ResultSet
                // That Vector object is added to the rows Vector.
                // The rows Vector is essentially a 2-Dimensional Array. It contains one
                // Vector for each row returned in the ResultSet AND each of those Vectors contains a Vector of the columns in that row.
                rows.add(getRow(rs));
            }
            // The rs.next() call will move the ResultSet to the next record until FALSE is returned, indicating no more rows
            while(rs.next());
            
            // Create the JTable Object, passing in the Vector of rows (2-Dimensional Vector containing ALL ResultSet data) and the Headings Vector containing Strings with the header names
            resultTable = new JTable(rows, headings);
            
            // Add a scroll pane to the table
            JScrollPane resultScrollPane = new JScrollPane(resultTable);
            // Add the JTable with ScrollPane to the JFrame Container
            getContentPane().add(resultScrollPane, BorderLayout.CENTER);
            
            // Validate will essentially repaint the window ensuring all objects are visible on the screen
            validate();
        }
        catch(SQLException e)
        {
            System.out.println("Show Result");
            e.printStackTrace(); 
        }
    }
    
    /**
     * The getRow method will create and return a Vector containing the 
     * column data of the CURRENT row that the passed in ResultSet object is 
     * pointing to
     */
    private Vector getRow(ResultSet rs) throws SQLException
    {
        //num. of fields (columns) in a row(record)
        final int   NUM_FIELDS = 4;
        // Create the new Vector object
        Vector      currentRow = new Vector();
        
        // Add a String to the Vector for each column in the ResultSet
        for(int i = 1; i <= NUM_FIELDS; i++)
        {
            if(i != 4)
            {
                currentRow.addElement(rs.getString(i));
            }
            else
            {
                currentRow.addElement(rs.getInt(i));
            }
            
        }
        
        // Return the Vector
        return currentRow;
    }
    
    /**
     * Close the database connection
     */
    public void shutDown()
    {
        try
        {
            connect.close();
        }
        catch(SQLException e)
        {
            System.err.println("Could not disconnect");
            e.printStackTrace();
        }
    }
    
    /**
     * In the main method, instantiate and run the JFrame object
     */
    public static void main(String[] args)
    {
        SINExample app = new SINExample();
    }
}
