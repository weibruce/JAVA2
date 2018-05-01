import java.sql.*;

/**
 * STEREOTYPE: ‘Boundary' class. It I/Fs the appl'n to a database (an external agent)
 * INPUT: a query
 * PROCESSING: This class is the database component of the CourseListAPP 
 *      Application. It contains the code required to connect to and manipulate 
 *      the database It is a static class (doesn't need to be instantiated) that
 *      1. Initialize the DB: load DB driver and connect to the DB 
 *      2. Run a query and return a result set
 *      3. Close the DB
 * OUTPUT: Returns a query result set
 */
public class CourseDatabase
{
    private final static String DRIVER = "com.mysql.jdbc.Driver",
                                URL = "jdbc:mysql://localhost:3306/JDBC?useSSL=true";
    private static Connection   connect;
    private static Statement    statement;
    
    /**
     * Initialize class to initially load the ODBC driver and connect to the 
     * database. This method must be called before any others
     */
    public static void initialize()
    {
        try
        {
            Class.forName(DRIVER);
            connect = DriverManager.getConnection(URL, "root", "J5z8e5r5");
            statement = connect.createStatement();
        }
        //catches exception thrown when driver is not loaded
        catch(ClassNotFoundException e)
        {
            System.err.println("Did not load JDBC/ODBC driver.");
            e.printStackTrace();
            System.exit(1);
        }
        catch(SQLException e)
        {
            System.err.println("Unable to connect to database.");
            e.printStackTrace();
        }
    }

    /**
     * This method will run the passed in query on the database and return 
     * the result set
     */
    public static ResultSet runQuery(String query)
    {
        // ResultSet object for query
        ResultSet resultSet = null;
        
        try
        {
            resultSet = statement.executeQuery(query);
        }
        catch(SQLException e)
        {
            System.err.println("\nQuery terminated abnormally!\n" + query);
            e.printStackTrace();
        }
        
        return resultSet;
    }
    
    /**
     * Close the connection
     */
    public static void close()
    {
        try
        {
            statement.close();
            connect.close();
        }
        catch(SQLException e)
        {
            System.err.println("Could not disconnect");
            e.printStackTrace();
        }
    }
}
