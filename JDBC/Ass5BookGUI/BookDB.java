import java.sql.*;
import java.awt.*;
import javax.swing.*;

/**
 * This class is responsible for all database functions. 
 * It will contain the following static methods (All methods must use 
 * try/catch blocks around all database operations):
 */
public class BookDB
{
    private final static String DRIVER = "com.mysql.jdbc.Driver",
                                URL = "jdbc:mysql://localhost:3306/JDBC?useSSL=true";
    private static Connection   connect;
    
    /**
     * This method accepts no arguments and returns no data.
     * Responsible for loading the driver and connecting to the database.
     * Print out the appropriate exceptions messages if the driver cannot be 
     * loaded or you can’t connect to the database and terminate the application.
     */
    public static void connect()
    {
        try
        {
            Class.forName(DRIVER);
            connect = DriverManager.getConnection(URL,"root","J5z8e5r5");
        }
        catch(ClassNotFoundException e)
        {
            System.err.println("BookDB.initialize() - Did not load JDBC/ODBC driver.");
            e.printStackTrace();
            System.exit(1);
        }
        catch(SQLException e)
        {
            System.err.println("BookDB.initialize() - Unable to connect");
            e.printStackTrace();
        }
    }
    
    /**
     * This method accepts a JCombobox object and returns no data.
     * Responsible for querying the database for a resultset containing all 
     * ISBN numbers only.
     * Execute the appropriate SQL statement to retrieve just the ISBN numbers 
     * from the database.
     * Take the resulting resultset and call the addISBN method(defined below). 
     * Close the statement object.
     */
    public static void loadCombo(JComboBox comboBox)
    {
        final String    SQL_QUERY = "SELECT ISBN FROM Books";
        Statement       statement;
        ResultSet       rs;
        
        try
        {
            statement = connect.createStatement();
            rs = statement.executeQuery(SQL_QUERY);
            addISBN(rs, comboBox);
            statement.close();
        }
        catch(SQLException e)
        {
            System.err.println("BookDB.loadCombo() - query database error.");
            e.printStackTrace();
        }
    }

    /**
     * This private method accepts a ResultSet and JComboBox objects passed 
     * from the loadCombo method above and returns no data.
     * Responsible for retrieving each ISBN number from the result set and 
     * adding it into the JComboBox.
     */
    private static void addISBN(ResultSet rs, JComboBox cb) throws SQLException
    {
        while(rs.next())
        {
            String isbn = rs.getString(1);
            cb.addItem(isbn);
            System.out.println(isbn);
        }
        
    }
    
    /**
     * 
     */
    public static BookInventory queryBook(String isbn)
    {
        BookInventory   bi = null;
        final String    SQL_QUERY = "SELECT * FROM Books WHERE ISBN =" + isbn;
        Statement       statement;
        ResultSet       rs;
        String          biIsbn = "";
        String          biTitle = "";
        int             biQoh = 0;
        double          biPrice = 0;
        
        if(isbn != "")
        {
            try
            {
                System.out.println("queryBook");
                statement = connect.createStatement();
                rs = statement.executeQuery(SQL_QUERY);
                rs.next();
                biIsbn = rs.getString(1);
                biTitle = rs.getString(2);
                biQoh = rs.getInt(3);
                biPrice = rs.getDouble(4);
                bi = new BookInventory(biIsbn, biTitle, biQoh, biPrice);
                System.out.println(bi.getBookPrice());
                statement.close();
            }
            catch(SQLException e)
            {
                System.err.println("BookDB.queryBook() - query database error.");
                e.printStackTrace();
            }
        }
        
        return bi;
    }
    
    public static void close()
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
}
